// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Course.cc

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// Imports
#include "Course.h"

// Varibles that contain the placement for Code, Grade,
//  Instructor & Term / Semesters
Course::Course(string i, int t, int c, int g)
{
  code  = c;
  grade = g;
  instructor = i;
  term = t;
}

// Print Function, Added Term and Grade, 2 & 6 Represent the Value of letters
//  in the String
void Course::print()
{
  string str;

  cout << "-- COMP " << code << ":  ";
  cout << right << setw(2) << grade   << "  ";
  cout << right << setw(6) << term   << "  ";
  cout << right << instructor   << "  ";

  getGradeStr(str);
  cout << left << setw(3) << str << endl;

}

// Converts the userinput of grade from GPA Scale 0 - 12 to a letter grade
//  Format
void Course::getGradeStr(string& gradeStr)
{
  string gradeStrings[] = {
    "WDN", "F", "D-", "D", "D+", "C-", "C", "C+",
    "B-", "B", "B+", "A-", "A", "A+" };

  if ( grade >= -1 && grade <= 12 )
    gradeStr = gradeStrings[grade+1];
  else
    gradeStr = "Unknown";
}

int Course::getGrade() {
  return grade;
}

//Less Than Function, This will handle the comparison when we later output our
//Files, this will also help with the handler that we have created in the List
//Class
bool Course::lessThan(Course* course ) {
  if (code < course->code){
    return true;
  }
  if (code == course->code) {
    if (term < course->term) {
      return true;
    }
  }
  return false;
}
