import java.sql.Connection

import schema.{DbColumn, DbTable}

object Scala2JdbcTest extends App {

  val dbColumns = List(DbColumn("username"), DbColumn("password"))
  // println(MetaData.getAllTables(connection))
  // MetaData.getAllColumns(connection, "currencies").foreach(println(_))
  val dbTable = DbTable("users", dbColumns)
  var connection: Connection = Scala2Jdbc.getConnection

  Scala2Jdbc.createTable(dbTable)

}
