// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: FWMonitor.h

//Defining Elements

#ifndef FWMONITOR_H
#define FWMONITOR_H

#include "Monitor.h"

//Constructor, Destructor, Virtual Update
class FWMonitor : public Monitor {
  public:
    FWMonitor(float);
    ~FWMonitor();
    virtual void update(Student *);

//protected value so it cannot be acessed from the outside classes
  protected:
    float thresholdFlagged;

};

#endif
