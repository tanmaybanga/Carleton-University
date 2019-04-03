#include<iostream>

using namespace std;

#include "Library.h"

Library::Library(){
   // currBooks = 0;
}
Library::~Library(){
}

void Library::addBook(Book* kitaab){
    arr.add(kitaab);
    //arr->add(kitaab);
}

void Library::copyBooks(Array& list){
    arr.copy(list);
}


void Library::print(){
        arr.print();
}
