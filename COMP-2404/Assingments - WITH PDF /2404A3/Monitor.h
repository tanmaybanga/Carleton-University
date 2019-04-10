// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Monitor.h

#ifndef MONITOR_H
#define MONITOR_H

#include <vector>
#include "Student.h"
using namespace std;

// Creating Our Member Types To Work Within The Function. Allowing What Is
// Publically Avalible & Acessible And What Is Not
class Monitor {
  public:
    Monitor();
    ~Monitor();
    virtual void update(Student*)=0;
    void printLog();

  protected:
    // Holding Our Logs
    vector <string> logKeeper;


};

#endif
