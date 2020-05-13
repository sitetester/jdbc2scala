import jdbc2scala.generic.schema.{DbColumn, DbTable}

object Scala2JdbcTest {

  val dbColumns = List(DbColumn("ID"), DbColumn("username"), DbColumn("password"))
  val usersTable: DbTable = DbTable("users", dbColumns)
  /*val qb = new QueryBuilder(dbTable)
  val row = qb
    .select("ID, MAX(ID)")
    // .orderByMulti(Seq("ID" -> qb.DESC, "password" -> qb.ASC))
    .groupBy("ID")
    .having("MAX(ID)", "=", 2)
    .runQuery()*/

  // TODO: Write a separate test case for QueryBuilder
  // val qb = new QueryBuilder(dbTable)

  /*
  val row = qb
    .distinct(Seq("ID"))*/
  //.whereIn("ID", Array(1, 0))
  // .where(Map("ID" -> 1))
  //.whereBetween("ID", (0, 1))
  //.runQuery()
  // println(row)

  // qb.insertRow(Seq("username" -> "testu", "password" -> "testp"))

  /*qb.updateRow(
    Seq("username" -> "testu777", "password" -> "testp777"),
    Seq("ID" -> 7)*/

  // qb.deleteWhere(Seq(Map("ID" -> ("=", 8)), Map("username" -> ("=", "testu"))))
  // qb.deleteWhere(Seq(Map("ID" -> (">", 8))))

}
