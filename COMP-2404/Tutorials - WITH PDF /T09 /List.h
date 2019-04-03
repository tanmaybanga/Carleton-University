#ifndef LIST_H
#define LIST_H

#include "Book.h"
#include "Array.h"

class List{
    class Node{
        friend class List;
        private:
            Node* next;
            Book* data;
            Node* prev;
    };
    private:
        Node* head;
    public:
        List();
        ~List();
        void add(Book*);
        void copy(Array&);
        void print();
};
#endif
