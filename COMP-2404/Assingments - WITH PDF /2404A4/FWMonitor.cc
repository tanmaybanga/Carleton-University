// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: FWMonitor.cc

#include "FWMonitor.h"
#include <iostream>
using namespace std;
//#include <string>
//include <cstring>

//Constructor
FWMonitor::FWMonitor(float) {

}

//Destructor
FWMonitor::~FWMonitor(){
}

//Update function to push the amount of FW courses the student has taken,
//Another kind of Implementation here was attempted to display all Students
//includng the ones that havent failed a course but I decided to take that out
void FWMonitor :: update(Student* stu) {
  if (stu->computeNumFW() > thresholdFlagged) {
    string stringS = "Student ID: " + to_string(stu->getId()) + " -- " + " FW: " + to_string(stu->computeNumFW());
    logKeeper.push_back(stringS);
  }

//  if (stu->computeNumFW() < 0.01) {
  //  string stringS = "Student ID: " + to_string(stu->getId()) + " -- " + " FW: " + to_string(stu->computeNumFW());
  //  logKeeper.push_back(stringS);
//  cout << "LOG IS EMPTY " << endl;
//  }

/*

  else {
      string stringS = "Student ID: " + to_string(stu->getId()) + " -- " + " FW: Student Has No FW on Reccord ";
      logKeeper.push_back(stringS);
    }
    */
}
