#ifndef LIBRARY_H
#define LIBRARY_H

#include "Book.h"
#include "Array.h"
#include "List.h"

//#define MAX_ARR_SIZE 128

class Library{
    private:
       // Book arr[MAX_ARR_SIZE];
       // int currBooks;
      // Array* arr;
      List <Book*> arr;
    public:
        Library();
        ~Library();
        void addBook(Book*);
        void print();
        void copyBooks(Array&);
};
#endif
