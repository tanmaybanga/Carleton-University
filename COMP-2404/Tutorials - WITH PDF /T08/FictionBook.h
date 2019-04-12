#ifndef FICTIONBOOK_H
#define FICTIONBOOK_H

#include "Book.h"

class FictionBook : public Book{
    public:
        FictionBook(int,string,string,int, string);    
        bool lessThan(Book*);
        ~FictionBook();
};
#endif
