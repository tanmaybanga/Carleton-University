from SimpleGraphics import *
setAutoUpdate(False)
img = loadImage("RIP.gif")
w = getWidth (img)
h = getHeight(img)
new = createImage (w,h)
for col in range(w):
	for row in range(h):
		r, g, b = getPixel (img, col, row)
		putPixel(new, col, row, 255-r, 255-g, 255-b,)
	clear()
	update () #This was because Auto Update Was Off
drawImage(img,0,0) #This Will Bring The Inverted Image
drawImage(new, w, 0)
