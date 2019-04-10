// Program Produced By Imran Juma
// Produced For COMP 2404
// 2019 Version
// File: List.h

// Initalize Items
#ifndef LIST_H
#define LIST_H

// Imports
#include "Course.h"

//Setting Our Nodes To Work With Correctly Within The Data Memeber Functions
class List {
  class Node {
    friend class List;

  private:
    Course *data;
    Node *next;
  };

// Setting Our Constructor & Destructor As Well As Function To Be Publically
// Avalible So that they can be acessed Properly
  public:
    List();
    ~List();
    void add(Course *);
    void print();

  private:
    Node *head;
    Node *tail;

};

#endif
