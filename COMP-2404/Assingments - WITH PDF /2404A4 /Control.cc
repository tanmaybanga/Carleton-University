// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Control.cc

// Imports of Different Classes
#include "Control.h"
#include "GPAMonitor.h"
#include "FWMonitor.h"
#include "Monitor.h"
#include "StuServer.h"

using namespace std;

// Including For Different Features
#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include <vector>
#include <cstring>

//Constructor
Control::Control() {

  // Inistilling The Monitor Ranges
  myMonitor.push_back(new GPAMonitor(3.0));
  myMonitor.push_back(new FWMonitor(2.0));

  // Creating Vector
  vector <string> retriveVector;

  //  Allowing For String Stream Capability
  stringstream ss;

  // Decleration Of Varibles
  int stuId, courseCode, grade, term;
  string instructor;

  // Using Retrive Implementaton
  cloudService.retrieve(retriveVector);

  // Loop Through All
  // For Loop FOr Parisng Method -- From Provided Classes
  for (int i=0; i<retriveVector.size(); ++i) {
    ss.clear();
    ss.str(retriveVector[i]);
    ss >> stuId;

    Student* studentGrab = new Student(stuId);
    while(1) {
      ss >> courseCode >> term >> grade >> instructor;
      if (courseCode == 0) {
        break;
      }
      //  New Course Pointer
      Course* newCourseAdd = new Course(instructor, term, courseCode, grade);
      //    ** Test If Cascading Is Working -- Uncomment This Line **
      //    Course* newCourseAdd2 = new Course(instructor, term, courseCode, grade);
    *studentGrab +=(newCourseAdd);
    //    ** Test If Cascading Is Working -- Uncomment This Line **
    //    (*studentGrab +=(newCourseAdd)) += newCourseAdd2 ;
    }
    storage += (studentGrab);
    notify(studentGrab);
  }
}

//Destructor
Control::~Control() {
  //Adding To Printlog
  for (int i=0; i<myMonitor.size(); i++) {
    myMonitor[i]->printLog();
  }
  // Deleting Method
  for (int i=0; i<myMonitor.size(); i++) {
    delete myMonitor[i];
  }

}

void Control:: notify(Student* newStu) {
//  cout << "Testing If This IS Working 1" << endl;
  for (int i=0; i<myMonitor.size(); i++) {
  //    cout << "Testing If This IS Working 2" << endl;
    myMonitor[i]->update(newStu);
  //    cout << "Testing If This IS Working 3" << endl;
  }

}

//Launch Function To Begin The Program From View -> Main
// ** New Lanch Function Built To Support New List & Remove Valgrind Errors **
void Control::launch(){

  //Initalizing Varibles
  int stuId, courseCode, grade, term;
  int userInput;
  string instructor;

  // While Loop For Menu Options -> Handles UserInput & MenuSelection
  while (1) {
    view.mainMenu(userInput);
    //Will End The User Input If Something Correct Is Entered Wrong
    if (userInput == 0) {
      break;
    }
    else if (userInput == 1) {
      //Calling The View -> To Compare With Student Number -> Join The Two
      view.studentNumber(stuId);
      Student* tempStudent = new Student(stuId);
      //Join The Data Together From The View
      while(1) {
        view.courseInfo(courseCode, grade, instructor, term);
        if (courseCode == 0) {
          break;
        }
        Course* tempCourse = new Course(instructor, term, courseCode, grade);
        *tempStudent +=(tempCourse);
      }
      storage +=(tempStudent);
      notify(tempStudent);
    }
  }
  view.print(storage);
}
