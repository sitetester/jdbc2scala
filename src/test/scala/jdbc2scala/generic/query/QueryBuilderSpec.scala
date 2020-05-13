package jdbc2scala.generic.query

import jdbc2scala.generic.schema.{DbColumn, DbTable}
import org.scalatest.flatspec.AnyFlatSpec

class QueryBuilderSpec extends AnyFlatSpec {

  val dbColumns = List(DbColumn("username"), DbColumn("password"))
  val dbTable: DbTable = DbTable("users", dbColumns)

  "it" should "return * query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().getSql
    assert(sql == "SELECT * FROM `users`")
  }

  "it" should "return DISTINCT query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.distinct(Seq("username", "password")).getSql
    assert(sql equals "SELECT DISTINCT `username`, `password` FROM `users`")
  }

  "it" should "return specific columns query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select("username, password").getSql
    assert(sql == "SELECT username, password FROM `users`")
  }

  "it" should "return where query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().where(Seq(Map("username" -> ("=", "admin")))).getSql
    assert(sql == "SELECT * FROM `users` WHERE `username` = \"admin\" ")
  }

  "it" should "return whereIn query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().whereIn("ID", List(1, 2, 3)).getSql
    assert(sql == "SELECT * FROM `users` WHERE `ID` IN (1,2,3) ")
  }

  "it" should "return whereBetween query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().whereBetween("ID", (1, 20)).getSql
    assert(sql == "SELECT * FROM `users` WHERE `ID` BETWEEN 1 AND 20")
  }

  "it" should "return limit query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().limit().getSql
    assert(sql == "SELECT * FROM `users` LIMIT 10")
  }

  "it" should "return offset query" in {
    val qb = new QueryBuilder(dbTable)

    val sql1 = qb.select().offset().getSql
    assert(sql1 == "SELECT * FROM `users` OFFSET 10")

    val sql2 = qb.select().limit().offset(0).getSql
    assert(sql2 == "SELECT * FROM `users` LIMIT 10 OFFSET 0")
  }

  "it" should "return groupBy query" in {
    val qb = new QueryBuilder(dbTable)

    val sql = qb.select().groupBy("username").getSql
    assert(sql == "SELECT * FROM `users` GROUP BY `username`")
  }

}
