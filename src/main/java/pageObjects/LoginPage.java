package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{
  WebDriver driver;

  //locators

  @FindBy(id="Email") public WebElement emailTextBox;
  @FindBy(id ="Password") public WebElement passwordTextBox;
  @FindBy(className ="login-button") public WebElement loginBtn;
  @FindBy(linkText="Log out") public WebElement logoutBtn;

  //constructor
  public LoginPage(WebDriver driver)
  {
    this.driver = driver;
    PageFactory.initElements(driver,this);
  }

  //actions
  /*
  public void enterEmail(String em)
  {
    emailTextBox.sendKeys(em);
  }

  public void enterPassword(String pw)
  {
    passwordTextBox.sendKeys(pw);
  }
  public void clickLogin()
  {
    loginBtn.click();
  }

   */

  //instead of 3 methods

  public void loginToApp(String em,String pw)
  {
    emailTextBox.sendKeys(em);
    passwordTextBox.sendKeys(pw);
    loginBtn.click();
  }

  public void logOutFromApp()
  {
    logoutBtn.click();
  }

}
