A4:	main.o Student.o Course.o Storage.o Control.o View.o Monitor.o GPAMonitor.o FWMonitor.o StuServer.o CourseList.o list.h
	g++ -o A4 main.o Student.o Course.o Storage.o Control.o View.o Monitor.o GPAMonitor.o FWMonitor.o StuServer.o CourseList.o

main.o:	main.cc Student.h defs.h
	g++ -c main.cc

Student.o:	Student.cc Student.h Course.h defs.h CourseList.h
	g++ -c Student.cc

Course.o:	Course.cc Course.h
	g++ -c Course.cc

Storage.o:	Storage.cc Storage.h
	g++ -c Storage.cc

Control.o:	Control.cc Control.h
	g++ -c Control.cc

View.o:		View.cc View.h
	g++ -c View.cc

Monitor.o: Monitor.cc Monitor.h
		g++ -c Monitor.cc

GPAMonitor.o: GPAMonitor.cc GPAMonitor.h
		g++ -c GPAMonitor.cc

FWMonitor.o: FWMonitor.cc FWMonitor.h
		g++ -c FWMonitor.cc

CourseList.o: CourseList.cc CourseList.h Course.h List.h
		g++ -c CourseList.cc

clean:
	rm -f main.o Control.o Course.o Student.o storage.o View.o FWMonitor.o GPAMonitor.o Monitor.o
