#Imran Juma 101036672
#Assignment 1.1 
#Random Image Assingment
#-----------------------------------------------------------------------Citations-----------------------------------------------------------------------#

#Book Citation: 
	#Giddis, T. (2014) Starting Our With Python (Third Edditon). (pp 1-615)

#Website Citation
	#Hands On Python Tutorial, Turotial 2.4 Graphic. (2016-09-22). Reterived from http://anh.cs.luc.edu/python/hands-on/3.1/handsonHtml/graphics.html#index-6

#Tutorial Citation 
	#Tutorial:1 Drawing with SimpleGraphics Library. (2016-09-16) Reterived from https://culearn.carleton.ca/moodle/pluginfile.php/1831951/mod_resource/content/1/COMP1405-F16-XXX-XX-%28Simple%20Graphics%20Tutorial%20-%20Part%201%20of%202%29.pdf

#----------------------------------------------------------------------Simple Graphics-------------------------------------------------------------------------#

#	Imports the Simple Graphics Library given to us by Professor Rob Collier,
#	as cited in the citations area 

from SimpleGraphics import rect, setFill, setColor, polygon, setOutline

#	This is our background, all black, with the dimention requirments of a 
# 	100x50 Rectangle 

#-----------------------------------------------------------------------Outline Box----------------------------------------------------------------------#

#	SetOutline and SetFill both create the exact purple gathered from Paint 
#	that we need to make the image replicated to have the same colour 
#	effect. 

#	Rather then using the standard colour of "Black" we used the Microsoft
#	Software Called "Paint" to gather this information as cited in the 
#	citations located at the top of our program 

setFill(0, 0, 0)
setOutline (0, 0, 0)
rect(0, 0, 99, 49)

#-------------------------------------------------------------------Purple Sections-----------------------------------------------------------------------#


#	These are the purple sections that can be seen when producting the image 

#	SetOutline and SetFill both create the exact purple gathered from Paint 
#	that we need to make the image replicated to have the same colour 
#	effect. 

#	Rather then using the standard colour of "Purple" we used the Microsoft
#	Software Called "Paint" to gather this information as cited in the 
#	citations located at the top of our program 

setFill(102, 0, 102)
setOutline (102, 0, 102)
polygon(99, 0, 98, 15, 85, 15, 85, 0)
polygon(98, 16, 89, 16)
polygon(88, 0, 85, 0, 85, 15, 88, 15)
polygon(84, 7, 83, 8, 82, 9, 81, 10, 81, 15, 84, 15)
polygon(80, 11, 77, 11, 77, 15, 80, 15)
polygon(76, 11, 65, 11, 64, 14, 76, 14)
polygon(64, 11, 55, 11, 55, 13, 64, 13)
polygon(54, 11, 51, 11, 51, 12, 54, 12)
polygon(51, 11, 50, 10, 48, 9, 48, 8, 47, 7, 46, 6, 46, 12, 51, 12)
polygon(45, 1, 32, 1, 32, 10, 45, 10)
polygon(45, 11, 33, 11)
polygon(44, 0, 32, 0)
polygon(32, 0, 31, 1, 30, 2, 29, 3, 28, 4)
polygon(27, 4, 26, 5, 25, 5, 24, 6, 23, 6, 22, 7, 21, 7, 20, 8, 19, 9, 18, 10, 31, 10, 31, 1)
polygon(18, 10, 16, 10, 16, 11, 18, 11)
polygon(18, 11, 15, 11, 15, 14, 16, 13, 17, 12, 18, 11)
polygon(14, 11, 0, 11, 0, 20, 14, 20)
polygon(14, 21, 1, 21, 2, 22, 2, 23, 4, 24, 4, 25, 5, 26, 6, 27, 8, 28, 7, 29)
polygon(14, 29, 7, 29, 8, 30, 8, 31, 9, 32, 9, 33, 10, 34, 10, 35, 11, 36, 11, 37, 11, 38, 14, 38)
polygon(14, 23, 10, 24, 10, 30, 14, 30)
polygon(14, 28, 11, 38, 12, 39, 12, 40, 12, 41, 13, 42, 13, 43, 13, 44, 13, 45, 13, 46, 14, 47, 14, 48, 14, 48, 14, 36)
polygon(14, 11, 14, 48)

#-------------------------------------------------------------------White Sections-------------------------------------------------------------------#

#	These are the white sections that can be seen when producting the image 

#	SetOutline and SetFill both create the exact white gathered from Paint 
#	that we need to make the image replicated to have the same colour 
#	effect. 

#	Rather then using the standard colour of "Snow" we used the Microsoft
#	Software Called "Paint" to gather this information as cited in the 
#	citations located at the top of our program 

setFill(255, 255, 255)
setOutline (255, 255, 255)
polygon(23, 49, 23, 19, 99, 26, 99, 49)
polygon(0, 49, 0, 36, 2, 42, 4, 49)
polygon(0, 0, 14, 0, 13, 1, 11, 2, 0, 2)
polygon(54, 0, 75, 0, 76, 2, 55, 2, 55, 1, 54, 1)

#------------------------------------------------------------------End Of Assingment---------------------------------------------------------------------------#







