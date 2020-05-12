package jdbc2scala.generic.query

import jdbc2scala.generic.schema.{DbColumn, DbTable}
import org.scalatest.flatspec.AnyFlatSpec

class QueryBuilderSpec extends AnyFlatSpec {

  val dbColumns = List(DbColumn("username"), DbColumn("password"))
  val dbTable: DbTable = DbTable("users", dbColumns)

  // TODO: Write similar test cases for other methods also
  "it" should "return DISTINCT query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.distinct(Seq("username", "password")).getSql
    assert(sql equals "SELECT DISTINCT `username`, `password` FROM `users`")
  }
}
