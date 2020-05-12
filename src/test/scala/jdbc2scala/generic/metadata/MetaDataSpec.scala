package jdbc2scala.generic.metadata

import jdbc2scala.generic.connection.ConnectionMaker
import org.scalatest.flatspec.AnyFlatSpec

class MetaDataSpec extends AnyFlatSpec {

  "it" should "optionally return getAllTables" in {
    val allTables = MetaData.getAllTables(ConnectionMaker.makeConnection)
    assert(allTables.isInstanceOf[Option[List[String]]])
  }

  "it" should "return getAllColumns" in {
    val columns = MetaData.getAllColumns(ConnectionMaker.makeConnection, "users")
    assert(columns.length == 3)
  }
}
