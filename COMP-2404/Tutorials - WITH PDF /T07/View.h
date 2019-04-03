#ifndef VIEW_H
#define VIEW_H

#include "Library.h"

class View{
    public:
        int mainMenu(int&);
        void readBook(int&, string&, string&, int&);
        void readBookType(string&);
        void printLibrary(Library*);
};
#endif
