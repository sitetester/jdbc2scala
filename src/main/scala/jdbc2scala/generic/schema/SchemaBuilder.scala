package jdbc2scala.generic.schema

trait SchemaBuilder {

  def getCreateTableSql(dbTable: DbTable): String

  def getDropTableSql(dbTable: DbTable): String
}
