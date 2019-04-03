#ifndef LIBRARY_H
#define LIBRARY_H
#include "Array.h"

class Library
{   
    Array arr;
    
    public :
        Library();
        void  addBook(Book*);
        void print();
};
#endif
