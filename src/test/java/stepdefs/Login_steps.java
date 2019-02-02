package stepdefs;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.DriverManager;


public class Login_steps {

  private TestContext testContext;
  private DriverManager driverManager;
  private HomePage homePage;
  private LoginPage loginPage;

  public Login_steps(TestContext testContext) {
    this.testContext = testContext;
    driverManager = testContext.getWebDriverManager();
    homePage = testContext.getPageObjectManager().getHomePage();
    loginPage = testContext.getPageObjectManager().getLoginPage();
  }

  /*  LOGIN WITH VALID CREDENTIALS */

  @Given("user is on the login page")
  public void user_is_on_the_login_page() {
    loginPage.navigateTo_LoginPage();
  }

  @When("user enters valid username {string}")
  public void user_enters_valid_username(String username) {
    loginPage.fillUsername(username);
  }

  @When("user enter valid password {string}")
  public void user_enter_valid_password(String password) {
    loginPage.fillPassword(password);
  }

  @When("user clicks login button")
  public void user_clicks_login_button() {
    loginPage.clickLoginBtn();
  }

  @Then("user should be redirected to home page")
  public void user_should_be_redirected_to_home_page() {
    assertEquals(homePage.getWelcomeLinkText(), "Welcome Admin");
  }

  /*  LOGIN WITH INVALID CREDENTIALS */

  @When("user enters invalid username {string}")
  public void user_enters_invalid_username(String username) {
    loginPage.fillUsername(username);
  }

  @When("user enters invalid password {string}")
  public void user_enters_invalid_password(String password) {
    loginPage.fillPassword(password);
  }

  @Then("user should see warning message {string}")
  public void user_should_see_warning_with_message(String warning) {
    assertEquals(loginPage.getWarningMessageText(), warning);
  }

}
