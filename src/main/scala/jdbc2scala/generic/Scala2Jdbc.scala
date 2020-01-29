package jdbc2scala.generic

import java.sql.SQLException

import jdbc2scala.generic.connection.ConnectionMaker
import jdbc2scala.generic.schema.DbTable

object Scala2Jdbc {

  def persistDbTable(dbTable: DbTable, user: User): Unit = {
    println("Going to persist DbTable obj...\n")

    val columns = user.productElementNames.toList
    val values = user.productIterator.toList

    var insertStr = "INSERT INTO " + dbTable.name + " ("
    insertStr += columns.mkString(", ") + ") VALUES (\n"
    insertStr += values.map(v => "\"" + v + "\"").mkString(", ")
    insertStr += "\n);"

    println(insertStr)

    val stmt = ConnectionMaker.makeConnection.createStatement()
    try {
      stmt.executeUpdate(insertStr)
      System.out.println("\nTable created successfully!")
    } catch {
      case sQLException: SQLException =>
        println(sQLException.getMessage)
    } finally {
      stmt.close()
    }
  }
}

case class User(username: String, password: String) {
  override def toString: String = User.unapply(this).get.toString

  User.unapply(this).get.productIterator.mkString("\t")
}
