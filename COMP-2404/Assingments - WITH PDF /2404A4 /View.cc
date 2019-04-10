// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: View.h

#include<iostream>
#include <iomanip>
using namespace std;
#include "View.h"

//Setting Our mainMenu, This was previously in main.cc, however was now moved
// Here, the function works almost the same way with the same userinput and the
//same kind of selection method
void View::mainMenu(int& userInput) {
  int numOptions = 1;
  int selection  = -1;

  cout << endl;
  cout << "(1) Add student" << endl;
  cout << "(0) Exit" << endl;

  while (selection < 0 || selection > numOptions) {
    cout << "Enter Your Selection: ";
    cin  >> selection;
  }
  userInput = selection;
}

//Handles the studentid as well as the student number that is being enter Into
// The program so that we can later use it for the outputs
void View::studentNumber(int& stuId){
  cout << "Student Number:   ";
  cin  >> stuId;
}

//Handles the same way as above to hold all of the different course information
// as well as storing it into the correct zones, this allows handles out
//"KillSwitch" for the program if the user hits 0 they can exit the program or
// Add a new student into the program, this also accoutnts for the different
//Cin inputs that we are entering when we entere a new student into the program
void View::courseInfo(int& courseCode, int& grade, string& instructor, int& term){
  cout << "Course Code <0 To End>:  ";
  cin  >> courseCode;

// Basic cin inputs that are desribed as above
  if (courseCode != 0){
    cout << "Grade:                   ";
    cin  >> grade;
    cout << "Instructor                ";
    cin.ignore();
    getline(cin,instructor);
    cout << "Term                     ";
    cin >> term;
  }
}

void View::print(Storage &storage) {
  storage.print();
}
