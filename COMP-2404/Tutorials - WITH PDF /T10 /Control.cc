#include<iostream>
#include<locale>
using namespace std;

#include "Control.h"
#include "NonFictionBook.h"
#include "FictionBook.h"

Control::Control(){
    fiction = new Library();
    nonfiction = new Library();
    
    bk = new BookServer();
    Array a1;
    Array a2;

    bk->retrieve(a1,a2);

    for(int i=0; i < a1.getSize() ; i++)
    {
        fiction->addBook(a1.get(i));
    }
    for(int j=0; j < a2.getSize(); j++)
    {
        nonfiction->addBook(a2.get(j));
    }

}

Control::~Control(){
    Array a1;
    Array a2;
    fiction->copyBooks(a1);
    nonfiction->copyBooks(a2);
    bk->update(a1,a2);
    delete bk;
    delete fiction;
    delete nonfiction;
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
        v.readBook(id, call_no, title, author, year);
        if(type== "Fiction"){
            temp = new FictionBook(id, call_no, title, author, year);
            fiction->addBook(temp);
        }
        else{
            temp = new NonFictionBook(id, call_no,  title, author, year);
            nonfiction->addBook(temp);
        }
    }
   }
   cout<<"FICTION LIBRARY :\n";
   v.printLibrary(fiction);
   cout<<"NON FICTION LIBRARY:\n";
   v.printLibrary(nonfiction);
}

