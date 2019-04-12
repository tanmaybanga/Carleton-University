Assignment Completed By Imran Gabrani Juma (101036672)

Purpose: This Assignment Was Generated For COMP 2404 - Introduction To Software Engineering - Winter 2019, The Purpose Of This Program Was To Develop A Program That Would Allow For Student Information As well As, Grades, Term, Instructor & Course To Be Inputed, and Then Read Back Out In Chronological Format As Defined In The Assignment Specification


**Important Please Read **

If you run the program, & pipeline in2.txt you will notice that the students GPA says insufficient data. Collectively with a group of students I went to Head TA Sean, and presented the case that if a student takes no courses, his GPA should not be 0, his GPA should be insufficient because he has not taken any qualifying courses. His GPA should only be 0 if he has failed courses as those create quality points towards a GPA. Please not this as this is done on purpose and not an error.

As well, if you run the program and exit right away, you will get a message of no data, this is because there is no students registered, as well, there is no GPA, thus the log is empty, rather than just running the log, is is more informative if the user knows that the log is empty

Lastly, the last student input is all 0, this is to display that when a student has failed all the courses he has a GPA of 0, and to make sure that all his FW courses are added up correctly in the log

Thank You.


List of Source files:
-	A4.exe ** Asked To Remove File, But Will Show When Complied **
- A4.PDF ** Assignment Specification Page **
- Control.cc
- Control.h
- Course.cc
- Course.h
- CourseList.h
- CourseList.cc
- defs.h
- FWMonitor.cc
- FWMonitor.h
- GPAMonitor.cc
- GPAMonitor.h
- in.txt
- in2.txt (Test Student Number Input Independently) **Checks For Segmentation Fault
-	in3.txt (Test Smaller Of Student't -- Used For Visibility)
- List.cc ** Removed, Not Required For This Assignment **
- List.h ** Fully Changed & Integrated For New Assignment **
- Main.cc
- Makefile
- Monitor.cc
- Monitor.h
- ReadMe.txt
- Storage.cc
- Storage.h
- Student.cc
- Student.h
- View.cc
- View.h
- UML.PDF <- UML Diagram For Reading ** Removed, Not Required For This Assignment **
- UML.XML <- UML Diagram For Edit & Testing. Source: Draw.Io <- Editor Website ** Removed, Not Required For This Assignment **


Compile & Running:

1.0	Open Terminal

	Type Following:

1.1 		cd Desktop // or the location of file

1.2 		cd Juma_Imran_COMP_2404_101036672_A4_Files

1.3		Make  // Compile the Transmit file, you should see .exec file in folder

1.4		valgrind ./A4 // Compile the . exec file, you should see .exec file in folder


2.0	How To Launch & Run:

2.1 	Run the A3 - This can be done by typing ./A4 into your terminal.

2.2 	Result - The Program should have generated the course grades as well as let you 	add new ones and display current ones

3.0	Usability

3.1	This Program will run correctly ONLY on the VM -- If you run the program on Mac or 	PC you will see multiple compiler errors, this is because the program is built for 	the newest version of C++ per the professors instructions


Thanks
Imran Gabrani-Juma
