package jdbc2scala.generic.schema

import org.scalatest.flatspec.AnyFlatSpec

class SchemaBuilderSpec extends AnyFlatSpec {

  "it" should "create table" in {

    val users: DbTable =
      DbTable(
        "users",
        List(DbColumn("username", isUnique = true), DbColumn("password")),
        DbIDColumn(),
        List(DbIndex("idx_username", List("username")))
      )

    SchemaManager.createTable(users)

    val category: DbTable =
      DbTable(
        "categories",
        List(DbColumn("name", isUnique = true)),
        DbIDColumn()
      )

    SchemaManager.createTable(category)

    val product: DbTable =
      DbTable(
        "products",
        List(DbColumn("name")),
        DbIDColumn("productId"),
        Seq(),
        Some(DbFKColumn("categoryId", "categories", "ID"))
      )

    SchemaManager.createTable(product)
  }
}
