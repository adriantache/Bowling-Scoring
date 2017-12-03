# Bowling-Scoring
*Bowling scoring app for the Google Android Basics Nanodegree*

The assignment for Project 2 of the Google Android Basics Nanodegree by Udacity was to create a scorekeeping app for a sport of 
our choice, with a number of requirements such as including two players, and tracking multiple scores. Since I wanted a challenge, 
I decided to focus on a sport that's more difficult to keep score for. Initially, I settled on Snooker, due to its somewhat 
complex scoring system, but eventually gave up on that due to my lack of passion for the sport and seemingly difficult structure 
of the game since I wanted to include the automatic player switch logic.

As such, I picked a sport I actually like, which has complicated scoring that I hadn't previously fully understood, and set out to 
create an app to track its score. The sport is, obviously, bowling, and I started with a rough paper sketch and some features I 
wanted to include, as well as some code scribbled on paper as well regarding the functionality of scoring a game that calculates 
score based on future moves, without simply hardcoding all the possibilities. I did this using an array, and recursively stepping back through it, remembering the appropriate scores and adding them in case a strike or spare is detected. 

From there, I moved on to mocking up the app, then printing it out and figuring how to lay everything out in XML. I used LinearLayouts
nesting other LinearLayouts and RelativeLayouts, and tried making everything work using weights but eventually gave up and just hard 
coded some values. Certain parts work as intended, and scale down on tiny screens (top logo disappears entirely), but others do not, 
and it's beyond the scope of this project to improve this, since I am not allowed to use a ConstraintLayout.  

**Please try out the app and report any bugs.**

_It's been tough, making this rather simple app, with a lot of bugs to fix and logical structures to figure out, but I've learned a lot and I'd like to especially thank @Thor from the Udacity slack for helping with the Drawables vector and java code._

**Features I'd like to implement:**
- (optional) create a landscape layout
- (optional) improve UI for selection of # of pins
- (optional) add UNDO button
- (optional) highlight current frame
- (optional) maybe add more fun to it, such as multiple messages for winners, sound or vibration, etc.


**Known issues:**
- layout is a bit of a mess
- bottom buttons are too low on tiny screens
- app cannot make you better at bowling :)

You can see the design mockup below:

![design mockup](https://github.com/adriantache/Bowling-Scoring/blob/master/app/src/main/res/drawable-xxhdpi/mockupsmall.png)
