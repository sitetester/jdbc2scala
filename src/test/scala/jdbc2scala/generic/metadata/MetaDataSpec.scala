package jdbc2scala.generic.metadata

import jdbc2scala.generic.connection.ConnectionMaker
import org.scalatest.flatspec.AnyFlatSpec

class MetaDataSpec extends AnyFlatSpec {

  "it" should "return getAllTables" in {

    MetaData.getAllTables(ConnectionMaker.makeConnection)
  }
}
