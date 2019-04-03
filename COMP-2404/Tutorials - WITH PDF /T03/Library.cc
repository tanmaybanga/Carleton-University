#include <iostream>
#include <iomanip>
using namespace std;

#include "Library.h"

void Library::addBook(Book &newBook) 
{
	books.add(newBook);
}

void Library::print()
{
	cout << "LIBRARY:" << endl;
	books.print();
	cout << endl;
}