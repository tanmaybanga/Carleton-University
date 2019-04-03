#ifndef LIBRARY_H
#define LIBRARY_H

#include <string>
using namespace std;

#define MAX_ARR_SIZE 128

class Library
{
 public:
  Library(int=0);
  void addBook(Book&);
  void printLibrary();

  //private:
  Book bArray[MAX_ARR_SIZE];
  int numBooks;
  
};

#endif

