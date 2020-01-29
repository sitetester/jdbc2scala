package jdbc2scala.generic.schema

import org.scalatest.flatspec.AnyFlatSpec

class SchemaBuilderSpec extends AnyFlatSpec {

  "it" should "create table in sqlite" in {

    val dbColumns = List(DbColumn("username"), DbColumn("password"))
    val dbTable = DbTable("users", dbColumns)

    SchemaManager.createTable(dbTable)
  }
}
