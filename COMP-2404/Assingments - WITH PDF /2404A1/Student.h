// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: Student.h

#ifndef STUDENT_H
#define STUDENT_H

#include "defs.h"
#include "Course.h"

class Student
{
  public:
    Student(int=0);
    ~Student();
    void addCourse(Course*);
    void print();

  private:
    int    id;
    Course* courses[MAX_NUM_COURSES];
    int    numCourses;
};

#endif
