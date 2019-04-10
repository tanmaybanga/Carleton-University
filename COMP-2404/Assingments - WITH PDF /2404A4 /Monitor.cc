// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Monitor.cc


#include <iostream>
using namespace std;
#include "Monitor.h"

//Constructor
Monitor::Monitor() {
}

//Destructor
Monitor::~Monitor() {

}

//Print Log For Our Outputs
void Monitor::printLog() {
cout << endl << "Print Log Processing..." << endl;
  for (int i=0; i<logKeeper.size(); i++) {
    cout << logKeeper[i] << endl;
  } if (logKeeper.size() == 0) {
    //Priting Empty Logs -- Can Read About in ReadMe.txt
    cout << "---------------------------------------" <<endl;
    cout << "All Log's Are Empty -- No Data Entered " << endl;
    cout << "---------------------------------------" <<endl;
    cout << endl;
  }
}
