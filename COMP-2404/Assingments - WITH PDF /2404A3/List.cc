// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: List.cc

//Defining Elements
#include <iostream>
#include <iomanip>
#include <string>

// Imports
#include "List.h"
#include "Course.h"

//Constructor To Initalize Head & Tail To Zero
List::List(){
  head = NULL;
  tail = NULL;
}

//Destructor For List
List::~List(){

  // Setting Head of Node
  Node *currNode, *nextNode;
  currNode = head;

  //Removing The Node, CurrNode = nextNode
  while (currNode != NULL) {
    nextNode = currNode->next;
    delete currNode->data;
    delete currNode;
    currNode = nextNode;
  }
}

//Case If Statements For Our Node,Setting the different Node Types
void List::add(Course *course){
  Node *tempNode;
  Node *currNode;
  Node *prevNode;

  tempNode = new Node;
  tempNode->data = course;
  tempNode->next = NULL;

  currNode = head;
  prevNode = NULL;

  //What happenes when each Node Interacts with the different data
  //Types

  while (currNode != NULL){
    if (course->lessThan(currNode->data))
      break;
    prevNode = currNode;
    currNode = currNode->next;
  }

  if (prevNode == NULL) {
    head = tempNode;
  } else {
    prevNode->next = tempNode;
  }

  if (currNode == NULL) {
    tail = tempNode;
  }
  tempNode->next = currNode;
}

// Print Function
void List::print() {
  Node* currNode = head;

  while (currNode != NULL) {
    currNode->data->print();
    currNode = currNode->next;
  }

//Line Skip Just To Create Some White Space
  cout << endl;

// ** VERY IMPORTANT **
// TA Shawn instructed me to create sperate If Statements to
// Counter the various segmentation faults .. This allows for no
// Priting When the list is empty and removed the problems that we where
// Having

  // When Cannot Equal NULL
  if (head != NULL) {
    cout << "Head: " << endl;
    head->data->print();
  }

  // When Equal NULL
  if (head == NULL) {
    cout << "Head Is NULL -- NO List " << endl;
  }
  // When Cannot Equal NULL
  if (tail != NULL) {
    cout << "Tail: " << endl;
    tail->data->print();
  }

  // When Equal NULL
  if (tail == NULL) {
    cout << "Tail Is NULL -- NO List " << endl;
  }
}

//Computing The GPA handler
float List::computeGPA() {
    Node* currNode = head;
    float gradeHolder = 0;
    float numCourses = 0;

    while (currNode != NULL) {
    float grade = currNode->data->getGrade();
    if (grade >= 0) {
      gradeHolder = gradeHolder + grade;
      numCourses++;
    }
    currNode = currNode->next;
  }
  if (head==NULL)
    return -1;
  float average = gradeHolder / numCourses;
  return average;

}

/*
  if (average < 0) {
    cout << "No GPA Value" << endl;
  } else {
    return average;
  }
}
*/
  //return average;
//

//Computing The NumFW handler
int List::computeNumFW(){

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
