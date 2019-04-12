// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: CourseList.cc

// Include Statements
#include <iostream>
using namespace std;
#include "CourseList.h"


//Constructor
CourseList :: CourseList() {
        // Empty
}

//          ** Same Code as from the list function, just ported over from
//              The List Class Into Here where the Implementaton was requested
//           **
float CourseList :: computeGPA() {
  float gradeHolder = 0;
  float numCourses = 0;
  Node* currNode = head;

  while (currNode != NULL) {
  float grade = currNode->data->getGrade();
  if (grade >= 0) {
    gradeHolder = gradeHolder + grade;
    numCourses++;
  }
  currNode = currNode->next;
}

if (head==NULL) {
  return -1;
}
float average = gradeHolder / numCourses;
return average;
}


//          ** Same Code as from the list function, just ported over from
//              The List Class Into Here where the Implementaton was requested
//           **
int CourseList::computeNumFW() {
  Node* currNode = head;
  float gradeHolder = 0;
  float numCourses = 0;
  int fwCourses = 0;

  while (currNode != NULL) {
    float grade = currNode->data->getGrade();
    if (grade <= 0) {
      gradeHolder = gradeHolder + grade;
      numCourses++;
      fwCourses++;
    }
    currNode = currNode->next;
  }
  return fwCourses;
}
