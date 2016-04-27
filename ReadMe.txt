Program Introduction:

The program is implemented in Java.

The program implements approximately match films to reviews using three different methods: Global Edit Distance, Ngram and Soundex.

class GED, Ngram, Soundex are the general implementation of the three methods, could be applied to any two strings.

class CalDistance apply these three methods separately into the film review matching case, mainly deal with the mutiple words problem

class MatchFilm find the matched film for one particular review. The program provide two choices, it can find the most matched film with smallest distance
or can find some films that satisfy a particular threshold

class Driver is the main entry of the program, it read films and reviews from txt files and do the match job. You can modify the code between line 58-70 
to choose different approximate match methods or the choice of result.

How to Run the Program (in cmd):

1. Enter directory MatchFilms\src
2. run javac Driver.java to compile it
3. run java Driver
The result will be printed directly in the console

Notes:
The location of the txt files that the program needed: film_titles.txt and revs folder is hard coded in Driver class,
line 21 and line 32. They are both in F:\filmData directory in my computer. You may need to change the location if it's different.