#include<iostream>
using namespace std;

#include "NonFictionBook.h"

NonFictionBook::NonFictionBook(int id, string call_no, string title, string author, int year)
:Book(id, call_no, title, author, year)
{  }
bool NonFictionBook:: operator<(Book* novel){
    return (this->getCallNo() < novel->getCallNo());
}

NonFictionBook::~NonFictionBook(){

}
