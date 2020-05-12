package jdbc2scala.generic.schema

case class DbColumn(name: String,
                    isPrimary: Boolean = false,
                    isNull: Boolean = false,
                    isUnique: Boolean = false,
                    dataType: String = "VARCHAR(255)",
)
