#include<iostream>                                                                                  
using namespace std;                                                                                
                                                                                                    
#include "NonFictionBook.h"                                                                            
                                                                                                    
NonFictionBook::NonFictionBook(int id, string call_no, string title, string author, int year)                                                           
:Book(id, call_no, title, author, year)                                                                             
{  }    
bool NonFictionBook:: lessThan(Book* novel){
    return (getCallNo() < novel->getCallNo());
}

NonFictionBook::~NonFictionBook(){

}
