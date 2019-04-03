#ifndef CONTROL_H
#define CONTROL_H

#include "View.h"

using namespace std;

class Control{
    public:
        Control();
        ~Control();
        void launch();
    private:
        Library library;
        View view;
};

#endif