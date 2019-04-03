#ifndef VIEW_H
#define VIEW_H

#include "Library.h"
#include <iostream>
using namespace std;

class View
{
    public:
        View();
        ~View();
        void mainMenu(int&);
        void readBook(int&, string&, string&, int&);
        void print(Library&);
};

#endif