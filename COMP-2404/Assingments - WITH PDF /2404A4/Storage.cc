// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Storage.cc

#include <iostream>
#include <iomanip>
#include <string>
#include "defs.h"
using namespace std;

// Imports
#include "Storage.h"

//Constructor
Storage::Storage()
{
  numStudents = 0;
}

//   This will move the storage value to the back with the - function
Storage::~Storage() {
  for (int i=0; i<numStudents; ++i) {
    delete students[(MAX_NUM_STU - 1) - i];
  }
}

// When program begins MAX_NUM_COURSES = x
// Subtract 1 to put addMyCourse at the last position
// Repeat each time you add a new course;
Storage& Storage::operator+=(Student* addMyStudents){
  students[(MAX_NUM_STU - 1) - numStudents] = addMyStudents;
  numStudents++;
  return *this;
}

// Print Function
void Storage::print()
{
  for (int i=0; i<numStudents; ++i)
    students[(MAX_NUM_STU - 1) - i] -> print();
}
