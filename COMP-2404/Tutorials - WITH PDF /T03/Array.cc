#include <iostream>
#include <iomanip>
using namespace std;

#include "Array.h"

Array::Array()
{
	size = 0;
}
void Array::add(Book &newElement) 
{
	elements[size++] = newElement;
}

void Array::print()
{
	for (int i = 0; i < size; i++)
	{
		elements[i].print();
	}
}