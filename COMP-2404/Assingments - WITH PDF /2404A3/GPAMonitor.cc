// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: GPAMonitor.cc

#include <iostream>
//#include <string>
//#include <cstring>

using namespace std;

#include "GPAMonitor.h"

//Constructor
GPAMonitor :: GPAMonitor(float curr) : thresholdFlagged(curr) {
}

//Destructor
GPAMonitor :: ~GPAMonitor() {
}

//Update Function As well as an implementation that would allow for students that
// Have not registed for any courses and don't have any GPA. You can read more
// About this in my ReadMe.txt file
void GPAMonitor::update(Student* stu) {
  if (stu->computeGPA() < thresholdFlagged) {
  //  cout << "Following Students Are Below The Threshold Mark: " << endl;
    if (stu->computeGPA() >= 0) {
      string stringS = "Student ID: " + to_string(stu->getId()) + " -- " + " GPA: " + to_string(stu->computeGPA());
      cout << stringS << endl;
      logKeeper.push_back(stringS);
    } else {
      string stringS = "Student ID: " + to_string(stu->getId()) + " No Registered Courses " + " -- " + " GPA: No GPA ";
      cout << stringS << endl;
      logKeeper.push_back(stringS);
    }
  }
}
