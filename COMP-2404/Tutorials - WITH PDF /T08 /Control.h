#ifndef CONTROL_H
#define CONTROL_H

#include "Library.h"
#include "View.h"

class Control{
    private:
        Library* library;
        Library* lounge;
        View v;
    public:
        Control();
        ~Control();
        void launch();
};
#endif
