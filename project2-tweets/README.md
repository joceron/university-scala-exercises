Project 2: Tweets
===

This directory contains a file `tweets.txt`, which contains a list of tweets. Each line is a tweet and it starts with the username, then two hyphens, and then the text of the tweet.

Write a program that analyzes the file and prints the following:

 * The top-5 most active users, the ones that posted the most tweets.
 * The top-5 mentioned words
 * The top-5 mentioned words, excluding stop-words
 * The top-3 mentioned links
 * The top-8 mentioned users

 and all of these including the number of tweets/occurrances, etc. Make sure
 the numbers are nicely aligned.

 So the output could look like this (except with the real data):

     Tweets Report
     -------------

     Most active users:
     * @user_1          12
     * @user_number2     9
     * @another          5
     * @yetanotheruser   5
     * @lastone          2

     Most used words:
     * a                22
     * scala            18
     * in               17
     * I                13
     * computer         11

     Most used words, excluding stop-words:
     * scala            18
     * computer         11
     * programming       7
     * compiler          4
     * source            4

     Most mentioned links:
     * http://t.co/asdfasdfasdf  5
     * http://t.co/asdfasdvxvcx  2
     * http://t.co/ertertrtree   1

     Most mentioned users:
     * @another         4
     * @alastone        3
     * @ffoo_bar        2
     * @quuxquux        2
     * @helloworld      1
     * @i_am_here       1
     * @derskyo         1
     * @blabla          1
