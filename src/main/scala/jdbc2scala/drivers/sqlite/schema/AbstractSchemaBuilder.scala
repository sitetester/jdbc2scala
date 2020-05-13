package jdbc2scala.drivers.sqlite.schema

import jdbc2scala.generic.schema.{DbColumn, DbIDColumn, DbTable, SchemaBuilder}

class AbstractSchemaBuilder extends SchemaBuilder {

  override def getCreateTableSql(dbTable: DbTable): String = {

    var sql = "\nCREATE TABLE IF NOT EXISTS `" + dbTable.name + "` (\n"

    val dbIDColumn = dbTable.dbIDColumn
    val name = getIDColumnName(dbIDColumn)
    sql += s"`$name` INTEGER PRIMARY KEY, \n"

    var counter = 0
    val columnsLength = dbTable.columns.length
    dbTable.columns.foreach(column => {
      counter += 1

      sql += "`" + getName(column) + "`"
      sql += getOptions(column)

      if (counter < columnsLength) {
        sql += ",\n"
      } else {
        sql += "\n)"
      }
    })

    sql
  }

  private def getOptions(column: DbColumn): String = {

    var options = ""
    val cols = column.productElementNames
    val vals = column.productIterator.toList
    val zipped = cols.zip(vals)

    val otherOptions = zipped.filterNot(_._1 == "name").toList

    options += " " + getOption("dataType", otherOptions)

    val isNull = getOption("isNull", otherOptions)
    if (!isNull.asInstanceOf[Boolean]) {
      options += " NOT NULL"
    }

    val isUnique = getOption("isUnique", otherOptions)
    if (isUnique.asInstanceOf[Boolean]) {
      options += " UNIQUE"
    }

    options += " " + getOption("default", otherOptions)

    options
  }

  private def getOption(option: String, otherOptions: List[(String, Any)]): Any = {
    otherOptions.filter(_._1 == option).head._2
  }

  private def getIDColumnName(column: DbIDColumn): String = {
    val cols = column.productElementNames
    val vals = column.productIterator.toList
    val zipped = cols.zip(vals)

    zipped.filter(_._1 == "name").toList.head._2.toString
  }

  private def getName(column: DbColumn): String = {
    val cols = column.productElementNames
    val vals = column.productIterator.toList
    val zipped = cols.zip(vals)

    zipped.filter(_._1 == "name").toList.head._2.toString
  }

  override def getDropTableSql(dbTable: DbTable): String = {
    "DROP TABLE `" + dbTable.name + "`"
  }
}
