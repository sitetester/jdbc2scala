package jdbc2scala.generic.schema

// TODO: Write a shell script for schema generation (similar to Symfony entity generator)
// https://www.sqlitetutorial.net
case class DbTable(name: String,
                   columns: List[DbColumn],
                   dbIDColumn: DbIDColumn = DbIDColumn(),
                   indexes: Seq[DbIndex] = Seq())
