# this will import a function for finding combinations for the generation of
# all possible tuples (from which random elements are assigned)
from itertools import combinations

# this will import a function for pausing the execution of this program
from time import sleep

# this should allow us to open the image in whatever the default program is
from os import system


# this is the list of student numbers in the class	
__database__ = {}

#  currently 516 students, which is ~ 529 = 23 x 23
__database__['101035873'] = [0,0]
__database__['101038246'] = [0,1]
__database__['101034825'] = [0,2]
__database__['101037604'] = [0,3]
__database__['101030779'] = [0,4]
__database__['101014635'] = [0,5]
__database__['101040231'] = [0,6]
__database__['101055759'] = [0,7]
__database__['101044511'] = [0,8]
__database__['101045985'] = [0,9]
__database__['101047854'] = [0,10]
__database__['101053021'] = [0,11]
__database__['101013731'] = [0,12]
__database__['101040542'] = [0,13]
__database__['101052509'] = [0,14]
__database__['101010199'] = [0,15]
__database__['101013548'] = [0,16]
__database__['101057305'] = [0,17]
__database__['101047998'] = [0,18]
__database__['101039849'] = [0,19]
__database__['101038737'] = [0,20]
__database__['100999408'] = [0,21]
__database__['101048017'] = [0,22]
__database__['101031338'] = [1,0]
__database__['101025025'] = [1,1]
__database__['101022679'] = [1,2]
__database__['100988255'] = [1,3]
__database__['101024183'] = [1,4]
__database__['101046422'] = [1,5]
__database__['101033098'] = [1,6]
__database__['101032193'] = [1,7]
__database__['101045407'] = [1,8]
__database__['101034925'] = [1,9]
__database__['101034935'] = [1,10]
__database__['101050900'] = [1,11]
__database__['100650379'] = [1,12]
__database__['101027637'] = [1,13]
__database__['101043639'] = [1,14]
__database__['101028735'] = [1,15]
__database__['101047309'] = [1,16]
__database__['101014371'] = [1,17]
__database__['101054446'] = [1,18]
__database__['101057838'] = [1,19]
__database__['101022463'] = [1,20]
__database__['101031764'] = [1,21]
__database__['101014409'] = [1,22]
__database__['101036762'] = [2,0]
__database__['101014678'] = [2,1]
__database__['100969921'] = [2,2]
__database__['100995436'] = [2,3]
__database__['101009259'] = [2,4]
__database__['101042914'] = [2,5]
__database__['101035832'] = [2,6]
__database__['101040574'] = [2,7]
__database__['100844629'] = [2,8]
__database__['101006978'] = [2,9]
__database__['100879652'] = [2,10]
__database__['101035048'] = [2,11]
__database__['100833054'] = [2,12]
__database__['101037988'] = [2,13]
__database__['101045226'] = [2,14]
__database__['101000527'] = [2,15]
__database__['101031002'] = [2,16]
__database__['101038464'] = [2,17]
__database__['101056669'] = [2,18]
__database__['101001808'] = [2,19]
__database__['101041123'] = [2,20]
__database__['101031067'] = [2,21]
__database__['101038473'] = [2,22]
__database__['101036804'] = [3,0]
__database__['101044962'] = [3,1]
__database__['101007585'] = [3,2]
__database__['101059404'] = [3,3]
__database__['101039496'] = [3,4]
__database__['101058716'] = [3,5]
__database__['101033646'] = [3,6]
__database__['101035484'] = [3,7]
__database__['101042657'] = [3,8]
__database__['101039163'] = [3,9]
__database__['101053165'] = [3,10]
__database__['101038990'] = [3,11]
__database__['101029224'] = [3,12]
__database__['101039776'] = [3,13]
__database__['101055027'] = [3,14]
__database__['100948621'] = [3,15]
__database__['101042742'] = [3,16]
__database__['101042961'] = [3,17]
__database__['101036831'] = [3,18]
__database__['101028896'] = [3,19]
__database__['101042739'] = [3,20]
__database__['101008328'] = [3,21]
__database__['101040239'] = [3,22]
__database__['101000208'] = [4,0]
__database__['101034784'] = [4,1]
__database__['101034878'] = [4,2]
__database__['101014788'] = [4,3]
__database__['100999429'] = [4,4]
__database__['101054302'] = [4,5]
__database__['101011810'] = [4,6]
__database__['100819007'] = [4,7]
__database__['101035085'] = [4,8]
__database__['101047967'] = [4,9]
__database__['101030746'] = [4,10]
__database__['101027794'] = [4,11]
__database__['101032189'] = [4,12]
__database__['101044778'] = [4,13]
__database__['101043128'] = [4,14]
__database__['101045727'] = [4,15]
__database__['100982536'] = [4,16]
__database__['100973572'] = [4,17]
__database__['101034766'] = [4,18]
__database__['101048192'] = [4,19]
__database__['101046967'] = [4,20]
__database__['101045864'] = [4,21]
__database__['101050988'] = [4,22]
__database__['101049041'] = [5,0]
__database__['101032383'] = [5,1]
__database__['101040445'] = [5,2]
__database__['101034154'] = [5,3]
__database__['101036498'] = [5,4]
__database__['101031529'] = [5,5]
__database__['100943024'] = [5,6]
__database__['101049422'] = [5,7]
__database__['101005235'] = [5,8]
__database__['101018290'] = [5,9]
__database__['101031827'] = [5,10]
__database__['101047441'] = [5,11]
__database__['101039154'] = [5,12]
__database__['101052969'] = [5,13]
__database__['101035212'] = [5,14]
__database__['101005168'] = [5,15]
__database__['101015422'] = [5,16]
__database__['101040701'] = [5,17]
__database__['101046093'] = [5,18]
__database__['101047493'] = [5,19]
__database__['101048897'] = [5,20]
__database__['101046250'] = [5,21]
__database__['101022544'] = [5,22]
__database__['101056093'] = [6,0]
__database__['101042812'] = [6,1]
__database__['101054657'] = [6,2]
__database__['101033756'] = [6,3]
__database__['101029247'] = [6,4]
__database__['101036038'] = [6,5]
__database__['101024063'] = [6,6]
__database__['100971269'] = [6,7]
__database__['101037130'] = [6,8]
__database__['101008623'] = [6,9]
__database__['101032645'] = [6,10]
__database__['101007337'] = [6,11]
__database__['101040808'] = [6,12]
__database__['101044797'] = [6,13]
__database__['101031581'] = [6,14]
__database__['101042483'] = [6,15]
__database__['101043340'] = [6,16]
__database__['101043160'] = [6,17]
__database__['100940324'] = [6,18]
__database__['101033119'] = [6,19]
__database__['101014766'] = [6,20]
__database__['101012149'] = [6,21]
__database__['101035684'] = [6,22]
__database__['101041380'] = [7,0]
__database__['101033745'] = [7,1]
__database__['101047929'] = [7,2]
__database__['101044253'] = [7,3]
__database__['101058028'] = [7,4]
__database__['101041370'] = [7,5]
__database__['101035030'] = [7,6]
__database__['100994952'] = [7,7]
__database__['101045376'] = [7,8]
__database__['101038470'] = [7,9]
__database__['101011397'] = [7,10]
__database__['100794996'] = [7,11]
__database__['101029196'] = [7,12]
__database__['101048234'] = [7,13]
__database__['101023852'] = [7,14]
__database__['100668673'] = [7,15]
__database__['101036974'] = [7,16]
__database__['101036399'] = [7,17]
__database__['101043323'] = [7,18]
__database__['101050732'] = [7,19]
__database__['100809005'] = [7,20]
__database__['100974530'] = [7,21]
__database__['101012998'] = [7,22]
__database__['101049573'] = [8,0]
__database__['101054951'] = [8,1]
__database__['101034838'] = [8,2]
__database__['101047189'] = [8,3]
__database__['101058116'] = [8,4]
__database__['101035548'] = [8,5]
__database__['101041750'] = [8,6]
__database__['101032870'] = [8,7]
__database__['100987687'] = [8,8]
__database__['101031085'] = [8,9]
__database__['101047999'] = [8,10]
__database__['101004948'] = [8,11]
__database__['101030220'] = [8,12]
__database__['101044967'] = [8,13]
__database__['101050152'] = [8,14]
__database__['100866726'] = [8,15]
__database__['101036926'] = [8,16]
__database__['101029479'] = [8,17]
__database__['101049910'] = [8,18]
__database__['101041879'] = [8,19]
__database__['101036873'] = [8,20]
__database__['100948773'] = [8,21]
__database__['100281178'] = [8,22]
__database__['101029994'] = [9,0]
__database__['101040017'] = [9,1]
__database__['101035209'] = [9,2]
__database__['101037568'] = [9,3]
__database__['101044214'] = [9,4]
__database__['100977885'] = [9,5]
__database__['100940196'] = [9,6]
__database__['101033610'] = [9,7]
__database__['101040037'] = [9,8]
__database__['101036672'] = [9,9]
__database__['101048382'] = [9,10]
__database__['101036054'] = [9,11]
__database__['100860542'] = [9,12]
__database__['101045987'] = [9,13]
__database__['101054666'] = [9,14]
__database__['101048810'] = [9,15]
__database__['101036827'] = [9,16]
__database__['101057702'] = [9,17]
__database__['101048428'] = [9,18]
__database__['100869993'] = [9,19]
__database__['101034145'] = [9,20]
__database__['101040401'] = [9,21]
__database__['100975215'] = [9,22]
__database__['100717215'] = [10,0]
__database__['101056842'] = [10,1]
__database__['101024478'] = [10,2]
__database__['101031155'] = [10,3]
__database__['101040698'] = [10,4]
__database__['101034358'] = [10,5]
__database__['101049087'] = [10,6]
__database__['101050370'] = [10,7]
__database__['101043532'] = [10,8]
__database__['101049011'] = [10,9]
__database__['101034605'] = [10,10]
__database__['101020711'] = [10,11]
__database__['100978619'] = [10,12]
__database__['101038202'] = [10,13]
__database__['101047475'] = [10,14]
__database__['101007496'] = [10,15]
__database__['101051240'] = [10,16]
__database__['101032334'] = [10,17]
__database__['101046462'] = [10,18]
__database__['101033693'] = [10,19]
__database__['101038024'] = [10,20]
__database__['101029846'] = [10,21]
__database__['101031803'] = [10,22]
__database__['101039899'] = [11,0]
__database__['101047827'] = [11,1]
__database__['101055290'] = [11,2]
__database__['101031596'] = [11,3]
__database__['101007322'] = [11,4]
__database__['101014162'] = [11,5]
__database__['101044173'] = [11,6]
__database__['100893515'] = [11,7]
__database__['101048863'] = [11,8]
__database__['101055193'] = [11,9]
__database__['101047951'] = [11,10]
__database__['101044467'] = [11,11]
__database__['101017144'] = [11,12]
__database__['101041818'] = [11,13]
__database__['101035194'] = [11,14]
__database__['100965719'] = [11,15]
__database__['101039784'] = [11,16]
__database__['101039500'] = [11,17]
__database__['101044302'] = [11,18]
__database__['101057748'] = [11,19]
__database__['100973214'] = [11,20]
__database__['101042440'] = [11,21]
__database__['101049045'] = [11,22]
__database__['101038916'] = [12,0]
__database__['101042319'] = [12,1]
__database__['101006098'] = [12,2]
__database__['101021301'] = [12,3]
__database__['100766095'] = [12,4]
__database__['101011933'] = [12,5]
__database__['101057299'] = [12,6]
__database__['101050609'] = [12,7]
__database__['101057704'] = [12,8]
__database__['100715712'] = [12,9]
__database__['101058264'] = [12,10]
__database__['101045778'] = [12,11]
__database__['101057419'] = [12,12]
__database__['101000269'] = [12,13]
__database__['101007934'] = [12,14]
__database__['101036858'] = [12,15]
__database__['101052330'] = [12,16]
__database__['101033544'] = [12,17]
__database__['101042073'] = [12,18]
__database__['101048300'] = [12,19]
__database__['101032740'] = [12,20]
__database__['101045818'] = [12,21]
__database__['101035166'] = [12,22]
__database__['101034062'] = [13,0]
__database__['101030891'] = [13,1]
__database__['101013143'] = [13,2]
__database__['101042929'] = [13,3]
__database__['101054944'] = [13,4]
__database__['101042908'] = [13,5]
__database__['101047984'] = [13,6]
__database__['101042788'] = [13,7]
__database__['101034588'] = [13,8]
__database__['101040857'] = [13,9]
__database__['101032049'] = [13,10]
__database__['101008578'] = [13,11]
__database__['101033694'] = [13,12]
__database__['101031228'] = [13,13]
__database__['101029473'] = [13,14]
__database__['101023793'] = [13,15]
__database__['101042728'] = [13,16]
__database__['101055534'] = [13,17]
__database__['101048106'] = [13,18]
__database__['101037088'] = [13,19]
__database__['101031086'] = [13,20]
__database__['100830684'] = [13,21]
__database__['100989761'] = [13,22]
__database__['101046863'] = [14,0]
__database__['101050797'] = [14,1]
__database__['101033931'] = [14,2]
__database__['101042166'] = [14,3]
__database__['101043448'] = [14,4]
__database__['101037730'] = [14,5]
__database__['101027929'] = [14,6]
__database__['101047436'] = [14,7]
__database__['100996115'] = [14,8]
__database__['101038709'] = [14,9]
__database__['101005040'] = [14,10]
__database__['101046157'] = [14,11]
__database__['101049339'] = [14,12]
__database__['101006167'] = [14,13]
__database__['101036389'] = [14,14]
__database__['101050515'] = [14,15]
__database__['100774323'] = [14,16]
__database__['101022029'] = [14,17]
__database__['101058523'] = [14,18]
__database__['101046473'] = [14,19]
__database__['101045271'] = [14,20]
__database__['100977984'] = [14,21]
__database__['100992317'] = [14,22]
__database__['101028771'] = [15,0]
__database__['101034651'] = [15,1]
__database__['101048642'] = [15,2]
__database__['101033751'] = [15,3]
__database__['101049445'] = [15,4]
__database__['100998027'] = [15,5]
__database__['100981171'] = [15,6]
__database__['101015849'] = [15,7]
__database__['101031821'] = [15,8]
__database__['101043557'] = [15,9]
__database__['101046328'] = [15,10]
__database__['101043596'] = [15,11]
__database__['101031243'] = [15,12]
__database__['101030037'] = [15,13]
__database__['101002661'] = [15,14]
__database__['101009604'] = [15,15]
__database__['101012236'] = [15,16]
__database__['101032093'] = [15,17]
__database__['101058037'] = [15,18]
__database__['101017685'] = [15,19]
__database__['101035008'] = [15,20]
__database__['101044151'] = [15,21]
__database__['101029803'] = [15,22]
__database__['101049389'] = [16,0]
__database__['100826452'] = [16,1]
__database__['101041395'] = [16,2]
__database__['101042669'] = [16,3]
__database__['101036562'] = [16,4]
__database__['101042815'] = [16,5]
__database__['101031242'] = [16,6]
__database__['101046916'] = [16,7]
__database__['101010949'] = [16,8]
__database__['101058609'] = [16,9]
__database__['101031046'] = [16,10]
__database__['101045159'] = [16,11]
__database__['101007346'] = [16,12]
__database__['101035027'] = [16,13]
__database__['101038344'] = [16,14]
__database__['101033363'] = [16,15]
__database__['101046075'] = [16,16]
__database__['101036645'] = [16,17]
__database__['101042056'] = [16,18]
__database__['101059686'] = [16,19]
__database__['100774078'] = [16,20]
__database__['101042950'] = [16,21]
__database__['101047896'] = [16,22]
__database__['101045404'] = [17,0]
__database__['100827020'] = [17,1]
__database__['101018229'] = [17,2]
__database__['101045610'] = [17,3]
__database__['101035086'] = [17,4]
__database__['101036801'] = [17,5]
__database__['101045391'] = [17,6]
__database__['101046295'] = [17,7]
__database__['101013322'] = [17,8]
__database__['101033115'] = [17,9]
__database__['101056741'] = [17,10]
__database__['101029215'] = [17,11]
__database__['100895680'] = [17,12]
__database__['101032821'] = [17,13]
__database__['101030382'] = [17,14]
__database__['101045858'] = [17,15]
__database__['101013172'] = [17,16]
__database__['101045195'] = [17,17]
__database__['100787539'] = [17,18]
__database__['101058032'] = [17,19]
__database__['101033846'] = [17,20]
__database__['101049124'] = [17,21]
__database__['101043117'] = [17,22]
__database__['100880885'] = [18,0]
__database__['101043046'] = [18,1]
__database__['101055312'] = [18,2]
__database__['101035878'] = [18,3]
__database__['101041531'] = [18,4]
__database__['101047293'] = [18,5]
__database__['101058172'] = [18,6]
__database__['101036478'] = [18,7]
__database__['101032864'] = [18,8]
__database__['101031125'] = [18,9]
__database__['101043274'] = [18,10]
__database__['101036148'] = [18,11]
__database__['101024882'] = [18,12]
__database__['100949322'] = [18,13]
__database__['100828244'] = [18,14]
__database__['101040995'] = [18,15]
__database__['101037563'] = [18,16]
__database__['101032361'] = [18,17]
__database__['100900447'] = [18,18]
__database__['100902566'] = [18,19]
__database__['101015537'] = [18,20]
__database__['101018885'] = [18,21]
__database__['101047338'] = [18,22]
__database__['101029688'] = [19,0]
__database__['101044387'] = [19,1]
__database__['101038255'] = [19,2]
__database__['101046269'] = [19,3]
__database__['101055927'] = [19,4]
__database__['100977501'] = [19,5]
__database__['101036090'] = [19,6]
__database__['101047327'] = [19,7]
__database__['101044160'] = [19,8]
__database__['101007503'] = [19,9]
__database__['101036073'] = [19,10]
__database__['101043555'] = [19,11]
__database__['101032259'] = [19,12]
__database__['101046510'] = [19,13]
__database__['101049886'] = [19,14]
__database__['101042125'] = [19,15]
__database__['101013620'] = [19,16]
__database__['101046945'] = [19,17]
__database__['101041355'] = [19,18]
__database__['101042726'] = [19,19]
__database__['101014598'] = [19,20]
__database__['101042272'] = [19,21]
__database__['100964255'] = [19,22]
__database__['101048005'] = [20,0]
__database__['101054958'] = [20,1]
__database__['100924647'] = [20,2]
__database__['101040154'] = [20,3]
__database__['100914191'] = [20,4]
__database__['101038053'] = [20,5]
__database__['101052692'] = [20,6]
__database__['101013357'] = [20,7]
__database__['101036613'] = [20,8]
__database__['101058109'] = [20,9]
__database__['101030700'] = [20,10]
__database__['101033959'] = [20,11]
__database__['101029199'] = [20,12]
__database__['101046543'] = [20,13]
__database__['101012707'] = [20,14]
__database__['101041858'] = [20,15]
__database__['101030053'] = [20,16]
__database__['101032077'] = [20,17]
__database__['101046032'] = [20,18]
__database__['101038318'] = [20,19]
__database__['101029115'] = [20,20]
__database__['101029319'] = [20,21]
__database__['101041598'] = [20,22]
__database__['101038649'] = [21,0]
__database__['101045728'] = [21,1]
__database__['100894798'] = [21,2]
__database__['101051532'] = [21,3]
__database__['101056567'] = [21,4]
__database__['101036002'] = [21,5]
__database__['101004335'] = [21,6]
__database__['101009206'] = [21,7]
__database__['100982641'] = [21,8]
__database__['100948353'] = [21,9]
__database__['101040918'] = [21,10]
__database__['101032563'] = [21,11]
__database__['101042891'] = [21,12]
__database__['101021403'] = [21,13]
__database__['101035478'] = [21,14]
__database__['101000154'] = [21,15]
__database__['101047476'] = [21,16]
__database__['101048049'] = [21,17]
__database__['101035617'] = [21,18]
__database__['101031436'] = [21,19]
__database__['101036344'] = [21,20]
__database__['101030494'] = [21,21]
__database__['101020144'] = [21,22]
__database__['101056888'] = [22,0]
__database__['101045669'] = [22,1]
__database__['101044088'] = [22,2]
__database__['101043184'] = [22,3]
__database__['100978363'] = [22,4]
__database__['101030837'] = [22,5]
__database__['100936599'] = [22,6]
__database__['101032695'] = [22,7]
__database__['101029589'] = [22,8]
__database__['101043192'] = [22,9]

	
	
def intro():

	for i in range(60):
		print()
		sleep(0.02)

	print("           =================================================")
	print("           =                                               =")
	print("           =          Unique Assignment Generator          =")
	print("           =               Assignment 1 of 5               =")
	print("           =                                               =")
	print("           =            ( COMP1405, Fall 2015 )            =")
	print("           =                                               =")
	print("           =================================================")
	print()
	print()
	print("--------------------------------------------------------------------------------")
	print()
	print("  DO NOT PROCEED UNTIL YOU HAVE READ THE ASSIGNMENT SPECIFICATION THOROUGHLY  ")
	print()
	print("--------------------------------------------------------------------------------")
	sleep(3)

	
## a function for retrieving, confirming, and validating a student number
#  @param    none
#  @return   the confirmed, valid student number or -1 (if the user aborts)
def getid():

	found = False
	while not found:

		print()
		print("Please enter your student number at the prompt or type quit to end this program.")
		print("   >> ", end = "")
		sid = input()
		
		if sid == "quit":
			return -1

		else:

			if len(sid) != 9:
				print()
				print("! Student numbers at Carleton University are nine (9) digits in length. If you  !",
					"! graduated prior to 2004 and have a five (5) or six (6) digit student number,  !",
					"! then prefix it with either 100 or 1000 respectively.                          !", sep = '\n')

			elif sid not in __database__:
				print()
				print("! The student number that you have entered does not appear inside my database. !",
					"! Confirm that you have typed it in correctly at the prompt and if you made no !",
					"! error use subject line 'Re: COMP1405 - Student Number Not Found' and send an !",
					"! email your instructor immediately.                                           !", sep = '\n')

			else:
				print()
				print("Please confirm your student number by entering it again.")
				print("   >> ", end = "")
				confirm = input()
				if confirm == sid:
					found = True
				else:
					print()
					print("! The two student numbers you have entered do not match. Confirm that you have !",
						"! typed them correctly at the prompts email your instructor immediately if you !",
						"! require any additional assistance.                                           !", sep = '\n')
	
	print()
	print("--------------------------------------------------------------------------------")

	return sid
	
	
	
## the Knuth variant on a simple division hash function
#  @param    k    the key to be hashed
#  @param    m    the number of buckets 
#  @return   the hashed value of the key from the range [0, m)
def khash(k, m):
	return (k * (k + 3)) % m

	
## the generator code for assignment 1, question 1
#  @param    sid    the student id
#  @return   none	
def q1msg(sid):	

	print()
	print("For the first question of the assignment you are being asked to recreate a small")
	print("image using only the graphical primitive functions of the SimpleGraphics library")
	print("(refer to the assignment specification for details). In a moment, the image that")
	print("has been assigned to you will appear in the SimpleGraphics window inside a black")
	print("border. This program will also save this image as a GIF in the current directory")
	print("and it will attempt to open this image with the default program. You should have")
	print("no difficulty using any of these as a reference for your reproduction. That said")
	print("you must ensure that your reproduction appears in the top left of the window and")
	print("does not exceed 100 pixels in width and 50 pixels in height.")
	print()
	
	sleep(4)

	wid = 100
	hgt = 50
	
	row = __database__[sid][0]
	col = __database__[sid][1]

	from SimpleGraphics import loadImage, createImage, getPixel, putPixel, drawImage, resize, background, saveGIF, update
	
	source = loadImage("source-data-01-of-01")

	target = createImage(wid, hgt)
	for x in range(0, wid):
		for y in range(0, hgt):
			r, g, b = getPixel(source, x + col * wid, y + row * hgt)
			putPixel(target, x, y, r, g, b)

	background(0, 0, 0)
	drawImage(target, 5, 5)
	resize(108, 58)	
	update()
	saveGIF(target, "your-assigned-image.gif")
	system("your-assigned-image.gif")
		
## the generator code for assignment 1, question 2
#  @param    sid    the student id
#  @return   none	
def q2msg(sid):	
	
	print()
	print("For the second question of the assignment you are being asked to write a program")
	print("that can convert between uncommon units of measurement. In a moment, these units")
	print("will appear. Make sure you use these values exactly - do not research or compute")
	print("different conversion values.")
	print()
	
	# this is all possible length 2 combinations of the elements of range(9)
	combos = list(combinations(list(range(9)), 2))

	# this is the last digit of the student number
	last = int(sid[len(sid)-1])

	# this is the hashed value of the student number
	hsid = khash(int(sid), len(combos))

	# test the last digit of the student number to determine which unit type will 
	# be assigned, and populate the list accordingly

	if last == 0 or last == 1:

		conversions = [
			"one barrel is equivalent to 0.163659 cubic metres", 
			"one coomb is equivalent to 0.145474 cubic metres", 
			"one hogshead is equivalent to 0.327318 cubic metres", 
			"one load is equivalent to 1.415842 cubic metres", 
			"one perch is equivalent to 0.700842 cubic metres", 
			"one strike is equivalent to 0.072737 cubic metres", 
			"one tun is equivalent to 0.953923 cubic metres", 
			"one pipe is equivalent to 0.476962 cubic metres", 
			"one pottle is equivalent to 0.002273 cubic metres" ]

	elif last == 2 or last == 3:

		conversions = [
			"one bucket is equivalent to 0.018184 cubic metres", 
			"one firkin is equivalent to 0.040914 cubic metres", 
			"one kilderkin is equivalent to 0.081830 cubic metres", 
			"one quarter is equivalent to 0.290949 cubic metres", 
			"one sack is equivalent to 0.109106 cubic metres", 
			"one seam is equivalent to 0.281913 cubic metres", 
			"one bushel is equivalent to 0.036368 cubic metres", 
			"one wey is equivalent to 1.409563 cubic metres", 
			"one last is equivalent to 2.909498 cubic metres" ]

	elif last == 4 or last == 5:

		conversions = [
			"one chain is equivalent to 20.11684 metres",
			"one to fathom is equivalent to 1.8288 metres",
			"one furlong is equivalent to 201.168 metres",
			"one league is equivalent to 4828 metres",
			"one mickey is equivalent to 0.000127 metres",
			"one cloth is equivalent to 0.05715 metres",
			"one point is equivalent to 0.00035145 metres",
			"one rope is equivalent to 6.096 metres",
			"one cable is equivalent to 182.88 metres" ]

	elif last == 6 or last == 7:

		conversions = [
			"one cord is equivalent to 1.48644864 square metres",
			"one acre is equivalent to 4046.873 square metres",
			"one guntha is equivalent to 101.17 square metres",
			"one rood is equivalent to 1011.714106 square metres",
			"one square is equivalent to 9.290304 square metres",
			"one cuerda is equivalent to 3930.395625 square metres",
			"one board is equivalent to 0.007742 square metres",
			"one hide is equivalent to 485000 square metres",
			"one yardland is equivalent to 120000 square metres" ]

	elif last == 8 or last == 9:

		conversions = [
			"one carat is equivalent to 0.0002 kilograms",
			"one grain is equivalent to 0.000065 kilograms",
			"one ounce is equivalent to 0.02835 kilograms",
			"one slug is equivalent to 14.593903 kilograms",
			"one stone is equivalent to 6.350293 kilograms",
			"one cental is equivalent to 45.359237 kilograms",
			"one kip is equivalent to 453.59237 kilograms",
			"one quarter is equivalent to 12.700586 kilograms",
			"one bag is equivalent to 42.637683 kilograms" ]

	print('{:^80}'.format(conversions[combos[hsid][0]]))
	print('{:^80}'.format(conversions[combos[hsid][1]]))
	
	

## the main function for this program
#  @param    none
#  @return   none
def main():

	intro()
	
	sid = getid()
	
	if not(sid == -1):

		q1msg(sid)
		q2msg(sid)

# call the main function to start the program
main()	




