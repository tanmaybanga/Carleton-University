#ifndef VIEW_H
#define VIEW_H

//Imports
#include "Storage.h"
#include <string>
using namespace std;


// Public Class Allowing for the use of mainMenu, as well as all the parameters
// That go inside courseInfo and studentNumber, this is the information that
// They store, as-well as the posinter that goes along with it and allows it
// to work essentially.

class View {
public:
  void mainMenu(int&);
  void courseInfo(int&, int& , string& , int&);
  void studentNumber(int&);
  void print(Storage &storage);

};
#endif
