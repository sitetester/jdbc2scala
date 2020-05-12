package jdbc2scala.generic.schema

trait SchemaBuilder {

  def getCreateTableSql(dbTable: DbTable): String
}
