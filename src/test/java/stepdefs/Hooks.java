package stepdefs;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import utils.DriverManager;

public class Hooks {

  private TestContext testContext;
  private DriverManager driverManager;

  public Hooks(TestContext testContext) {
    this.testContext = testContext;
    driverManager = testContext.getWebDriverManager();
  }

  @After
  public void tearDown(Scenario scenario) {
    driverManager.closeDriver();
  }
}
