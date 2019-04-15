S// Program Produced By Imran Juma
// Produced For COMP 2404
// 2018 Version
// File: Storage.h

#ifndef STORAGE_H
#define STORAGE_H

#include "defs.h"
#include "Student.h"


class Storage
{
  public:
    Storage();
    ~Storage();
    void addStu(Student*);
    void print();

  private:
    Student* students[MAX_NUM_STU];
    int     numStudents;
};

#endif
