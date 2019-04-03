#ifndef LIBRARY_H
#define LIBRARY_H

#include <string>
#include "Array.h"
using namespace std;

class Library
{
	public:
		void addBook(Book&);
		void print();
	private:
		Array books;
};

#endif