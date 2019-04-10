// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Control.h

#ifndef CONTROL_H
#define CONTROL_H

// Including All The Nessesary Files Needed To Compute Program
#include <iostream>

// Imports
#include "View.h"
#include "defs.h"
#include "Storage.h"

using namespace std;

//Public Tables Including Launch To Start Program From Main
class Control {
public:
  Control();
  ~Control();
  void launch();

//New Data Memebers for Storage & View
private:
  Storage storage;
  View view;

};
#endif
