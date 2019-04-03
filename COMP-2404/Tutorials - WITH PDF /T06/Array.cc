#include <iostream>
using namespace std;

#include "Array.h"

Array::Array(){
    size = 0;
}

Array::~Array(){
    for(int i = 0; i < size; i++){
        delete elements[i];
    }
}

void Array::addBook(Book* book){
    int temp = 0;
    if(size == 0){
           elements[0] = book;
           size++;
       }
    else{
        int i = size - 1;
        int j = size;

           for(int a = 0; a < size; a++){
               if(elements[a]->lessThan(book)){
                   temp = a;
                   break;
               }
           }

           while(i >= temp){
               elements[j] = elements[i];
               i--;
               j--;
           }

           elements[temp] = book;
           size++;
       }
}

void Array::print(){
    for(int i = 0; i < size; i++){
        elements[i]->print();
    }
}