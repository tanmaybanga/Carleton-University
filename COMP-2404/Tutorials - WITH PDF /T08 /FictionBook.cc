#include<iostream>
using namespace std;

#include "FictionBook.h"

FictionBook::FictionBook(int id, string title, string author, int year, string call_no)
   : Book(id, title, author, year, call_no)
   {}

bool FictionBook::lessThan(Book* novel){
    return (getAuthor() < novel->getAuthor());
}

FictionBook::~FictionBook(){

}
