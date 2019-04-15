// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: main.cc

#include <iostream>
using namespace std;
#include <string>

#include "defs.h"
#include "Storage.h"

int  mainMenu();


// Storage Function To Hold IN Memory
int main()
{
  Storage storage;
  int     numStu = 0;
  int     numCourses;
  int     stuId, courseCode, grade;
  int     menuSelection;
  string instructor;
  int term;

  while (1) {
    menuSelection = mainMenu();

    if (menuSelection == 0)
      break;

    else if (menuSelection == 1) {

      cout << "student id:   ";
      cin  >> stuId;
      numCourses = 0;

      Student* tempStudent = new Student(stuId);
      storage.addStu(tempStudent);
      while (1) {
        cout << "course code <0 to end>:  ";
        cin  >> courseCode;
        if (courseCode == 0)
          break;
        cout << "grade:                   ";
        cin  >> grade;
        cout << "instructor                ";
        cin.ignore();
        getline(cin,instructor);
        cout << "term                     ";
        cin >> term;

        Course* tempCourse = new Course(instructor, term, courseCode, grade);
        tempStudent -> addCourse(tempCourse);
        ++numCourses;
      }
      ++numStu;
    }
  }

// Printing From Storage, Not Print Function At Bottom
//  Made Upon Assingment Specification
  if (numStu > 0)
  storage.print();

  return 0;
}

// User Menu
int mainMenu()
{
  int numOptions = 1;
  int selection  = -1;

  cout << endl;
  cout << "(1) Add student" << endl;
  cout << "(0) Exit" << endl;

  while (selection < 0 || selection > numOptions) {
    cout << "Enter your selection: ";
    cin  >> selection;
  }

  return selection;
}

