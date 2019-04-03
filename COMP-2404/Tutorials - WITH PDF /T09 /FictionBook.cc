#include<iostream>
using namespace std;

#include "FictionBook.h"

FictionBook::FictionBook(int id,string call_no, string title, string author, int year)
   : Book(id, call_no, title, author, year)
   {}

bool FictionBook::lessThan(Book* novel){
    return (getAuthor() < novel->getAuthor());
}

FictionBook::~FictionBook(){

}
