--=======================
-- Things To Fix 
-- Titles
-- Make sure all studd is there
-- header names
--=======================

--CREATE DATABASE TABLES
--=======================

-- To Run Program 
-- sqlite3 
-- .header on
-- .mode column
-- .width 8 8 8 8 
-- .read file name
-- select * from songs;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS Dept_Locations;
DROP TABLE IF EXISTS Works_On;
DROP TABLE IF EXISTS Project;
DROP TABLE IF EXISTS Dependent;

CREATE TABLE IF NOT EXISTS Employee(
      FNAME text NOT NULL, --title of the song
      INIT text NOT NUll, --composer or composers of the song
      LNAME text NOT NULL,  --book code for the book the song is from
      SSN int, --page number in book where song appears
      BDATE text NOT NULL, --number of pages the song occupies in the book
      ADDRESS text NOT NULL,  --student number of who contributed the data
      SEX text NOT NULL, --title of the song
      SALARY int, --number of pages the song occupies in the book
      SUPERSSN int, --number of pages the song occupies in the book
      DNO int, --number of pages the song occupies in the book
      primary key (FNAME,INIT,LNAME,SSN,BDATE,ADDRESS,SEX,SALARY,SUPERSSN,DNO)
      );

CREATE TABLE IF NOT EXISTS Department(
      DNAME text NOT NULL, --title of the song
      DNUMBER int, --composer or composers of the song
      MGRSSN int,  --book code for the book the song is from
      MGRSTARTDATE inttext NOT NULL, --title of the song
      primary key (DNAME,DNUMBER,MGRSSN,MGRSTARTDATE)
      );

CREATE TABLE IF NOT EXISTS Dept_Locations(
      DNUMBER int, --title of the song
      DLOCATION text NOT NUll, --composer or composers of the song
      primary key (DNUMBER,DLOCATION)
      );

CREATE TABLE IF NOT EXISTS Works_On(
      ESSN int, --page number in book where song appears
      PNO int, --number of pages the song occupies in the book
      Hours int,  --student number of who contributed the data
      primary key (ESSN,PNO,Hours)
      );

CREATE TABLE IF NOT EXISTS Project(
      PNAME text NOT NULL, --title of the song
      PNUMBER int, --composer or composers of the song
      PLOCATION text NOT NULL,  --book code for the book the song is from
      DNUM int, --page number in book where song appears
      primary key (PNAME,PNUMBER,PLOCATION,DNUM)
      );

CREATE TABLE IF NOT EXISTS Dependent(
      ESSN int, --title of the song
      DNAME text NOT NUll, --composer or composers of the song
      SEX text NOT NULL,  --book code for the book the song is from
      BDATE text NOT NULL, --page number in book where song appears
      RELATIONSHIP text NOT NULL, --number of pages the song occupies in the book
      primary key (ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
      );

--Insert table1
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('John','B', 'Smith', 123456789, '9-Jan-55', '731 Fondern', 'M', 30000, 333445555, 5);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Franklin','T', 'Wong', 333445555, '8-Dec-45', '638 Voss', 'M', 40000, 888665555, 5);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Alicia','J', 'Zelaya', 999887777, '19-Jul-58', '3321 Castle', 'F', 25000, 987987987, 4);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Jennifer','S', 'Wallace', 987654321, '20-Jun-31', '291 Berry', 'F', 43000, 888665555, 4);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Ramesh','K', 'Narayan', 666884444, '15-Sep-52', '975 Fire Oak', 'M', 38000, 333445555, 5);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Joyce','A', 'English', 453453453, '31-Jul-62', '5631 Rice', 'F', 25000, 333445555, 5);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('Ahmad','V', 'Jabber', 987987987, '29-Mar-59', '980 Dallas', 'M', 25000, 987654321, 4);
insert or replace into Employee(fname,init,lname,ssn,bdate,address,sex,salary,superssn,dno)
   values ('James','E', 'Borg', 8886655555, '10-Nov-27', '450 Stone', 'M', 55000, NULL, 1);
--drop table Project;

--Insert table2
insert or replace into Department(DNAME,DNUMBER,MGRSSN,MGRSTARTDATE)
   values ('Reserch','5', 333445555,'22-May-78');
insert or replace into Department(DNAME,DNUMBER,MGRSSN,MGRSTARTDATE)
   values ('Administration','4', 987654321,'1-Jan-85');
insert or replace into Department(DNAME,DNUMBER,MGRSSN,MGRSTARTDATE)
   values ('Headquarters','1', 8886655555,'19-Jun-71');
--drop table Project;

--Insert Dept_Location
insert or replace into Dept_Locations(DNUMBER,DLOCATION)
   values (1,'Houston');
insert or replace into Dept_Locations(DNUMBER,DLOCATION)
   values (4,'Stanfford');
insert or replace into Dept_Locations(DNUMBER,DLOCATION)
   values (5,'Bellaire');
insert or replace into Dept_Locations(DNUMBER,DLOCATION)
   values (5,'Sugarland');
insert or replace into Dept_Locations(DNUMBER,DLOCATION)
   values (5,'Houston');
--drop table Project;


--Insert Works_On // Here we have the data for the Works_On Table
insert or replace into Works_On(ESSN,PNO,Hours)
   values (123456789,1,"32.50");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (123456789,2,"7.50");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (666884444,3,"40.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (453453453,1,"20.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (453453453,2,"20.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (333445555,2,"10.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (333445555,3,"10.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (333445555,10,"10.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (333445555,20,"10.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (999887777,30,"30.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (999887777,10,"10.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (987987987,10,"35.50");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (987987987,30,"5.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (987654321,30,"20.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (987654321,20,"15.00");
insert or replace into Works_On(ESSN,PNO,Hours)
   values (888665555,20, NULL);
--drop table Project;


--Insert Project // Here we have the data for the Project Table
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('ProductX','1', 'Bellaire', 5);
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('ProductY','2', 'Sugarland', 5);
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('ProductZ','3', 'Houston', 5);
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('Computerization','10', 'Stanfford', 4);
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('Reorganization','20', 'Houston', 1);
insert or replace into Project(PNAME,PNUMBER,PLOCATION,DNUM)
   values ('NewBenefits','30', 'Stanfford', 4);
--drop table Project;


--Insert Dependent // Here we have the data for the Dependent Table
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (3334455555,'Alice', 'F', '5-Apr-76','DAUGHTER');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (3334455555,'Theodore', 'M', '25-Oct-73','SON');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (3334455555,'Joy', 'F', '3-May-48','SPOUSE');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (987654321,'Abner', 'M', '29-Feb-32','SPOUSE');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (123456789,'Michael', 'M', '1-Jan-78','SON');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (123456789,'Alice', 'F', '31-Jan-78','DAUGHTER');
insert or replace into Dependent(ESSN,DNAME,SEX,BDATE,RELATIONSHIP)
   values (123456789,'Elizabeth', 'F', '5-May-57','SPOUSE');
--drop table Dependent;






