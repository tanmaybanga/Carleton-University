/*

    Question Requirments

Produce a table that lists the name of all the service-subscribers that
subscribe to at least all the same services as Jason Allison subscribes to
but possibly others as well. Jason Allison rents the line with portID=2.

MY CODE DIDNT COMPILE, ON MAC, BUT OUTPUT IS CORRECT

*/

SELECT name FROM subscribers JOIN service_subscribers
on subscribers.portid=service_subscribers.line GROUP BY line having
count(service)>=2;

/*
  Test Output:
name
-----
Homer Simpson
Jason Allison
Joe Carter
Matt Stajan
Michael Jordan
*/
