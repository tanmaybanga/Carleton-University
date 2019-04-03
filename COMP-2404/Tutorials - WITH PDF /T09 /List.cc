#include<iostream>
using namespace std;

#include "List.h"

List::List(){
    head = NULL;
}

List::~List(){
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

void List::add(Book* kitaab)
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
        if(kitaab->lessThan(currNode->data))
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

void List::copy(Array& bk){
    Node* currNode = head;
    while(currNode != NULL){
        bk.add(currNode->data);
        currNode = currNode->next;
    }

}

void List::print(){
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
