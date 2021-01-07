package testcases;

import Base.BasePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterLoginSearch extends BasePage
{
    String homePageExpectedTitle = "nopCommerce demo store";
    String homePageActualTitle;
    String expectedErrorMsg = "Search term minimum length is 3 characters";

    @Test
    @Order(1)
    public void registerFirst() throws InterruptedException {
        homePageActualTitle = getPageTitle();

        Assertions.assertEquals(homePageExpectedTitle, homePageActualTitle);

        homepage.clickRegisterLink();
        pageRefresh();
        System.out.println("page title is : " +getPageTitle());

        registerPage.clickMale();

        registerPage.userRegister(prop.getProperty("email"), prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("password"), prop.getProperty("password"));

        registerPage.selectDOB(prop.getProperty("daate"), prop.getProperty("datemonth"), prop.getProperty("dateyear"));

        registerPage.clickRegisterButton();

        String successmessage = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        System.out.println("Registration success message is : " +successmessage);

        //driver.findElement(By.className("register-continue-button")).click();

        loginpage.logOutFromApp();

        Thread.sleep(1000);

    }
    @Test
    @Order(2)
    public void loginNow()
    {
        pageRefresh();
        System.out.println(homepage.getPageTitle());
        homepage.clickLoginLink();

        pageRefresh();

        loginpage.loginToApp(prop.getProperty("email"),prop.getProperty("password"));

    }
    @Test
    @Order(3)
    public void searchSingle()
    {
        pageRefresh();
        System.out.println(homepage.getPageTitle());
      homepage.enterSearchBox(prop.getProperty("searchTextInvalid"));
      homepage.clickSearchbutton();
       //WebElement actualErrorMsg = driver.findElement(By.xpath("//div[text()='Search term minimum length is 3 characters']")).getText();
       //actualErrorMsg.getText();
        boolean ErrorMsg = driver.findElement(By.xpath("//div[text()='Search term minimum length is 3 characters']")).isDisplayed();
         Assertions.assertTrue(ErrorMsg,"Error message is displayed");

       String actualErrorMsg = driver.findElement(By.xpath("//div[text()='Search term minimum length is 3 characters']")).getText();

        Assertions.assertEquals(expectedErrorMsg,actualErrorMsg);
        System.out.println("error message displayed is : " +actualErrorMsg);

    }
}
