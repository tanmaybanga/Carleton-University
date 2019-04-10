/*

    Question Requirments

Find the names and address of all subscribers who subscribe to all of the
available services. (Note the result for the current data might be empty but
your query should work if the TA's add more data to the databse.)

*/

SELECT name, address FROM subscribers JOIN service_subscribers ON
subscribers.portid = service_subscribers.line GROUP BY line having
count(service) = (SELECT count(*) from services);

/*
  Test Output:
name|address|total
-----
-----
No Data Was Produced During Output
-----
-----
*/
