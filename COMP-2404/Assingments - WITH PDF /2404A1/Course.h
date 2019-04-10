// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: Course.h

#ifndef COURSE_H
#define COURSE_H

class Course
{
  public:
    Course(string = "", int=0, int=0, int=0);
    //Removed From A1
//    void setCode(int);
//    void setGrade(int);
    void print();

  private:
    string instructor;
    int term;
    int code;	// course code, for example 2404 for COMP2404
    int grade;	// numeric grade from 0 (F) to 12 (A+), with -1 for WDN
    void getGradeStr(string&);
};

#endif
