#ifndef NONFICTIONBOOK_H                                                                               
#define NONFICTIONBOOK_H                                                                               

#include "Book.h"

class NonFictionBook : public Book{                                                                    
    public:
        NonFictionBook(int, string, string, int, string);      
        bool lessThan(Book*); 
        ~NonFictionBook();                                                                                                    
};
#endif        
