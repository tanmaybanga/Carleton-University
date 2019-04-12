OPT = -Wall

t08:	main.o Book.o Library.o View.o Control.o List.o NonFictionBook.o FictionBook.o
	g++ $(OPT) -o t08 main.o Book.o Library.o View.o Control.o List.o NonFictionBook.o FictionBook.o

main.o:	main.cc Control.h
	g++ $(OPT) -c main.cc

Book.o:	Book.cc Book.h
	g++ $(OPT) -c Book.cc

Library.o:	Library.cc Library.h
	g++ $(OPT) -c Library.cc

View.o:	View.cc View.h
	g++ $(OPT) -c View.cc

Control.o:	Control.cc Control.h
	g++ $(OPT) -c Control.cc

List.o:	List.cc List.h Book.h
	g++ $(OPT) -c List.cc

NonFictionBook.o:	NonFictionBook.cc NonFictionBook.h
	g++ $(OPT) -c NonFictionBook.cc

FictionBook.o:	FictionBook.cc FictionBook.h
	g++ $(OPT) -c FictionBook.cc

clean:
	rm -f *.o t08
