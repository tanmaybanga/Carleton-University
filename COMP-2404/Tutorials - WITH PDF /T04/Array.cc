
#include <iostream>
#include <iomanip>
using namespace std;
#include "Library.h"
#include "Book.h"
#include "Array.h"

Array::Array (){

  // Book books[MAX_SIZE_ARRAY];

  size=0;

}

Array::~Array(){

    for(int i =0;i<size;i++)
    {
        delete elements[i];
    }

}



void Array::add(Book *b){

    Book *temp[MAX_ARR_SIZE];
    if (size == 0)
    { // nothing in the array
        elements[size] = b;
    }
    else
    {
        for(int i =0;i<size;i++){
            
            if(b->lessThan(elements[i]) ==true){
            
                for(int j = 0 ;j< i;j++){
                    temp[j] = elements[j];
                  }
                for(int j = i+1; j <size+1;j++){
                    temp[j] = elements[j-1];
                }
                temp[i] = b;

                for(int j =0;j <size+1;j++){
                    elements[j] = temp[j];

                }
            
                break;
            }else{
                elements[size] = b;

            }
        }
    }    
size++;


}



void Array::print()

{

  for (int i=0;i < size ; i++){

    elements[i]->print();
  }

}



