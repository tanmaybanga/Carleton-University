OPT = -Wall

t01:	main.o Book.o Library.o Array.o View.o Control.o List.o
	g++ $(OPT) -o t01 main.o Book.o Library.o Array.o View.o Control.o List.o

main.o:	main.cc
	g++ $(OPT) -c main.cc

Book.o:	Book.cc Book.h
	g++ $(OPT) -c Book.cc

Library.o:	Library.cc	Library.h
	g++	$(OPT) -c Library.cc

Array.o:	Array.cc Array.h
	g++ $(OPT) -c Array.cc

View.o:	View.cc View.h
	g++ $(OPT) -c View.cc

Control.o:	Control.cc Control.h
	g++ $(OPT) -c Control.cc

List.o:	List.cc List.h
	g++ $(OPT) -c List.cc

clean:
	rm -f *.o t01
