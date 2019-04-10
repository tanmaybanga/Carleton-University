from SimpleGraphics import *
setAutoUpdate(False)
yourimage = input("What Would You Like To Load   ")
img = loadImage (yourimage)
w = getWidth (img)
h = getHeight(img)
new1 = createImage (w,h)
new2 = createImage (w,h)
new3 = createImage (w,h)
for col in range(w):
	for row in range(h):
		r, g, b = getPixel (img, col, row)
		putPixel(new1, col, row, r, 0, 0,)
		putPixel(new2, col, row, 0, g, 0,)
		putPixel(new3, col, row, 0, 0, b,)
	clear()
	update () #This was because Auto Update Was Off
drawImage(new1, w+1,0)
drawImage(new2, 2*w+1,0)
drawImage(new3, 3*w+1,0)
drawImage(img, 0,0)

