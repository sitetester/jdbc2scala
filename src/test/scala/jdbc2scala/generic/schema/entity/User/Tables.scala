package jdbc2scala.generic.schema.entity.User

import jdbc2scala.generic.schema.{DbColumn, DbTable}

// TODO: Somehow generated entities (thru shell script) should be stored somewhere
object Tables {

  val users: DbTable = DbTable("users", List(DbColumn("username"), DbColumn("password")))

}
