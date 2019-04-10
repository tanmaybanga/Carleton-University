from SimpleGraphics import rect, setFill, setColor, ellipse, arc, line



#Outside Frame
setFill("Black")
rect (10, 10, 150, 150)

#Head
setFill("Blue")
ellipse (25, 25, 100, 100)

#Eyes
setFill("Orange")
ellipse (35, 50, 30, 30)
setFill("Orange")
ellipse (80, 50, 30, 30)

#SmileFace
setColor("Snow")
arc (50, 75, 50, 25, 180, 180)

#Antenna
setFill ("Red")
line (25, 25, 25, 70)

