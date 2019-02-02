package pageobjects;

import cucumber.api.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitsManager;

import java.util.List;

public class AssignLeavePage {
  private WebDriver driver;

  private WaitsManager wait;

  @FindBy(id = "assignleave_txtEmployee_empName")
  private WebElement employeeNameInput;

  @FindBy(id = "assignleave_txtLeaveType")
  private WebElement leaveTypeSelect;

  @FindBy(id = "assignleave_txtFromDate")
  private WebElement fromDateInput;

  @FindBy(id = "assignleave_txtToDate")
  private WebElement toDateInput;

  @FindBy(className = "ui-state-default")
  private List<WebElement> daysLink;

  @FindBy(className = "ui-datepicker-month")
  private WebElement pickMonthSelect;

  @FindBy(id = "assignleave_firstDuration_duration")
  private WebElement pickTimeSelect;

  @FindBy(id = "assignleave_partialDays")
  private WebElement partialDaysSelect;

  @FindBy(id = "assignleave_firstDuration_time_from")
  private WebElement fromDurationSelect;

  @FindBy(id = "assignleave_secondDuration_time_to")
  private WebElement toDurationSelect;

  @FindBy(id = "assignBtn")
  private WebElement assignBtn;

  @FindBy(id = "confirmOkButton")
  private WebElement confirmationBtn;

  public AssignLeavePage(WebDriver driver) {
    this.driver = driver;
    wait = new WaitsManager(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public void fillEmployeeName() {
    employeeNameInput.sendKeys("Linda Anderson");
  }

  public void fillLeaveType() {
    Select leaveTypeSel = new Select(leaveTypeSelect);
    leaveTypeSel.selectByVisibleText("Maternity US");
  }

  public void fillFromDate() {
    fromDateInput.click();
    Select pickMonth = new Select(pickMonthSelect);
    pickMonth.selectByVisibleText("Apr");
    for(WebElement day : daysLink) {
      if (day.getText().equals("4"))
        day.click();
    }
  }

  public void fillToDate() {
    toDateInput.click();
    Select pickMonth = new Select(pickMonthSelect);
    pickMonth.selectByVisibleText("Apr");
    for (WebElement day: daysLink) {
      if (day.getText().equals("8"))
        day.click();
    }
  }

  public void fillPickTime() {
    Select partialDays = new Select(partialDaysSelect);
    partialDays.selectByVisibleText("All Days");
    Select pickTime = new Select(pickTimeSelect);
    wait.until_VisibilityOfElement(pickTimeSelect);
    pickTime.selectByVisibleText("Specify Time");
  }

  public void fillFromDuration() {
    wait.until_ElementToBeClickable(fromDurationSelect).click();
    Select fromDuration = new Select(fromDurationSelect);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView", driver.findElement(By.xpath("//select[@id = 'assignleave_secondDuration_time_from']/option[@value='13:00']")));
    fromDuration.selectByVisibleText("13:00");
  }

  public void submitLeaveAssignmentForm() {
    assignBtn.click();
  }

  public void confirmLeaveAssignment() {
    confirmationBtn.click();
  }
}
