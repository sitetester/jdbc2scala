package jdbc2scala.generic.schema

// TODO: Write a shell script for schema generation (similar to Symfony entity generator)
case class DbTable(name: String, columns: List[DbColumn])
