#pragma once

#include <stdlib.h>
#include "Memory.h"

using namespace std;

class Allocator {
    private:
        char *memory_pool;
        Header* start;

    protected:
        Header* merge(Header* left, Header* right);

    public:
        Allocator(size_t size);
        Header* header_alloc(size_t size);
        Header* header_realloc(Header *cursor, size_t size);
        void dump();
        void free(Header* cursor);
};
