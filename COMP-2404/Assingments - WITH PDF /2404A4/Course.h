// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Course.h

//Defining Elements
#ifndef COURSE_H
#define COURSE_H

#include <iostream>
using namespace std;

class Course
{

  //Course Initalizers To Allow For Data userInput
  //Print Function To Allow For Printing Delegation
  //Handeling LessThan Function
  public:
    Course(string = "", int=0, int=0, int=0);
    void print();
    bool lessThan(Course* course);
    int getGrade();

//Private Varibles That Will Be Taken In For User Inout
//This will also help handle GPA (12 Score) -> Onto Letter Grade Format
//courseCode Will Handle For example 2404 for COMP2404
  private:
    string instructor;
    int term;
    int code;
    int grade;
    void getGradeStr(string&);
};

#endif
