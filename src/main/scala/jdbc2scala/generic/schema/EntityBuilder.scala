package jdbc2scala.generic.schema

// import jdbc2scala.generic.schema.EntityBuilder.prompt

// COULD BE possibly used as shell script (just like https://symfony.com/doc/current/doctrine.html#creating-an-entity-class)

// Standalone usage
// https://alvinalexander.com/scala/sbt-how-to-compile-run-package-scala-project/

/*
object EntityBuilder {

  def main(args: Array[String]): Unit = {
    println(Console.GREEN + "Welcome to Entity generator!\n")

    /*val entityName = getEntityName
    val fieldName = getField
    val fieldType = getFieldType
    val fieldLength = getFieldLength

    println(entityName, fieldName, fieldType, fieldLength)*/

    val entityName = getEntityName
    if (entityName == "q") {
      return
    }

    // println(entityName)
    val fields = getFields
    fields.foreach(println(_))
  }

  def getEntityName: String = {
    var answer = ""
    do {
      print(Console.BLACK + "Entity name (Min length - 3): ")
      answer = scala.io.StdIn.readLine()
    } while (answer.trim.length < 3)
    answer
  }

  def getFields: ListBuffer[String] = {
    var fields: ListBuffer[String] = ListBuffer("")
    var answer = ""
    do {
      println("\nEnter fields(Enter `done` when finished)")
      answer = prompt("Field name (Min length - 3): ")
      val fieldName = answer
      if (answer.trim.length >= 3 && answer != "done") {
        answer = prompt("Field type: ")
        val fieldType = answer

        fields += fieldName + fieldType
      }
    } while (answer != "done")

    fields
  }

  def prompt(prompt: String): String = {
    var answer = ""
    do {
      print(prompt)
      answer = scala.io.StdIn.readLine()
    } while (answer.trim == "")
    answer
  }

  def getFieldType: String = {
    var fieldType = ""
    while (fieldType.trim == "") {
      print("Field type: ")
      fieldType = scala.io.StdIn.readLine()
    }
    fieldType
  }

  def getFieldLength: String = {
    var fieldLength = ""
    while (fieldLength.trim == "") {
      print("Field Length: ")
      fieldLength = scala.io.StdIn.readLine()
    }
    fieldLength
  }
}
 */
