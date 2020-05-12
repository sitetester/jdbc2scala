package jdbc2scala.generic.connection

import java.sql.{Connection, DriverManager, SQLException}

import jdbc2scala.config.ConfigManager

object ConnectionMaker {

  private var connection: Connection = _

  def makeConnection: Connection = {
    val driver = ConfigManager.loadConfig().dbDriver

    try {

      Class.forName(driver.classForName)
      connection = DriverManager.getConnection(driver.url)

      System.out.println(
        s"Connection to `${driver.classForName.split("\\.").slice(1, 2).head}` has been established.")
      connection

    } catch {
      case e: SQLException =>
        System.out.println(e.getMessage)
        connection
    }
  }
}
