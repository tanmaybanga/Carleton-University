#ifndef LIBRARY_H
#define LIBRARY_H

#include <string>
#include "Book.h"
#include "List.h"
using namespace std;

class Library 
{  
    public:
        void addBook(Book* book);
        void print();
    private:
        List books;
};

#endif
