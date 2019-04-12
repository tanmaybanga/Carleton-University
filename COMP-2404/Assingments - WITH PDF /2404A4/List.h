// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: List.h

// Initalize Items
#ifndef LIST_H
#define LIST_H

//Need This Because Import List.cc Functions
using namespace std;

//Defining Elements6
#include <iostream>
#include <string>

// Imports
#include "Course.h"

//Setting Our Nodes To Work With Correctly Within The Data Memeber Functions
//Enableing Templateing
template <class T>
class List {

  protected:
    class Node {
    friend class List <T>;

    public:
      T data;
      Node *next;
  };

// Setting Our Constructor & Destructor As Well As Function To Be Publically
// Avalible So that they can be acessed Properly
  public:
    List();
    ~List();
    List& operator+=(T);
//    void add(T);
    void print();
    float computeGPA();
    int computeNumFW();

  protected:
    Node *head;
    Node *tail;
};

//Constructor To Initalize Head & Tail To Zero
template <class T>
List<T>::List() {
  head = NULL;
  tail = NULL;
}

//Destructor For List
template <class T>
List<T>::~List() {

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
template <class T>
List<T>& List<T> :: operator+=(T course) {
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

  while (currNode != NULL) {
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
template <class T>
void List<T>::print() {
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
/*

template <class T>
float List<T>::computeGPA() {
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

*/

//Computing The NumFW handler
/*
template <class T>
int List<T>::computeNumFW(){

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
*/
#endif
