package jdbc2scala.generic.schema

// e.g. CREATE INDEX "averageRating_idx" on "title_ratings" ("averageRating")
case class DbColumn(name: String,
                    isNull: Boolean = false,
                    isUnique: Boolean = false,
                    dataType: String = "VARCHAR(255)",
                    default: String = "")
