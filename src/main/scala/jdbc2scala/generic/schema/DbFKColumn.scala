package jdbc2scala.generic.schema

/**
  * @param name
  * @param references - e.g. artist(artistId)
  */
case class DbFKColumn(name: String, referenceTable: String, referenceTableColumn: String) {}
