--CREATE DATABASE TABLES
--=======================

-- To Run Program 
-- sqlite3 
-- .read insert_script.sql
-- select * from songs;


CREATE TABLE IF NOT EXISTS songs(
      title text NOT NULL, --title of the song
      composer text NOT NUll, --composer or composers of the song
      bookcode text NOT NULL,  --book code for the book the song is from
      page int, --page number in book where song appears
      length int, --number of pages the song occupies in the book
      studentnum text NOT NULL,  --student number of who contributed the data
      primary key (title,bookcode,page,studentnum)
      );

--INSERT DATA
--=======================

begin transaction;

--Insert songs
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Whispering','Frank Sinatra', 'RBK1-6ed-F', 442, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Windows','Chick Corea', 'RBK1-6ed-F', 443, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Wild Flower','UNCONFIRMED', 'RBK1-6ed-F', 444, 2, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Whitch Hunt','Wayne Shorter', 'RBK1-6ed-F', 446, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Woodchoppers Ball','Woody Herman ', 'RBK1-6ed-F', 447, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Wives and Lovers','Frank Sinatra', 'RBK1-6ed-F', 448, 2, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Woodyn','Stan Getz', 'RBK1-6ed-F', 450, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('World Is Waiting For The Sunrise, The','Ernest Seitx', 'RBK1-6ed-F', 451, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Yes and No','Wayne Shorter', 'RBK1-6ed-F', 452, 1, '101036672');
insert or replace into songs(title, composer, bookcode, page, length, studentnum)
   values ('Yeserday','Jerome Kern', 'RBK1-6ed-F', 453, 1, '101036672');
/*
  Replace the above insert statements with ones
  that contribute the data you are responsible for
*/

end transaction;
