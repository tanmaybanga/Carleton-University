#include "Control.h"

using namespace std;

Control::Control() {}
Control::~Control() {}

void Control::launch()
{
    int selection = -1;
    int id, year;
    string title, author;
    while (1)
    {
        view.mainMenu(selection);
        if (selection == 0)
            break;
        view.readBook(id, title, author, year);
        Book *book = new Book(id, title, author, year);
        library.addBook(book);
    }
    view.print(library);
}
