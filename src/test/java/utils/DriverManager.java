package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
  private WebDriver driver;

  public WebDriver getDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
    return driver;
  }

  public void closeDriver() {
    if (driver != null) {
      driver.quit();
    }
  }
}
