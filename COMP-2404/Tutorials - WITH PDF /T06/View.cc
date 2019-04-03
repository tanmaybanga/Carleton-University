#include "View.h"

using namespace std;

View::View() {}

View::~View() {}

void View::mainMenu(int &selection)
{
    int numOptions = 1;
    selection = -1;

    cout << endl;
    cout << "(1) Add book" << endl;
    cout << "(0) Exit" << endl;

    while (selection < 0 || selection > numOptions)
    {
        cout << "Enter your selection: ";
        cin >> selection;
    }
}

void View::readBook(int &id, string &title, string &author, int &year)
{
    cout << "id:  ";
    cin >> id;
    cout << "title:   ";
    cin.ignore();
    getline(cin, title);
    cout << "author: ";
    getline(cin, author);
    cout << "year:  ";
    cin >> year;
}

void View::print(Library& library){
    library.print();
}