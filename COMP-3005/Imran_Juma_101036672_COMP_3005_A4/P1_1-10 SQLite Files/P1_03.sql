/*

    Question Requirments

 List the names of all the subscribers who are originators of a call to
 someone who is also a subscriber on the same switch (i.e. a line to line
 call)

*/

SELECT name FROM subscribers join (SELECT orig, term FROM calls WHERE orig
IN (SELECT portid FROM lines) AND term IN (SELECT portid FROM lines))
ON subscribers.portid = orig;

/*
  Test Output:
name
-----
Mats Sundin
Jason Allison
Homer Simpson
Michael Jordan
Ed Belfour
*/
