package jdbc2scala.generic.schema

import org.scalatest.flatspec.AnyFlatSpec

class SchemaBuilderSpec extends AnyFlatSpec {

  "it" should "create table" in {

    val users: DbTable = DbTable("users", List(DbColumn("username"), DbColumn("password")))

    SchemaManager.dropTable(users)
    SchemaManager.createTable(users)
  }
}
