#include "Allocator.h"

#include <iostream>
#include <cstring>

using namespace std;


Allocator::Allocator(size_t size) {
    if (size < sizeof(Header)) {
        throw bad_alloc();
    }

    this->memory_pool = new char[size];
    this->start = new (memory_pool) Header(size);

    cout << "Created memory = " << size << " of bytes\n";
}

void Allocator::dump() {
    cout << "Memory dump\nMemory Pool: " << static_cast<void*>(this->memory_pool) << endl;
	Header* current = this->start;
	while (current) {
		cout << "current =" << current << ", length= " << current->size << " , isFree= " << current->isFree << endl;
		current = current->right;
	}
}

Header* Allocator::header_alloc(size_t size) {
    size_t AllocSize = (size / LONGINTSIZE + (size % LONGINTSIZE ? 1 : 0)) * LONGINTSIZE;
    AllocSize += sizeof(Header);

    Header* current = this->start;
	while (current) {
		if (current->isFree && current->size == AllocSize) {
			current->isFree = false;
			return (Header*)((char*) (current) + sizeof(Header));
		} 
        if (current->isFree && current->size >= AllocSize) {
            //spliting bigger memory block into smaller
			size_t blockSize = current->size;

			Header* left = current->left;
			Header* right = current->right;
			
            // divide current block into 2 new blocks
			Header* first = new (current) Header(AllocSize);
			Header* next = new (current + size) Header(blockSize - AllocSize);
			
            // chenging links
			first->left = left;
			first->right = next;

			next->left = first;
			next->right = right;

			return (Header*)((char*) (first) + sizeof(Header));
		}
        current = current->right;
	}
	return nullptr;
}

Header* Allocator::header_realloc(Header *cursor, size_t size) { //check

    free(cursor);

    return header_alloc(size);
}

Header* Allocator::merge(Header *left, Header *right) {

    Header* mergedBlock = new (left) Header( 
        left->size + right->size, 
        true,
        left->left,
        right->right
	);

    if (left) {
        left->left = mergedBlock;
    }
    
    if (right) {
        right->right = mergedBlock;
    }
	
    return mergedBlock;
}


void Allocator::free(Header* cursor) {
    
    if (cursor == nullptr) {
		return;
	}

	char* addr = (char*)cursor - sizeof(Header);
	Header* deallocate = ((Header*) addr);
    
    if (deallocate->isFree) {
        return;
    }
	
    deallocate->isFree = true;
	cout << "Addr: " << (Header*) addr << endl;

	// merge next to headers if they are free
	if (deallocate->left && deallocate->left->isFree) {
		deallocate = merge(deallocate->left, deallocate);
	}

	if (deallocate->right && deallocate->right->isFree) {
		deallocate = merge(deallocate, deallocate->right);
	}
}
