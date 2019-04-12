#include<iostream>
#include<locale>
using namespace std;

#include "Control.h"
#include "NonFictionBook.h"
#include "FictionBook.h"

Control::Control(){
    library = new Library();
    lounge = new Library();
}

Control::~Control(){
    delete library;
    delete lounge;
}

void Control::launch(){
   int menuSelection;
    while (1) {
     menuSelection = -1;
     v.mainMenu(menuSelection);

    if (menuSelection == 0)
      break;
    else if (menuSelection == 1) {
        int id, year;
        string title, author, type,call_no;
        Book* temp;
        v.readBookType(type);
        v.readBook(id, title, author, year, call_no);
        if(type== "Fiction"){
            temp = new FictionBook(id, title, author, year, call_no);
            library->addBook(temp);
        }
        else{
            temp = new NonFictionBook(id, title, author, year, call_no);
            lounge->addBook(temp);
        }
    }
   }
   cout<<"FICTION LIBRARY :\n";
   v.printLibrary(library);
   cout<<"NON FICTION LIBRARY:\n";
   v.printLibrary(lounge);
}

