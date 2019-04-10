// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Student.cc

#include <iostream>
#include <iomanip>
#include <string>
#include "Storage.h"

//Constructor To Handle numCourses Attached To Each Student
Student::Student(int i) {
  id = i;
  numCourses = 0;
}

//Destructor To Destory The Handled Function So We Don't Run Into Memeory
//Problems Down The Road
Student::~Student() {
  //      *** REMOVED PER TA INSTRUCTION **
//  for (int i=0; i<numCourses; ++i) {
  //  delete courses[(MAX_NUM_COURSES - 1) - i];
//  }
}

//AddCourse Data Memeber To Pull and Place Into The List Class That We Have
//Newly Created
Student& Student::operator+= (Course* addMyCourse){
  list+=addMyCourse;
  return *this;
}

//Made So We Can Pull StudentID In GPAMonitor
int Student::getId() {
  return id;
}

//Made To Call computeGPA Later
float Student::computeGPA() {
  return list.computeGPA();
}

//Made To Call computeNumFW Later
int Student::computeNumFW(){
  return list.computeNumFW();
}


//Print Function To Print, Modified To Print From Our List & Removed The
//Original Method
void Student::print() {
  //Function Changed, Printing Our ID + GPA Beside It
  if (computeGPA() >= 0) {
    cout<< endl << "ID: " << id << " --- " << " GPA: " << list.computeGPA() << endl;
  } else {
    cout<< endl << "ID: " << id << " --- " << " GPA: Insufficent Courses - NO GPA" << endl;
  }
  // Doesnt Carleton Divide By 2, for 0.5 Courses, So I Thought I Would
  // Implement This Feature But Then TA Told Me I Would Lose Marks For Incorect
  // Output So It's Commented Out
//  cout << "Student's GPA Carleton Scale: " << (list.computeGPA() / 2 ) << endl;
//  cout << "Student's Withdrawn or Failed: " << list.computeNumFW() << endl;
  list.print();
//  GPAMonitor.logKeeper();
}
