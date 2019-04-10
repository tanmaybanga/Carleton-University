// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: Storage.h

#ifndef STORAGE_H
#define STORAGE_H

// Import Elements
#include "defs.h"
#include "Student.h"

#include <iostream>
using namespace std;

// Creating Our Member Types To Work Within The Function. Allowing What Is
// Publically Avalible & Acessible And What Is Not 
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
