import org.scalatest.FunSuite
import org.joda.time._

class Test extends FunSuite {
  test("Fail test") {
  	try {
  		val dateTime = new DateTime()
  	} catch {
  		case e: Exception => assert(false)
  	}
    assert(true)
  }
}