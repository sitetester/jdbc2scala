package jdbc2scala.generic.schema

/**
  * Auto incrementing column with PRIMARY KEY support
  *
  * @param name - ID column name
  */
case class DbIDColumn(name: String = "ID")
