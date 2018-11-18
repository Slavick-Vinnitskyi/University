#pragma once

typedef long int LONGINT;
#define LONGINTSIZE sizeof(LONGINT)

class Header {
public:
    Header *left;
    Header *right;
    bool isFree;
    size_t size;
    Header(size_t size, bool isFree = true, Header* left = nullptr, Header* right = nullptr) {
        this->left = left;
        this->right = right;
        this->isFree = isFree;
        this->size = size;
    };
};

