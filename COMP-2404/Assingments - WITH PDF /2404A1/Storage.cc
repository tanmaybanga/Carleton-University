// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: Storage.cc

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

#include "Storage.h"

Storage::Storage()
{
  numStudents = 0;
}

// Math Function "MAX_NUM_STU -1"
//   This will move the storage value to the back with the - function
Storage::~Storage() {
  for (int i=0; i<numStudents; ++i) {
    delete students[(MAX_NUM_STU - 1) - i];
  }
}

void Storage::addStu(Student* addMyStudents){
  // When program begins MAX_NUM_COURSES = x
  // Subtract 1 to put addMyCourse at the last position
  // Repeat each time you add a new course;
  students[(MAX_NUM_STU - 1) - numStudents] = addMyStudents;
  numStudents++;
}

// Print Function
void Storage::print()
{
  for (int i=0; i<numStudents; ++i)
    students[(MAX_NUM_STU - 1) - i] -> print();
}
