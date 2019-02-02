package utils;

import org.openqa.selenium.WebDriver;
import pageobjects.AssignLeavePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class PageObjectManager {
  private WebDriver driver;
  private HomePage homePage;
  private LoginPage loginPage;
  private AssignLeavePage assignLeavePage;

  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage getHomePage() {
    return (homePage == null) ? homePage = new HomePage(driver) : homePage;
  }

  public LoginPage getLoginPage() {
    return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
  }

  public AssignLeavePage getAssignLeavePage() {
    return (assignLeavePage == null) ? assignLeavePage = new AssignLeavePage(driver) : assignLeavePage;
  }
}
