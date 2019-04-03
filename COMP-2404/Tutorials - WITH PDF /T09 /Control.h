#ifndef CONTROL_H
#define CONTROL_H

#include "Library.h"
#include "View.h"
#include "BookServer.h"

class Control{
    private:
        Library* fiction;
        Library* nonfiction;
        View v;
        BookServer* bk;
    public:
        Control();
        ~Control();
        void launch();
};
#endif
