import org.scalatest.FunSuite

class Test extends FunSuite {
  test("Standard execution") {
    val output = Tweet.printTweets("tweets.txt")
    val standardOutput = "Tweets Report\n-------------\n\nMost active users:\n* @monad_xiv      32\n* @lollypng        4\n* @BraydenFlannaga 2\n* @SRFlux          2\n* @Logan_Aura      2\n\nMost used words:\n* the   52\n* monad 45\n* a     40\n* i     26\n* of    25\n\nMost used words, excluding stop-words:\n* monad    45\n* just     13\n* monoid   13\n* through  13\n* category 12\n\nMost mentioned links:\n* http://t.co/jCELBwsQoN 2\n* http://t.co/2brlefIewc 1\n* http://t.co/7JD3C8Ti6f 1\n\nMost mentioned users:\n* @monad_xiv      19\n* @scalaworldconf  4\n* @jdegoes         3\n* @quephird        2\n* @willjohansson   2\n* @kamenridergaiim 2\n* @debasishg:      2\n* @ptomasroos      1"
    assert(output == standardOutput)
  }

  test("Non existing file") {
    val output = Tweet.printTweets("asdf")
    assert(output == "The specified file doesn't exist")
  }

  test("Empty file") {
    val output = Tweet.printTweets("testFiles/emptyTest.txt")
    val standardOutput = "Tweets Report\n-------------\n\nMost active users:\n\n\nMost used words:\n\n\nMost used words, excluding stop-words:\n\n\nMost mentioned links:\n\n\nMost mentioned users:\n"
    assert(output == standardOutput)
  }

  test("Partially empty file") {
    val output = Tweet.printTweets("testFiles/test.txt")
    val standardOutput = "Tweets Report\n-------------\n\nMost active users:\n* @WilfridFoley 1\n\nMost used words:\n* monad           1\n* conditioners:   1\n* recommendations 1\n* against         1\n* control:        1\n\nMost used words, excluding stop-words:\n* monad           1\n* conditioners:   1\n* recommendations 1\n* against         1\n* control:        1\n\nMost mentioned links:\n* http://t.co/2brlefIewc 1\n\nMost mentioned users:\n"
    assert(output == standardOutput)
  }

}