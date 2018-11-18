#include <iostream>
#include "Allocator.h"

using namespace std;

const int MEMORY_SIZE = 1048576; // 2^20 = 1 Mb

bool allocObject(Allocator &allocator) {
    Header* pool = allocator.header_alloc(LONGINTSIZE);
    auto *value = new(pool) (LONGINT)(1);

    return *value == (LONGINT) (1);
}

bool allocArray(Allocator &allocator) {
    int array_size = 64;
    Header* pool = allocator.header_alloc(sizeof(short) * array_size);
    short *arr = new(pool) short[array_size];

    for (int i = 0; i < array_size; i++) {
        arr[i] = (short) i;
    }

    allocator.dump();    

    return true;
}

bool freeMemory(Allocator &allocator) {

    Header* pool = nullptr;
    allocator.free(pool);

    pool = allocator.header_alloc(sizeof(short) * 64);
    short *arr = new(pool) short[64];

    for (int i = 0; i < 64; i++) {
        arr[i] = (short) i;
    }
    allocator.dump();

    allocator.free(pool);

    return true;
}

bool isBetterThanMalloc(Allocator &allocator) {

    Header* arr[10];
    for (int i = 0; i < 10; i++) {
        if (i % 2) {
            arr[i] = allocator.header_alloc(sizeof(short) * 100);
        } else {
            arr[i] = allocator.header_alloc(sizeof(short) * 50);
        }
    }

    for (int i = 0; i < 10; i++) {
        if (i % 2) {
            allocator.free(arr[i]);
        }
    }

    allocator.dump();    
    allocator.free(arr[0]);


    Header* pool = allocator.header_alloc(sizeof(short) * 100);
    allocator.free(pool);
    pool = allocator.header_alloc(sizeof(short) * 50);
    allocator.free(pool);


    for (int i = 0; i < 10; i++) {
        allocator.free(arr[i]);
    }

    return true;
}


bool allocMoreThanPossible(Allocator &allocator) {
    Header* pool = nullptr;
    pool = allocator.header_alloc(MEMORY_SIZE + 1024);

    return pool == nullptr;
}

void it(bool test, const char *name) {
    if (test) {
        cout << "Test" << name <<" WORKS" << endl;
        return;
    }
    cout << "Test" << name <<" FAILED" << endl;
}

//---------------------------------------------------
int main() {
    Allocator allocator = Allocator(MEMORY_SIZE);
    cout << "Start \n";

    it(allocObject(allocator), "allocObject(allocator) TRUE");
    it(allocArray(allocator), "allocArray(allocator) TRUE");
    it(freeMemory(allocator), "freeMemory(allocator TRUE");
    it(isBetterThanMalloc(allocator), "isBetterThanMalloc(allocato) TRUE");
    it(allocMoreThanPossible(allocator), "TRUE");

    allocator.dump();
    cout << "End";
    return 0;
}

