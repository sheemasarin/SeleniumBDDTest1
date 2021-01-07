package testcases;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BasePage
{
    String homePageExpectedTitle = "nopCommerce demo store";
    String homePageActualTitle;

    @Test
    public void registeration()
    {
        homePageActualTitle = getPageTitle();

        Assertions.assertEquals(homePageExpectedTitle, homePageActualTitle);
        homepage.clickRegisterLink();
        pageRefresh();
        System.out.println("page title is : " +getPageTitle());
        registerPage.clickFemale();
        registerPage.userRegister(prop.getProperty("email"), prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("password"), prop.getProperty("password"));
        registerPage.selectDOB(prop.getProperty("daate"), prop.getProperty("datemonth"), prop.getProperty("dateyear"));

        registerPage.clickRegisterButton();

        String successmessage = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        System.out.println("Registration success message is : " +successmessage);

        //driver.findElement(By.className("register-continue-button")).click();



    }



}
