package jdbc2scala.generic.schema

/**
  *
  * @param name     - comma separate name, should be prefixed with "idx"
  * @param columns  - could be single or multiple columns
  * @param isUnique - true|false
  */
case class DbIndex(name: String, columns: Seq[String] = Seq(), isUnique: Boolean = false)
