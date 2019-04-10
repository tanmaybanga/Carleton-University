// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Control.cc

// Imports
#include "Control.h"

#include <iostream>
#include <string>
#include <cstring>

using namespace std;

//Constructor & Destructor
Control::Control(){}
Control::~Control(){}

//Launch Function To Begin The Program From View -> Main
void Control::launch(){

  //Initalizing Varibles
  int stuId, courseCode = -1, grade, term;
  int userInput;
  string instructor;
  int numStu = 0;
  bool exitCourses = false;

  // While Loop For Menu Options -> Handles UserInput & MenuSelection
  while (1) {

    courseCode = -1;
    userInput = -1;
    view.mainMenu(userInput);

    //Will End The User Input If Something Correct Is Entered Wrong
    if (userInput == 0)
      break;
    else if (userInput == 1) {
      exitCourses = false;

      //Calling The View -> To Compare With Student Number -> Join The Two
      view.studentNumber(stuId);
      Student* tempStudent = new Student(stuId);
      storage.addStu(tempStudent);

      //Join The Data Together From The View
      while(courseCode != 0){
        view.courseInfo(courseCode, grade, instructor,term, exitCourses);

        // Exit Course and Place Inside Temp File
        if (!exitCourses) {
          Course* tempCourse = new Course(instructor, term, courseCode, grade);
          tempStudent -> addCourse(tempCourse);
        }

      }
      ++numStu;
    }
  }

  //Printing From Storage
  if (numStu > 0)
    storage.print();
}
