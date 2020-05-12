package config

import jdbc2scala.config.{AppConfig, ConfigManager}
import org.scalatest.flatspec.AnyFlatSpec

class ConfigManagerSpec extends AnyFlatSpec {

  "it" should "load configuration" in {
    val config = ConfigManager.loadConfig()
    assert(config.isInstanceOf[AppConfig])
  }
}
