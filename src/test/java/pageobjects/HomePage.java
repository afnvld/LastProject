package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class HomePage {

  private WebDriver driver;

  @FindBy(id = "welcome")
  private WebElement welcomeLink;

  @FindBy(id = "menu_dashboard_index")
  private WebElement dashboardLink;

  @FindBy(xpath = "//span[contains(text(),'Assign Leave')]")
  private WebElement assignLeaveLink;

  public HomePage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getWelcomeLinkText() {
    return welcomeLink.getText();
  }

  public void clickDashboardLink() {
    dashboardLink.click();
  }

  public void clickAssignLeaveLink() {
    assignLeaveLink.click();
  }
}
