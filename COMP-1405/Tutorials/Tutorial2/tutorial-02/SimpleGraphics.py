##
#  A simple graphics wrapper on top of tkinter
#  Copyright (C) 2013, 2014, 2015 Ben Stephenson
#
#  This wrapper is designed to require as little effort as possible from the
#  programmer making use of it.  Importing the library opens a graphics
#  window, and ensures that the application enters the Tcl/Tk main loop 
#  before the program terminates.  By default, updates are performed to the
#  canvas every time a primitive is drawn or the closed status of the 
#  application is checked.
#
#  The programmer using this wrapper should never call any of the functions
#  that begin with double underscore directly.  
#
#  Known Bugs: 
#    * It appears that different operating systems number the buttons
#      differently.  While button 1 always seems to be the left button, 
#      whether button 2 is the right button or the middle button seems to vary.
#
#    * Changing to a new font using setFont and then displaying text can
#      result in previously drawn text being updated to use the new font.
#      The exact circumstances that cause this to occur are currently unclear.
#
#    * Resize seems to fail on occasion.  The program that displays 
#      all of the colors has demonstrated this behaviour occasionally.
#
#  Please report bugs to ben.stephenson@ucalgary.ca
#
#  Revision History:
#    v1.0.0 -- Publicly released January 23, 2014
#    v1.0.1 -- Publicly released February 7, 2014
#              Added close function to allow the programmer to close the window
#              Added the setWindowTitle function to allow the programmer
#                to change the contents of the window's title bar
#              SimpleGraphics now maintains a list of image references
#                so that images don't disappear when the function ends
#              setWidth() now impacts polygons, blobs, arcs and pie slices
#    v1.0.2 -- Publicly released February 16, 2014
#              Fixed a bug in the close function where it could attempt
#                to invoke a method on a None object without successfully
#                catching the exception.
#    v1.0.3 -- Publicly released August 19, 2014
#              Added savePPM and saveGIF functions for images
#    v1.0.4 -- Publicly released September 26, 2014
#              Added a try/except around the import for unregister so a
#              better error message is displayed when SimpleGraphics.py is
#              run with Python 2.x.y
#    v1.0.5 -- Publicly released November 4, 2014
#              Adjusted the implementation of getPixel to adapt to
#              PhotoImage.get() returning a string in most versions, but a
#              tuple in Python 3.4.x for Windows.
#    v1.0.6 -- Fixed several bugs related to drawing rectangles with widths 
#              and/or heights of 1.
#              Added a name to each font and improved the handling of font
#              modifiers.  This may have fixed the problem with setFont.
#              Added the fontList function
#              Added the keys set
#

import pprint

from sys import exit 

try:
  from atexit import register, unregister 
except:
  print("SimpleGraphics failed to import the unregister function.")
  print("This error was likely caused because you tried to use")
  print("SimpleGraphics.py with Python v2.x.y instead of Python v3.x.y.")
  exit()

from time import sleep
from threading import Lock

try:
  import tkinter as tk
except:
  exit("SimpleGraphics failed to import the required Tk Interface library.")

try:
  import tkinter.font as font
except:
  exit("SimpleGraphics failed to import the required Tk Interface font library.")

# Tcl/Tk master window and canvas
__master = None
__canvas = None

# Maintain a list of image references so that images don't appear when 
# functions end
__image_references = set()

# Has the user clicked on the close button?
__closePressed = False

# The current properties used when drawing shapes on the canvas
__outline = "black"
__fill = "white"
__width = 1
__capstyle = tk.ROUND
__autoupdate = True
__font = None
__font_count = 0

# The current mouse pointer locations on the canvas
__mouseX = 0
__mouseY = 0
__b1down = False
__b2down = False
__b3down = False

# Keyboard state
__typed = ""
__typedLock = Lock()
__keys = set()
__keysLock = Lock()
__heldKeys = set()
__heldLock = Lock()

__background = None
__bgcolor = "#d0d0d0"
  
## Create a window containing a canvas and setup a second thread to ensure
#  that it stays up to date.  Setup the handlers needed for keyboard and 
#  mouse input.
def __init():
  global __canvas
  global __master
  global __background

  # Create the window
  __master = tk.Tk()
  __master.protocol("WM_DELETE_WINDOW", __closeClicked)
  __canvas = tk.Canvas(__master, width=800, height=600)
  __canvas.pack()

  # Setup handlers for mouse and keyboard input
  #__master.bind("<KeyRelease-Control_R>", ctrl_r_release)
  __master.bind("<Escape>", __closeClicked)
  __master.bind("<Key>", __key)
  __master.bind("<KeyRelease>", __keyRelease)
  __master.bind("<Button-1>", __button1pressed)
  __master.bind("<ButtonRelease-1>", __button1released)
  __master.bind("<Button-2>", __button2pressed)
  __master.bind("<ButtonRelease-2>", __button2released)
  __master.bind("<Button-3>", __button3pressed)
  __master.bind("<ButtonRelease-3>", __button3released)
  __master.bind("<FocusOut>", __focusOut)

  # Ensure that mainloop is called before the program exits 
  register(__shutdown)

  # Ensure that a valid font has been setup so that fontWidth will work
  setFont("Arial")

  # Create a rectangle to serve as the background for the window.  Note
  # that we cannot simply change the background color of the canvas because
  # the background of the canvas is not saved when saving the canvas to a 
  # file.
  __background = __canvas.create_rectangle(0, 0, getWidth()+1, getHeight()+1, fill=__bgcolor, outline=__bgcolor, tag="__background")

  # Ensure that the graphics window displays promptly
  update()
  __master.focus_set()

def ctrl_r_release(event):
  print("Right control released")

# Clear all keys being held when our window loses focus
# @param event the event data associated with the FocusOut event
def __focusOut(event):
  __heldLock.acquire()
  __heldKeys.clear()
  __heldLock.release()

# Record the status of mouse button 1
# @param event the event data associated with the mouse button press
def __button1pressed(event):
  global __b1down
  __b1down = True

# Record the status of mouse button 1
# @param event the event data associated with the mouse button release
def __button1released(event):
  global __b1down
  __b1down = False

# Return true if and only if the left button is currently depressed
# @param the current pressed status of the left mouse button
def leftButtonPressed():
  return __b1down

# Record the status of mouse button 2
# @param event the event data associated with the mouse button press
def __button2pressed(event):
  global __b2down
  __b2down = True

# Record the status of mouse button 2
# @param event the event data associated with the mouse button release
def __button2released(event):
  global __b2down
  __b2down = False

# Return true if and only if the left button is currently depressed
# @param the current pressed status of the middle mouse button
#
# Known Bug: On some operating systems this is actually reporting the status
#            of the right mouse button
def middleButtonPressed():
  return __b2down

# Record the status of mouse button 3
# @param event the event data associated with the mouse button press
def __button3pressed(event):
  global __b3down
  __b3down = True

# Record the status of mouse button 3
# @param event the event data associated with the mouse button release
def __button3released(event):
  global __b3down
  __b3down = False

# Return true if and only if the left button is currently depressed
# @param the current pressed status of the middle mouse button
#
# Known Bug: On some operating systems this is actually reporting the status
#            of the middle mouse button
def rightButtonPressed():
  return __b3down

## Event handler that runs when a key is pressed.
#  @param event the key event, with the key in the char field
def __key(event):
  global __typed
  #print("Pressed", event.keycode)
  #print("Pressed", event.keysym_num)
  if event.char != "":
    __typedLock.acquire()
    try:
      # If backspace is pressed
      if ord(event.char) == 8:
        if len(__typed) > 0:
          __typed = __typed[:-1]
      # If we haven't hit the input buffer limit
      elif len(__typed) < 1024:
        __typed = __typed + event.char
      # We have hit the buffer limit
      else:
        __typed = __typed[1:] + event.char
    finally:
      # Release the lock no matter what
      __typedLock.release()
      pass;

  if event.keysym != "":
    __keysLock.acquire()
    __keys.add(event.keysym)
    __keysLock.release()

    __heldLock.acquire()
    __heldKeys.add(event.keysym)
    __heldLock.release()

## Event handler that runs when a key is pressed.
#  @param event the key event, with the key in the char field
def __keyRelease(event):
  #print("Released", event.keycode)
  #print("Released", event.keysym_num)
  if event.keysym != "":
    __heldLock.acquire()
    if event.keysym in __heldKeys:
      __heldKeys.remove(event.keysym)
    else:
      #print("Got an unmatched release event: '" + event.keysym + "'")
      pass
    __heldLock.release()


## Event handler that runs when the close button is clicked or escape is 
#  pressed.  Does some cleanup to get the application to shutdown nicely.
#  @param event the event object (if any) passed when the handler was invoked
def __closeClicked(event = None):
  global __closePressed
  global __canvas
  global __master

  __closePressed = True
  try:
    __canvas = None
    __master.destroy()
    __master = None
    unregister(__shutdown)
  finally:
    pass;

# Close the window
def close():
  global __closePressed
  global __canvas
  global __master

  __closePressed = True
  try:
    __canvas = None
    __master.destroy()
    __master = None
    unregister(__shutdown)
  except:
    try:
      unregister(__shutdown)
    except:
      pass;

# Set the window title
# @param t the new title for the window
def setWindowTitle(t):
  global __master
  __master.wm_title(t)


## Update the canvas if the programmer has automatic updates turned on
def __update():
  try:
    if __canvas != None and __autoupdate:
      __canvas.update()
  finally:
    pass;

## Force the canvas to update 
def update():
  if __canvas != None:
    __canvas.update()

## Return all of the input typed by the user, removing it from the input buffer
def getTyped():
  global __typed

  __typedLock.acquire()
  result = __typed
  __typed = ""
  __typedLock.release()

  return result

## Return any input typed by the user without removing it from the input buffer
def peekTyped():
  __typedLock.acquire()
  result = __typed
  __typedLock.release()

  return result

## Return a set of all of the keys pressed since the last time getKeys was
#  called.
def getKeys():
  __keysLock.acquire()
  retval = __keys.copy()
  __keys.clear()
  __keysLock.release()

  return retval

## Return a set of all of the keys that are currently held down
#  Note that if the window does not have focus then the set of keys returned
#  will be empty, even if there are keys being pressed.
def getHeldKeys():
  __heldLock.acquire()
  retval = __heldKeys.copy()
  __heldLock.release()

  return retval


## Return a set of all of the keys pressed since the last time getKeys was
#  called.  Does not clear the set of keys that have been pressed.
def peekKeys():
  __keysLock.acquire()
  retval = set(__keys)
  __keysLock.release()

  return retval



## Return the characters typed by the user up to the first newline character.
#  Return an empty string if a newline has not yet been entered.  Any
#  characters returned are removed from the input buffer.
def getTypedLine():
  global __typed
  result = ""

  __typedLock.acquire()
  crpos = __typed.find(chr(10))
  lfpos = __typed.find(chr(13))

  if crpos >= 0 or lfpos >= 0:
    result = __typed[:max(crpos, lfpos) + 1]
    __typed = __typed[max(crpos, lfpos) + 1:]

  __typedLock.release()

  return result

## Return the characters typed by the user up to the first newline character.
#  Return an empty string if a newline has not yet been entered.  Any
#  characters returned remain in the input buffer.
def peekTypedLine():
  global __typed
  result = ""

  __typedLock.acquire()
  crpos = __typed.find(chr(10))
  lfpos = __typed.find(chr(13))

  if crpos >= 0 or lfpos >= 0:
    result = __typed[:max(crpos, lfpos) + 1]
  __typedLock.release()

  return result

"""
## Read a line of text from the user, typed into the graphics window.  This
#  function blocks until enter is pressed.
def readLine():
  global __typed

  crpos = __typed.find(chr(10))
  lfpos = __typed.find(chr(13))

  while crpos == -1 and lfpos == -1 and __updateThreadDone == False:
    crpos = __typed.find(chr(10))
    lfpos = __typed.find(chr(13))

  __typedLock.acquire()
  try:
    if crpos == -1 and lfpos == -1:
      retval = __typed
      __typed = ""
      return retval
    if crpos == -1:
      pos = lfpos
      tp = pos
    elif lfpos == -1:
      pos = crpos
      tp = pos
    else:
      pos = min(lfpos, crpos)
      tp = max(lfpos, crpos)

    retval = __typed[:pos]
    __typed = __typed[tp + 1:]

  finally:
    __typedLock.release()

  return retval
"""

## Has the user clicked the close button?
#  @return True if the close button has been clicked, False otherwise.
def closed():
  try:
    __master.update()
    return __closePressed
  except:
    return True

## Retrieve the current x and y location of the mouse pointer
#  @return a tuple containing the mouse X location and mouse Y location
def mousePos():
  global __mouseX
  global __mouseY

  try:
    (x, y) = __canvas.winfo_pointerxy()
    x = x - __canvas.winfo_rootx()
    y = y - __canvas.winfo_rooty()
    __mouseX = x
    __mouseY = y
    return (__mouseX, __mouseY)

  except AttributeError:
    return (__mouseX, __mouseY)

## Retrieve the x portion of the mouse cursor's position
#  @return the x position of the mouse cursor
def mouseX():
  return mousePos()[0]

## Retrieve the y portion of the mouse cursor's position
#  @return the y position of the mouse cursor
def mouseY():
  return mousePos()[1]

## Set the outline color
#  @param r the red component of the color, or the color name
#  @param g the green component of the color, or None if a named color is used
#  @param b the blue component of the color, or None if a named color is used
def setOutline(r, g=None, b=None):
  global __outline
  if g == None and b == None:
    __outline = r
  elif g != None and b != None:
    __outline = "#%02x%02x%02x" % (r, g, b)
  else:
    raise TypeError("setOutline cannot be called with 2 arguments")

## Set the fill color
#  @param r the red component of the color, or the color name
#  @param g the green component of the color, or None if a named color is used
#  @param b the blue component of the color, or None if a named color is used
def setFill(r, g=None, b=None):
  global __fill
  if g == None and b == None:
    __fill = r
  elif g != None and b != None:
    __fill = "#%02x%02x%02x" % (r, g, b)
  else:
    raise TypeError("setFill cannot be called with 2 arguments")

## Set the width of lines used when drawing
#  @param w the width of the line in pixels (default is 1)
def setWidth(w=1):
  global __width
  __width = w

"""
## Set the cap style used when lines are drawn (only matters for wide lines).
#  Styles can be tk.BUTT (default), tk.PROJECTING or tk.ROUND
def setCapStyle(s = tk.BUTT):
  global __style
  __style = s
"""

## Set both the fill and outline colors to the same value
#  @param r the red component of the color, or the color name
#  @param g the green component of the color, or None if a named color is used
#  @param b the blue component of the color, or None if a named color is used
def setColor(r, g=None, b=None):
  if g != None and b == None:
    raise TypeError("setColor cannot be called with 2 arguments")
  setFill(r, g, b)
  setOutline(r, g, b)

## Set the background color of the window
#  @param r the red component of the color, or the color name
#  @param g the green component of the color, or None if a named color is used
#  @param b the blue component of the color, or None if a named color is used
def background(r, g=None, b=None):
  global __bgcolor

  if g == None and b == None:
    bg = r
  elif g != None and b != None:
    bg = "#%02x%02x%02x" % (r, g, b)
  else:
    raise TypeError("background cannot be called with 2 arguments")
  #__canvas.configure(background=bg)
  __bgcolor = bg
  __canvas.itemconfig(__background,fill=bg)
  __update()


## Draw a line connecting the points provided as a parameter
#  @param the points of the line in the form x1, y1, x2, y2, ... , xn, yn.
#         The parameter can either be a single list or provided as individual
#         parameters.
def line(*pts):
  try:
    if len(pts) == 1:
      new_pts = pts[0]
    else:
      new_pts = list(pts)
    for i in range(len(new_pts)):
      new_pts[i] = new_pts[i] + 1
    __canvas.create_line(new_pts, fill=__outline, width=__width, capstyle=__capstyle)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass;

## Draw a curve connecting the first point to the last point.  The curve is
#  influenced by, but does not necessarily pass through the intermediate 
#  points.  Repeating a coordinate in the points will ensure that the
#  curve passes through it, but will normally result in a discontinuity in 
#  the curve.
#  @param the points of the curve in the form x1, y1, x2, y2, ... , xn, yn.
#         The parameter can either be a single list or provided as individual
#         parameters.
def curve(*pts):
  try:
    if len(pts) == 1:
      new_pts = pts[0]
    else:
      new_pts = list(pts)
    for i in range(len(new_pts)):
      new_pts[i] = new_pts[i] + 1

    __canvas.create_line(new_pts, fill=__outline, width=__width, capstyle=__capstyle, smooth=True, splinesteps=25)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass;

## Draw a filled curve connecting the first point to the last point.  The 
#  curve is influenced by, but does not necessarily pass through the 
#  intermediate points.  Repeating a coordinate in the points will ensure 
#  that the curve passes through it, but will normally result in a 
#  discontinuity in the curve.
#
#  @param the points of the curve in the form x1, y1, x2, y2, ... , xn, yn.
#         The parameter can either be a single list or provided as individual
#         parameters.
def blob(*pts):
  try:
    if len(pts) == 1:
      new_pts = pts[0]
    else:
      new_pts = list(pts)
    for i in range(len(new_pts)):
      new_pts[i] = new_pts[i] + 1

    __canvas.create_polygon(new_pts, fill=__fill, outline=__outline, smooth=1, width=__width)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass;

## Draw a rectangle with its upper left corner at (x,y)
#  @param x the x part of the coordinate of the upper left corner
#  @param y the y part of the coordinate of the upper left corner
#  @param w the width of the rectangle
#  @param h the height of the rectangle
def rect(x, y, w, h):
  w = round(w)
  h = round(h)
  try:
    if abs(w) >= 2 and abs(h) >= 2:
      __canvas.create_rectangle(x + 1, y + 1, x + 1 + w - 1, y + 1 + h - 1, fill=__fill, outline=__outline, width=__width)
      __update()
    elif abs(w) == 1:
      line(x, y, x, y + h - 1)
      __update()
    elif abs(h) == 1:
      line(x, y, x + w - 1, y)
      __update()
    
  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass;

## Draw an ellipse
#  @param x the x part of the coordinate of the upper left corner
#  @param y the y part of the coordinate of the upper left corner
#  @param w the width of the ellipse
#  @param h the height of the ellipse
def ellipse(x, y, w, h):
  try:
    __canvas.create_oval(x + 1, y + 1, x+w, y+h, fill=__fill, outline=__outline, width=__width)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass

## Place some text on the canvas
#  @param x the x part of the coordinate of the where the text will be placed
#  @param y the y part of the coordinate of the where the text will be placed
#  @param what the string of text to display
#  @param align the alignment to use (by default, center the text at (x,y))
def text(x, y, what, align="c"):
  try:
    __canvas.create_text(x + 1, y + 1, text=str(what), anchor=align, fill=__outline, font=__font)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass

# Set the current font, size and modifiers
# @param f the name of a font.  For example Times or Arial
# @param the size of the font (larger numbers are bigger)
# @param modifiers for the font such as bold and italic.  Multiple modifiers
#        should be separated by spaces such as "bold italic"
def setFont(f=None, s=10, modifiers=""):
  global __font
  global __font_count

  if f == None:
    __font = None
    return True
  else:
    try:
      #__font = (f, s, modifiers)
      modifiers = modifiers.lower()

      if "bold" in modifiers:
        w = font.BOLD
      else:
        w = font.NORMAL

      if "italic" in modifiers:
        sl = font.ITALIC
      else:
        sl = font.ROMAN

      if "underline" in modifiers:
        und = True
      else:
        und = False

      if "overstrike" in modifiers:
        ovs = True
      else:
        ovs = False

      __font = font.Font(family=f, size=s, name=str(__font_count), weight=w, slant=sl, underline=und, overstrike=ovs)
      __font_count += 1
      return True
    except Exception as e:
      __font = None
      return False

# Determine the width of some text in pixels
# @param s the text to measure
# @return the width required to display s in pixels
def textWidth(s):
  try:
    return __font.measure(s)
  except:
    return -1

# Determine the amount of vertical space between adjacent lines of text
# @param s optional text that can be provided, but doesn't actually influence
#        the value that is returned
# @return the number of pixel that should be used between adjacent lines of text
def lineSpace(s=""):
  try:
    return __font.metrics("linespace")
  except:
    return -1

# Resize the window to a specific size in pixels
# @param w the new window width
# @param h the new window height
def resize(w, h):
  global __background

  __canvas.config(width=w, height=h)
  __canvas.delete(__background)
  __background = __canvas.create_rectangle(0, 0, w+1, h+1, fill=__bgcolor, outline=__bgcolor, tag="__background")
  __canvas.lower(__background)

# Get the width of the window or an image
# @param the image to examine, or None which indates that the width of the
#        window should be returned
# @param the width
def getWidth(what=None):
  if what == None:
    try:
      return int(__canvas['width'])
    except TypeError:
      return -1
  elif type(what) is tk.PhotoImage:
    return what.width()
  else:
    raise TypeError("Could not get the width of the provided object")

# Get the height of the window or an image
# @param the image to examine, or None which indates that the height of the
#        window should be returned
# @param the height
def getHeight(what=None):
  if what == None:
    try:
      return int(__canvas['height'])
    except TypeError:
      return -1
  elif type(what) is tk.PhotoImage:
    return what.height()
  else:
    raise TypeError("Could not get the height of the provided object")

## Create an arc, with the bounding box of the ellipse, start angle (in degrees)
#  and extent of the arc (in degrees).  The starting angle is at 3 o'clock,
#  and angles move counter-clockwise.
#  @param x the x position of the upper left corner of the bounding box
#  @param y the y position of the upper left corner of the bounding box
#  @param w the width of the bounding box
#  @param h the height of the bounding box
#  @param s the starting angle
#  @param e the extent of the arc (*not* the ending angle)
def arc(x, y, w, h, s, e):
  try:
    __canvas.create_arc(x + 1, y + 1, x+1+w, y+1+h, start=s, extent=e, fill=__fill, outline=__outline, style=tk.ARC, width=__width)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass

## Create a pie slice, with the bounding box of the ellipse, start angle (in 
#  degrees) and extent of the arc (in degrees).  The starting angle is at 3 
#  o'clock, and angles move counter-clockwise.
#  @param x the x position of the upper left corner of the bounding box
#  @param y the y position of the upper left corner of the bounding box
#  @param w the width of the bounding box
#  @param h the height of the bounding box
#  @param s the starting angle
#  @param e the extent of the arc (*not* the ending angle)
def pieSlice(x, y, w, h, s, e):
  try:
    __canvas.create_arc(x + 1, y + 1, x+1+w, y+1+h, start=s, extent=e, fill=__fill, outline=__outline, style=tk.PIESLICE, width=__width)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass

## Draw a filled polygon connecting each point to its neighbors using
#  straight line segments.
#  @param the points of the polygon in the form x1, y1, x2, y2, ... , xn, yn.
def polygon(x1, y1=[], *args):
  try:
    if y1 != []:
      pts = [x1, y1]
      pts.extend(args)
    else:
      pts = list(x1)
      pts.extend(y1)
      pts.extend(args)

    for i in range(len(pts)):
      pts[i] = pts[i] + 1
    __canvas.create_polygon(pts, fill=__fill, outline=__outline, width=__width)
    __update()

  except Exception as e:
    if __canvas == None:
      pass;
    else:
      raise e

  finally:
    pass

## Remove all drawing objects from the canvas
def clear():
  try:
    __canvas.delete("all")
    __background = __canvas.create_rectangle(0, 0, getWidth(), getHeight(), fill=__bgcolor, outline=__bgcolor, tag="__background")
  except AttributeError:
    pass;
  #del __image_references[:]
  __image_references.clear()
  __update()

## Should the screen be updated automatically after each graphics primitive
#  is drawn?
def setAutoUpdate(status):
  global __autoupdate
  __autoupdate = status

## Shutdown handler that ensures that the program doesn't close inadvertently
def __shutdown():
  tk.mainloop()

## Determine the version of the library
#  @return the version number as a floating point value
def version():
  return "1.0.6"

## Save the current contents of the window as an encapsulated postscript file.
#  @param fname the name of the file that will be written (normally ends with
#         .eps)
def saveEPS(fname):
  __canvas.postscript(file=fname, colormode="color", width=getWidth(), height=getHeight())
  
## Create a new blank image
#  @param w the width of the created image
#  @param h the height of the created image
#  @return a new image object
def createImage(w, h):
  retval = tk.PhotoImage(width=w, height=h)
  return retval

## Create a new image by loading an image file in .gif or .ppm format
#  @param fname the name of the file to load
#  @return a new image object loaded with the data from the file
def loadImage(fname):
  retval = tk.PhotoImage(file=fname)
  return retval

## Write a pixel into an image
#  @param img the image to modify
#  @param x the x position that will be modified
#  @param y the y position that will be modified
#  @param r the red component of the new pixel color
#  @param g the green component of the new pixel color
#  @param b the blue component of the new pixel color
#  @return (None)
def putPixel(img, x, y, r, g, b):
  img.put("#%02x%02x%02x" % (r, g, b), to=(x,y))

## Draw the provided image with its upper left corner at position (x, y)
#  @param img the image to display
#  @param x the x position of the upper left corner
#  @param y the y position of the upper left corner
#  @return (None)
def drawImage(img, x, y):
  global __image_references

  __canvas.create_image(x+1, y+1, image=img, anchor="nw")
  __image_references.add(img)
  __update()

## Save the contents of an image to a PPM file
#  @param img the image object to save
#  @param fname the name of the file that will be created
def savePPM(img, fname):
  img.write(fname, format="ppm")

## Save the contents of an image to a GIF file
#  @param img the image object to save
#  @param fname the name of the file that will be created
def saveGIF(img, fname):
  img.write(fname, format="gif")


## Retrieve a list of all of the fonts that are available on the system
#  @return a list of strings containing the names of the available fonts
def fontList():
  return list(font.families())

# Call the __init function.
__init()

## Retrieve the red, green and blue components of a pixel in an image
#  @param img the image to retrieve the pixel from
#  @param x the x position of the pixel that will be retrieved
#  @param y the y position of the pixel that will be retrieved
#  @return a tuple containing the red, green and blue values
#
# It appears that Python 3.4.x on Windows has modified the get method for
# PhotoImage so that it now returns a tuple instead of a string.  This causes
# the previous implementation of getPixel to fail becaues there is no split
# method on tuples.  To detect this, we first create an image, then attempt
# to invoke split() on the result returned by get.  If that succeeds, we use
# the previous implementation of getPixel.  Otherwise, we just return the
# result returned by the get() method directly.
try:
  __emptyPhoto = tk.PhotoImage(width=1, height=1)
  __emptyPhoto.get(0,0).split()

  def getPixel(img, x, y):
    parts = img.get(x, y).split()
    return (int(parts[0]), int(parts[1]), int(parts[2]))

except AttributeError:
  def getPixel(img, x, y):
    return img.get(x, y)
