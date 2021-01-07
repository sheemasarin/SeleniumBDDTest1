package testcases;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BasePage
{
    String homePageExpectedTitle = "nopCommerce demo store";
    String homePageActualTitle;
    @Test
   public  void loginToWebsite()
   {
       //homePageActualTitle = getPageTitle();

       Assertions.assertEquals(homePageExpectedTitle, homePageActualTitle);
    homepage.clickLoginLink();
    pageRefresh();
    loginpage.loginToApp(prop.getProperty("email"), prop.getProperty("password"));
   }

}
