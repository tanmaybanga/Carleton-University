/*

  Question:

  Produce a table consisting of the names and addresses of the subscribers and
  their phone numbers.

*/

SELECT subscribers.name, subscribers.address, (lines.areacode || "-" ||
lines.officecode || "-" || lines.stationcode) AS phoneNumber
FROM subscribers join lines WHERE subscribers.portid=lines.portid;

/*

  Test Output:

name|address|areacode|officecode|stattioncode
Mats Sundin|45 Elgin St.|613-134-0001
Jason Allison|46 Elgin St.|613-136-0002
Eric Lindros|48 Elgin St.|613-156-0003
Bryan MacCabe|23 MacLeod St.|613-220-0004
Steve Nash|1129 Otterson Dr.|613-221-0005
Michael Jordan|1223 Carling Ave.|613-222-0006
Roger Clemens|14 Hopewell Ave.|613-223-0007
Jack Morris|23 Prince of Wales Dr.|613-226-0008
Roberto Alomar|55 Moodie Dr.|613-227-0009
Joe Carter|18 Summerset East.|613-229-0010
Wayne Grekzy|45 Merviale.|613-310-0011
George Bell|46 Colon By Dr.|613-322-0012
Eric Staal|423 Riverside Drive.|613-333-0013
Roy Halladay|23 Ogilvie Rd.|613-334-0014
Mario Lemieux|1129 Bank Dr.|613-389-0015
Patrick Roy|1223 Greenbank Ave.|613-457-0016
Martin Brodeur|14 Baseline Ave.|613-489-0017
Homer Simpson|123 Prince of Wales Dr.|613-523-0018
Bart Simpson|155 Moodie Dr.|613-568-0019
Joe Johnson|21 Sussex Dr.|613-578-0020
Vince Carter|45 Hunt Club St.|613-623-0021
Ed Belfour|46 Fisher St.|613-645-0022
Bobby Orr|48 Prince Edward St.|613-657-0023
Bobby Hull|23 Wellington St.|613-712-0024
Gordie Howe|1129 Preston Dr.|613-728-0025
Larry Bird|1223 Warden Ave.|613-798-0026
Mark Messier|14 Finch Ave.|416-219-0027
Wade Redden|23 Steeles Ave.|416-331-0028
Sidney Crosby|55 Sheppard Ave.|416-333-0029
Peter Forsberg|1 Kennedy Dr.|416-334-0030
Paul Kariya|45 Midland.|416-756-0031
Rob Blake|12 19th Ave.|705-221-0032
Chris Pronger|48 16th Ave.|905-347-0033
Gary Roberts|23 John St.|905-657-0034
Alex Mogily|1129 14th Ave.|905-819-0035
Scott Gomez|1223 Montreal Ave.|819-223-0036
Frank Thomas|14 Hull Ave.|819-227-0037
Barry Bonds|23 Hood Rd.|705-221-0038
Hank Aaron|55 Denison Ave.|819-223-0039
Babe Ruth|1 Old Kennedy.|819-227-0040
Ted Williams|45 Birchmount Ave.|905-347-0041
Chris Bosh|46 Queens Ave.|905-657-0042
Steve Sampras|448 St Clare Ave.|905-819-0043
Kobe Bryan|23 Bayview St.|416-219-0044
Kevin Garnett|59 Mike Myers Dr.|416-331-0045
Larry Brown|99 Blue Jays Ave.|416-333-0046
Brooke Shields|69 College Ave.|416-334-0047
Matt Stajan|50 LakeShore Ave.|416-756-0048
Tie Domi|89 Spidina Rd.|705-221-0049
Tevor Kidd|30 McCowan Ave.|819-227-0050
*/
