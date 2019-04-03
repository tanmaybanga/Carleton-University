#include <iostream>
#include <iomanip>
using namespace std;

#include "Book.h"

Book::Book(int i, string p, string t, string a, int y) 
{ 
  id     = i;
  title  = t;
  author = a;
  year   = y;
  call_no = p;
}
Book::~Book(){}

string Book:: getAuthor(){
    return author;
}

string Book :: getCallNo(){
    return call_no;
}


/*void Book::setBook(int i, string t, string a, int y) 
{
  id     = i;
  title  = t;
  author = a;
  year   = y;
}*/

void Book::print()
{
  cout << setw(3)  << id
      <<"; Call Number: " << setw(20) << call_no
       <<"  Title: "   << setw(40) << title
       <<";  Author: "  << setw(20) << author
       <<";  Year: "    << year 
       <<endl;
}

