/*
    Question Requirments

Find the names of all the subscribers who subscribe to at least three

*/

SELECT name FROM subscribers JOIN service_subscribers
on subscribers.portid=service_subscribers.line GROUP BY line having
count(service)>=3;

/*
  Test Output:
name
-----
Michael Jordan
Joe Carter
Homer Simpson
Vince Carter
Chris Pronger
Frank Thomas
Steve Sampras
Matt Stajan
*/
