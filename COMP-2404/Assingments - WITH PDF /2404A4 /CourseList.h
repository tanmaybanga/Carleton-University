// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: CourseList.h

//Defining Elements
#ifndef COURSELIST_H
#define COURSELIST_H

//Include Statements 
#include "List.h"
#include "Course.h"

//Allowing It To Be Publically Acessed
class CourseList : public List<Course *> {

  public:
    CourseList(); // -> Constructor
    float  computeGPA(); // -> Function From Old List
    int computeNumFW(); // -> Function From Old List

};
#endif
