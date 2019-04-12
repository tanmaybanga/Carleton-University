#ifndef ARRAY_H
#define ARRAY_H

#include "Book.h"

#define MAX_ARR_SIZE 128
class Array{
    private:
        Book* elements[MAX_ARR_SIZE];
        int size;
    public:
        Array();
        ~Array();
        void add(Book*);
        void print();
};
#endif
