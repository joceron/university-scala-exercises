import scala.io.Source
import java.io.FileNotFoundException

object Tweet {
  /**
   * Read a file and put it into an Iterator[String]
   */
  def readFile(fileName: String): Iterator[String] = Source.fromFile(fileName).getLines()

  /**
   * Separate Twitter users from their messages
   */
  def breakTweets(fileIterator: Iterator[String]): List[(String, String)] = fileIterator.toList.map { line: String =>
    {
      val splitString = line.split(" -- ")
      (splitString(0), splitString(1))
    }
  }

  /**
   * Count the amount of times a word is repeated on a given List
   */
  def mostRepeated(inputList: List[String]): List[(String, Int)] = {
    val occurrences = inputList.map { x => (x, inputList.count(_ == x)) }.distinct
    occurrences.sortWith((user, nextUser) => user._2 > nextUser._2)
  }

  /**
   * Get the N most active users
   */
  def getActiveUsers(tweets: List[(String, String)], amount: Int): List[(String, Int)] = {
    val justUsers = tweets.map { case (arg1: String, arg2: String) => arg1 }
    val sortedOccurrences = mostRepeated(justUsers)
    sortedOccurrences.take(amount)
  }

  /**
   * Get the N most mentioned words
   */
  def getWords(tweets: List[(String, String)], amount: Int, noStop: Boolean): List[(String, Int)] = {
    val justMessages = tweets.map { case (arg1: String, arg2: String) => arg2.toLowerCase }

    // Put all the messages inside a List[String]
    val wordList: List[String] = {
      val words = justMessages.flatMap(sentence => sentence.split(" ")).filter(word => {
        if (word.length() > 0) // Discard all users
          word(0) != '@'
        else false
      })
      if (noStop) words.filter(word => word.length() > 3) // Check if we are looking for stop-words
      else words
    }

    val sortedOccurrences = mostRepeated(wordList)
    sortedOccurrences.take(amount)
  }

  /**
   * Get the N most mentioned links
   */
  def getLinks(tweets: List[(String, String)], amount: Int): List[(String, Int)] = {
    val justMessages = tweets.map { case (arg1: String, arg2: String) => arg2 }
    val wordList = justMessages.flatMap(sentence => sentence.split(" ")).filter(word => word.take(4) == "http")
    val sortedOccurrences = mostRepeated(wordList)
    sortedOccurrences.take(amount)
  }

  /**
   * Get the N most mentioned users
   */
  def getMentionedUsers(tweets: List[(String, String)], amount: Int): List[(String, Int)] = {
    val justMessages = tweets.map { case (arg1: String, arg2: String) => arg2 }

    // Put all the messages inside a List[String]
    val wordList = justMessages.flatMap(sentence => sentence.split(" ")).filter(word => {
      if (word.length() > 0) // Discard everything that's not an user
        word(0) == '@'
      else false
    })

    val sortedOccurrences = mostRepeated(wordList)
    sortedOccurrences.take(amount)
  }

  /**
   * Get a List of [Element, amount of times that Element appears across the tweets], and then align and format the numbers
   */
  def formatResults(results: List[(String, Int)]): String = {
    try {
      val sizeList = results.map { case (word: String, occurrences: Int) => word.length() + occurrences.toString.length() }
      val maxSize = sizeList.reduceLeft((size1: Int, size2: Int) => if (size1 > size2) size1 else size2)
      val arrayPos = results.map { case (word: String, occurrences: Int) => "* " + word + (" " * (maxSize - word.length() - occurrences.toString().length() + 1)) + occurrences.toString }
      arrayPos.mkString("\n")
    } catch {
      case e: Exception => ""
    }
  }

  /**
   * Main method
   */
  def printTweets(inputFile: String): String = {
    try {
      val file = readFile(inputFile)
      val tweets = breakTweets(file)

      val head = "Tweets Report\n-------------\n\n"
      val activeUsers = "Most active users:\n" + formatResults(getActiveUsers(tweets, 5)) + "\n\n"
      val mentionedWords = "Most used words:\n" + formatResults(getWords(tweets, 5, false)) + "\n\n"
      val mentionedNoStopWords = "Most used words, excluding stop-words:\n" + formatResults(getWords(tweets, 5, true)) + "\n\n"
      val mentionedLinks = "Most mentioned links:\n" + formatResults(getLinks(tweets, 3)) + "\n\n"
      val mentionedUsers = "Most mentioned users:\n" + formatResults(getMentionedUsers(tweets, 8))
      head + activeUsers + mentionedWords + mentionedNoStopWords + mentionedLinks + mentionedUsers
    } catch {
      case fnfe: FileNotFoundException => "The specified file doesn't exist"
    }
  }

  def main(args: Array[String]) = {
    println(printTweets("tweets.txt"))
  }
}

//Code from Thomas
    //    val mostUsedWords = getActiveUsers(tweets, 5)
    //
    //    val excludingStopWords = getActiveUsers(tweets, 5)
    //
    //    val returnMap: Map[String, List[(String, Int)]] = Map(
    //      "tweets" -> activeUsers,
    //      "mostUsedWords" -> mostUsedWords,
    //      "excludingStopWords" -> excludingStopWords)
    //
    //    returnMap.foreach {
    //      case (name, list) =>
    //        println(name)
    //        list.foreach {
    //          case (key, value) =>
    //            println(s"$value \t $value")
    //        }
    //    }