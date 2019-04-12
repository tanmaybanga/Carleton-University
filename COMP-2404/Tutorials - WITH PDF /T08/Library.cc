#include<iostream>

using namespace std;

#include "Library.h"

Library::Library(){
   arr = new List();
   // currBooks = 0;
}
Library::~Library(){
    delete arr;
}

void Library::addBook(Book* kitaab){
    arr->add(kitaab);
}


void Library::print(){
        arr->print();
}

