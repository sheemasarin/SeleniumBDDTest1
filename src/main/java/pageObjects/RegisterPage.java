package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage
{
    WebDriver driver;

    //locators

    @FindBy(id = "gender-male") public WebElement maleRadioBtn;
    @FindBy(id = "gender-female") public WebElement femaleRadioBtn;
    @FindBy(id = "FirstName") public WebElement firstNameTxtBox;
    @FindBy(id = "LastName") public WebElement lastNameTxtBox;
     @FindBy(id ="Email") public WebElement emailTxtBox;
    @FindBy(id = "Password") public WebElement passwordTextBox;
    @FindBy(id = "ConfirmPassword") public WebElement cnfmPasswordTextBox;
    @FindBy(id ="register-button") public WebElement registerBtn;

    //constructor

    public RegisterPage(WebDriver driver)
    {
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //actions

    public void userRegister(String em,String fn,String ln,String pw,String cnfpw)
    {
        emailTxtBox.sendKeys(em);
        firstNameTxtBox.sendKeys(fn);
        lastNameTxtBox.sendKeys(ln);
        passwordTextBox.sendKeys(pw);
        cnfmPasswordTextBox.sendKeys(cnfpw);

    }

    public void clickMale()
    {
        maleRadioBtn.click();
    }
    public void clickFemale()
    {
        femaleRadioBtn.click();
    }

    public void selectDOB(String dd,String mm,String yy)
    {
        Select date = new Select(driver.findElement(By.name("DateOfBirthDay")));
        date.selectByVisibleText(dd);
        Select month = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        month.selectByVisibleText(mm);

        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText(yy);
    }

    public void clickRegisterButton()
    {
        registerBtn.click();
    }
}
