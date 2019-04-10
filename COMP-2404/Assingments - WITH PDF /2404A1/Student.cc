// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: Student.cc

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

#include "Student.h"

Student::Student(int i)
{
  id = i;
  numCourses = 0;
}

// Moving New Student // Courses to the back of the array by using the
// "-" function. As Required By The Assingment Specification
Student::~Student() {
  for (int i=0; i<numCourses; ++i) {
    delete courses[(MAX_NUM_COURSES - 1) - i];
  }
}

void Student::addCourse(Course* addMyCourse){
  // When program begins MAX_NUM_COURSES = x
  // Subtract 1 to put addMyCourse at the last position
  // Repeat each time you add a new course;
  courses[(MAX_NUM_COURSES - 1) - numCourses] = addMyCourse;
  numCourses++;
}

//Print Function
void Student::print()
{
  cout<< endl << "Id: " << id << endl;

  for (int i=0; i<numCourses; ++i)
    courses[(MAX_NUM_COURSES - 1) - i] -> print();
}
