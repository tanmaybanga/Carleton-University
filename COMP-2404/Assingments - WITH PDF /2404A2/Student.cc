// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Student.cc

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

//Imports
#include "List.h"
#include "Storage.h"

//Constructor To Handle numCourses Attached To Each Student
Student::Student(int i) {
  id = i;
  numCourses = 0;
}

//Destructor To Destory The Handled Function So We Don't Run Into Memeory
//Problems Down The Road
Student::~Student() {
  for (int i=0; i<numCourses; ++i) {
    delete courses[(MAX_NUM_COURSES - 1) - i];
  }
}

//AddCourse Data Memeber To Pull and Place Into The List Class That We Have
//Newly Created
void Student::addCourse(Course* addMyCourse){
  list.add(addMyCourse);
}


//Print Function To Print, Modified To Print From Our List & Removed The
//Original Method 
void Student::print() {
  cout<< endl << "Id: " << id << endl;
  list.print();
}
