#include<iostream>                                                                                  
using namespace std;                                                                                
                                                                                                    
#include "NonFictionBook.h"                                                                            
                                                                                                    
NonFictionBook::NonFictionBook(int id, string title, string author, int year, string call_no)                                                           
:Book(id, title, author, year, call_no)                                                                             
{  }    
bool NonFictionBook:: lessThan(Book* novel){
    return (getCallNo() < novel->getCallNo());
}

NonFictionBook::~NonFictionBook(){

}
