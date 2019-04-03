#include<iostream>
using namespace std;

#include "View.h"
#include "Library.h"

int View::mainMenu(int& selection){
  int numOptions = 1;

  cout << endl;
  cout << "(1) Add book" << endl;
  cout << "(0) Exit" << endl;

  while (selection < 0 || selection > numOptions) {
    cout << "Enter your selection: ";
    cin  >> selection;
    cout<<endl;
  }

  return selection;
}

void View:: readBook(int& id, string& title, string& author, int& year){
  cout << "id:  ";
  cin  >> id;
  cout << "title:   ";
  cin.ignore();
  getline(cin, title);
  cout << "author: ";
  getline(cin, author);
  cout << "year:  ";
  cin  >> year;
}

void View:: readBookType(string& s){
    cout<<"Enter the Book Type: ";
    cin.ignore();
    getline(cin,s);
    cout<<endl;
}

void View::printLibrary(Library* lib){
    lib->print();
}
