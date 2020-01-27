package schema

case class DbColumn(
    name: String,
    isPrimary: Boolean = false,
    isNull: Boolean = false,
    dataType: String = "VARCHAR(255)",
)
