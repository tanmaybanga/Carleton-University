#include<iostream>
using namespace std;

#include "Array.h"

Array::Array(){
    size = 0;
}

Array::~Array(){
    for(int i=0 ;i<size ; i++)
        delete elements[i];
}

void Array::add(Book* kitaab){
    bool p = false;
    for(int i=0; i<size; i++)
    {
        if(kitaab->lessThan(elements[i])){
            for(int j = size ; j>i; j--)
                elements[j] = elements[j-1];
            elements[i] = kitaab;
            p=true;
            break;
        }
    }
    if(p == false)
        elements[size] = kitaab;
    ++size;
}

void Array::print(){
    for(int i=0; i < size; i++){
        elements[i]->print();
    }
}
