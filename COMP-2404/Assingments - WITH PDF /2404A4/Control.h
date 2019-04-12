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
#include <vector>
#include "Monitor.h"
#include "GPAMonitor.h"
#include "FWMonitor.h"
#include <vector>
#include "StuServer.h"

using namespace std;

//Public Tables Including Launch To Start Program From Main
class Control {
public:
  Control();
  ~Control();
  void launch();
  void notify(Student *newStu);

//New Data Memebers for Storage & View
private:
  Storage storage;
  View view;
  vector<Monitor *> myMonitor; // -> New Monitor Vector
  StuServer cloudService; // -> Allowing For StuServer



};
#endif
