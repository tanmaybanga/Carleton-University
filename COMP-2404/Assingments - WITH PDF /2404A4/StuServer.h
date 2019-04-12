#ifndef STUSERVER_H
#define STUSERVER_H

#include <vector>
#include <string>

/*
  Class:    StuServer
  Purpose:  simulates cloud-based storage of students

  Member function:  constructor
     Side effects:  creates a set of strings, each representing a student's info

  Member function:  retrieve
          Purpose:  copies students from simulated cloud storage into given vector
              out:  vector of students
*/

class StuServer
{
  public:
    StuServer();
    void retrieve(vector<string>&);
    void print();

  private:
    vector<string> students;
};

#endif
