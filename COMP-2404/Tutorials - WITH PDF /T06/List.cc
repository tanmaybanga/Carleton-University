#include <iostream>
using namespace std;

#include "List.h"

List::List()
{
    head = NULL;
    tail = NULL;
}

List::~List()
{
    Node *currNode, *nextNode;

    currNode = head;

    while (currNode != NULL)
    {
        nextNode = currNode->next;
        delete currNode->data;
        delete currNode;
        currNode = nextNode;
    }
}

void List::add(Book *book)
{
    Node *tmpNode;
    Node *currNode;
    Node *prevNode;

    tmpNode = new Node;
    tmpNode->data = book;
    tmpNode->next = NULL;
    tmpNode->prev = NULL;

    currNode = head;
    prevNode = NULL;

    while (currNode != NULL)
    {
        if (currNode->data->lessThan(book))
            break;
        prevNode = currNode;
        currNode = currNode->next;
    }

    if (currNode == NULL)
    {
        tail = tmpNode;
    }
    else
    {
        currNode->prev = tmpNode;
    }

    if (prevNode == NULL)
    {
        head = tmpNode;
    }
    else
    {
        prevNode->next = tmpNode;
    }

    tmpNode->next = currNode;
    tmpNode->prev = prevNode;
}

void List::print()
{
    Node *currNode = head;

    while (currNode != NULL)
    {
        currNode->data->print();
        currNode = currNode->next;
    }

    cout << endl;
    currNode = tail;
    while (currNode != NULL)
    {
        currNode->data->print();
        currNode = currNode->prev;
    }
}
