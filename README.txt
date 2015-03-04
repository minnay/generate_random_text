What's included?
=================
The included is a solution to generate random strings for a given words pair based on a text source file.

The random text generator will, when given a starting word pair, generate a sentence that is composed of all pairs of consecutive words in the text with
all the words that can follow them. The generated sentences will not exceed 50 words.

How to build it?
================
Run the following command in Linux environment:
./build.sh

It will package the solution into a jar (app.jar) and run through all of the unit tests.

How to run it?
===============
Run the following command:
java -jar app.jar TEXT_SOURCE_FILE "STARTING_WORDS_PAIR"

for example,
java -jar app.jar sample.txt "for the"