// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Student.h

#ifndef STUDENT_H
#define STUDENT_H

//Imports
#include "defs.h"
#include "Course.h"
#include "List.h"
#include "CourseList.h"

//Setting What Is Publically Avalible & Not, However Also Setting What Can Be
//USed, If you no not define correctly in the header file, the function will Not,
//Be able to be acessed and will not run correctly
class Student
{
  public:
    Student(int=0);
    ~Student();
  //  void addCourse(Course*);
    void print();
    float computeGPA();
    int computeNumFW();
    int getId();
    Student& operator+= (Course*);

  private:
    int    id;
    Course* courses[MAX_NUM_COURSES];
    int    numCourses;
    CourseList list;

};

#endif
