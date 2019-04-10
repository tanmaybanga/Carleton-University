// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: GPAMonitor.h

//Defining Elements
#ifndef GPAMONITOR_H
#define GPAMONITOR_H

#include "Monitor.h"
#include <string>
using namespace std;

//Constructor, Destructor, Virtual Update Function
class GPAMonitor : public Monitor  {
  public:
    GPAMonitor(float);
    ~GPAMonitor();
    virtual void update(Student *);

//protected value so it cannot be acessed from the outside classes
  protected:
    float thresholdFlagged;

};

#endif
