import jdbc2scala.generic.schema.{DbColumn, DbTable}
import jdbc2scala.generic.{Scala2Jdbc, User}

object Scala2JdbcTest extends App {

  val dbColumns = List(DbColumn("username"), DbColumn("password"))

  // println(MetaData.getAllTables(connection))
  // MetaData.getAllColumns(connection, "currencies").foreach(println(_))

  val dbTable = DbTable("users", dbColumns)
  val user = User("admin", "demo")

  Scala2Jdbc.persistDbTable(dbTable, user)
}
