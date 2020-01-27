import java.sql.Connection

import schema.{DbColumn, DbTable}

case class User(username: String, password: String) {
  override def toString: String = User.unapply(this).get.toString

  User.unapply(this).get.productIterator.mkString("\t")
}

object Scala2JdbcTest extends App {

  val dbColumns = List(DbColumn("username"), DbColumn("password"))

  // println(MetaData.getAllTables(connection))
  // MetaData.getAllColumns(connection, "currencies").foreach(println(_))

  val dbTable = DbTable("users", dbColumns)
  Scala2Jdbc.createTable(dbTable)
  val user = User("admin", "demo")
  var connection: Connection = Scala2Jdbc.getConnection

  Scala2Jdbc.persistDbTable(dbTable, user)
}
