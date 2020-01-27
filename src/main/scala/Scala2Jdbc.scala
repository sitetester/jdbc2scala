import java.sql.{Connection, DriverManager, SQLException}

import schema.DbTable

object Scala2Jdbc {

  private var connection: Connection = _

  def createTable(table: DbTable): Unit = {
    val connection = getConnection

    var sql = "\nCREATE TABLE IF NOT EXISTS " + table.name + "(\n"
    sql += "\tID INTEGER PRIMARY KEY,\n"

    for ((column, index) <- table.columns.zipWithIndex) {
      val notNull = if (!column.isNull) "NOT NULL" else ""
      val lastComma = if (!(table.columns.size - index == 1)) {
        ","
      } else {
        ""
      }
      sql += "\t" + column.name + " " + column.dataType
        .toUpperCase() + " " + notNull + lastComma + "\n"
    }

    sql += ");"
    println(sql)

    val stmt = connection.createStatement()
    try {
      stmt.executeUpdate(sql)
      System.out.println("\nTable created successfully!")
    } catch {
      case sQLException: SQLException =>
        println(sQLException.getMessage)
    } finally {
      stmt.close()
    }
  }

  def getConnection: Connection = {
    try {
      Class.forName("org.sqlite.JDBC")
      val dbPath = "src/main/resources/test.db"
      connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath)
      System.out.println("Connection to SQLite has been established.")
      connection

    } catch {
      case e: SQLException =>
        System.out.println(e.getMessage)
        connection
    }
  }
}
