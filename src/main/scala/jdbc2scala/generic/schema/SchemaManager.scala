package jdbc2scala.generic.schema

import java.sql.{Connection, SQLException}

import jdbc2scala.config.ConfigManager
import jdbc2scala.drivers.sqlite.schema.SqliteSchemaBuilder
import jdbc2scala.generic.connection.ConnectionMaker

object SchemaManager {

  val connection: Connection = ConnectionMaker.makeConnection

  def createTable(dbTable: DbTable): Unit = {

    val schemaBuilder = getSchemaBuilder
    val sql = schemaBuilder.getCreateTableSql(dbTable)

    runSql(sql)
  }

  def dropTable(dbTable: DbTable): Unit = {

    val schemaBuilder = getSchemaBuilder
    val sql = schemaBuilder.getDropTableSql(dbTable)

    runSql(sql)
  }

  private def runSql(sql: String): Unit = {
    println(sql)
    val stmt = connection.createStatement()
    try {
      stmt.executeUpdate(sql)
      System.out.println("\nTable created successfully!")
    } catch {
      case sQLException: SQLException => println(sQLException.getMessage)
    } finally {
      stmt.close()
    }
  }

  private def getSchemaBuilder: SchemaBuilder = {
    val schemaBuilder = ConfigManager.loadConfig().dbDriver.driver match {
      case "sqlite" => SqliteSchemaBuilder
    }

    schemaBuilder
  }
}
