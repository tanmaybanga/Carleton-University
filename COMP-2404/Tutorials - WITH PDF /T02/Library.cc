#include <iostream>
#include <iomanip>
using namespace std;

#include "Book.h"
#include "Library.h"

Library::Library(int n)
{
  numBooks = n;
}

void Library::addBook(Book &b)
{
  bArray[numBooks] = b;
  numBooks++;
}

void Library::printLibrary()
{
  if (numBooks > 0)
  {
    cout << endl << endl << "LIBRARY: " << endl;
    for (int i=0; i<numBooks; i++)
      bArray[i].print();
    cout << endl;
  }
}
