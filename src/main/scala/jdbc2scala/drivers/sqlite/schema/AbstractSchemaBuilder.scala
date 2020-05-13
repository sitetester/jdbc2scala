package jdbc2scala.drivers.sqlite.schema

import jdbc2scala.generic.schema.{DbTable, SchemaBuilder}

class AbstractSchemaBuilder extends SchemaBuilder {

  override def getCreateTableSql(dbTable: DbTable): String = {

    var sql = "\nCREATE TABLE IF NOT EXISTS `" + dbTable.name + "`(\n"
    println(dbTable.columns)

    /*for ((column, index) <- dbTable.columns.zipWithIndex) {
      val notNull = if (!column.isNull) "NOT NULL" else ""
      val lastComma = if (!(dbTable.columns.size - index == 1)) {
        ","
      } else {
        ""
      }
      sql += "\t" + column.name + " " + column.dataType
        .toUpperCase() + " " + notNull + lastComma + "\n"
    }

    sql += ");"
    sql*/

    ""
  }

  override def getDropTableSql(dbTable: DbTable): String = {
    "DROP TABLE `" + dbTable.name + "`"
  }
}
