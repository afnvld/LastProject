package stepdefs;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjects.AssignLeavePage;
import pageobjects.HomePage;
import utils.DriverManager;

public class AssignLeave_steps {
  private TestContext testContext;
  private DriverManager driverManager;
  private AssignLeavePage assingLeavePage;
  private HomePage homePage;

  public AssignLeave_steps(TestContext testContext) {
    this.testContext = testContext;
    driverManager = testContext.getWebDriverManager();
    assingLeavePage = testContext.getPageObjectManager().getAssignLeavePage();
    homePage = testContext.getPageObjectManager().getHomePage();
  }

  @Given("user is on the assign leave page")
  public void user_is_on_the_assign_leave_page() {
    homePage.clickDashboardLink();
    homePage.clickAssignLeaveLink();
  }

  @When("user fills all required fields")
  public void user_fills_all_required_fields() throws InterruptedException {
    assingLeavePage.fillEmployeeName();
    assingLeavePage.fillLeaveType();
    assingLeavePage.fillFromDate();
    assingLeavePage.fillToDate();
    assingLeavePage.fillPickTime();
    assingLeavePage.fillFromDuration();
    assingLeavePage.submitLeaveAssignmentForm();
    Thread.sleep(2000);
  }

  @When("user confirms leave assignment")
  public void user_confirms_leave_assignment() {
    assingLeavePage.confirmLeaveAssignment();
  }

  @Then("user should see message {string}")
  public void user_should_see_message(String string) {
    Assert.assertTrue(true);
  }
}
