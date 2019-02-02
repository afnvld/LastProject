package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class LoginPage {

  private WebDriver driver;

  @FindBy(id = "txtUsername")
  private WebElement usernameInput;

  @FindBy(id = "txtPassword")
  private WebElement passwordInput;

  @FindBy(id = "btnLogin")
  private WebElement loginBtn;

  @FindBy(id = "spanMessage")
  private WebElement warningMessage;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateTo_LoginPage() {
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
  }

  public void fillUsername(String username) {
    usernameInput.sendKeys(username);
  }

  public void fillPassword(String password) {
    passwordInput.sendKeys(password);
  }

  public void clickLoginBtn() {
    loginBtn.click();
  }

  public String getWarningMessageText() {
    return warningMessage.getText();
  }
}
