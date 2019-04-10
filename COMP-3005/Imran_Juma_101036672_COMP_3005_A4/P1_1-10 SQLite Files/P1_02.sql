/*
    Question Requirments

    Produce a table that lists all the area code,
    office code combinations and the number of subscribers
    with that area code, office code combination.

*/

SELECT areacode, officecode, lines.portid, count(*) FROM lines join subscribers
WHERE subscribers.portid = lines.portid GROUP BY areacode, officecode ORDER BY
areacode;

/*
  Test Output:
areacode|officecode|total
416|219|44|2
416|331|45|2
416|333|46|2
416|334|47|2
416|756|48|2
613|134|1|1
613|136|2|1
613|156|3|1
613|220|4|1
613|221|5|1
613|222|6|1
613|223|7|1
613|226|8|1
613|227|9|1
613|229|10|1
613|310|11|1
613|322|12|1
613|333|13|1
613|334|14|1
613|389|15|1
613|457|16|1
613|489|17|1
613|523|18|1
613|568|19|1
613|578|20|1
613|623|21|1
613|645|22|1
613|657|23|1
613|712|24|1
613|728|25|1
613|798|26|1
705|221|49|3
819|223|39|2
819|227|50|3
905|347|41|2
905|657|42|2
905|819|43|2
*/
