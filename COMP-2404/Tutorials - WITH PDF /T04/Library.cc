#include <iostream>
using namespace std;
#include "Library.h"
Library::Library()
{
}
void Library :: addBook(Book* kitaab)
{
    arr.add(kitaab);    
}
void Library:: print()
{
    cout<<"LIBRARY:"<<endl;
   arr.print();
   cout<<endl;
}
