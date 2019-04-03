#include <iostream>
using namespace std;

#include "Library.h"

void Library::addBook(Book* book){
    books.add(book);
}

void Library::print(){
    cout << endl;
    books.print();
}
