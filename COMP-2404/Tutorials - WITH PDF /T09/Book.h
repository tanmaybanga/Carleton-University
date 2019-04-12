#ifndef BOOK_H
#define BOOK_H

#include <string>
using namespace std;

class Book
{
  public:
    Book(int=0, string = "UNKNOWN", string="Unknown", string="Unknown", int=0);
    virtual ~Book();
    void setBook(int, string, string, int);
    void print();
    string getAuthor();
    string getCallNo();
    virtual bool lessThan(Book*)=0;
  protected:
    int    id;
    string title;
    int    year;
  private:
    string call_no;
    string author;
};

#endif

