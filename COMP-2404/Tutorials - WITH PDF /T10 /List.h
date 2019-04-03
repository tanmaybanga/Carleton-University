#ifndef LIST_H
#define LIST_H

#include<iostream>
using namespace std;

#include "Book.h"
#include "Array.h"

template<class T>
class List{

    class Node{
        friend class List<T>;
        private:
            Node* next;
            T data;
            Node* prev;
    };
    private:
        Node* head;
    public:
        List();
        ~List();
        void add(T);
        void copy(Array&);
        void print();
};

template<class T>
List<T>::List(){
    head = NULL;
}
template<class T>
List<T>::~List(){
    Node* currNode;
    Node* nextNode;

    currNode = head;

    while(currNode != NULL){
        nextNode = currNode->next;
        delete currNode->data;
        delete currNode;
        currNode = nextNode;
    }
}
template<class T>
void List<T>::add(T kitaab)
{
    Node* currNode;
    Node* tmpNode;
    Node* prevNode;

    tmpNode = new Node();
    tmpNode->data = kitaab;
    tmpNode->prev = NULL;
    tmpNode->next = NULL;

    currNode = head;
    prevNode = NULL;

    while(currNode != NULL){
        if(*kitaab<currNode->data)
            break;
        prevNode = currNode;
        currNode = currNode->next;
    }
    if(prevNode == NULL){
        head = tmpNode;
    }
    else{
        prevNode->next = tmpNode;
    }
    if(currNode != NULL){
        currNode->prev = tmpNode;
    }

    tmpNode->next = currNode;
   // currNode->prev = tmpNode;
    tmpNode->prev = prevNode;
}
template<class T>
void List<T>::copy(Array& bk){
    Node* currNode = head;
    while(currNode != NULL){
        bk.add(currNode->data);
        currNode = currNode->next;
    }

}
template<class T>
void List<T>::print(){
    Node* currNode = head;
    Node* prevNode = NULL;
    cout<<" ======== FROM HEAD TO TAIL ==============\n\n\n"<<endl;
    while(currNode != NULL){
        currNode->data->print();
        prevNode = currNode;
        currNode = currNode->next;
    }
    cout<<" ========= FROM TAIL TO HEAD ==============\n\n\n"<<endl;
    while(prevNode != NULL){
        prevNode->data->print();
        prevNode = prevNode->prev;
    }
    cout<<"\n\n\n";
}
#endif
