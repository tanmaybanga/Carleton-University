#include<iostream>
using namespace std;

#include "FictionBook.h"

FictionBook::FictionBook(int id, string title, string author, int year)
   : Book(id, title, author, year)
   {}
