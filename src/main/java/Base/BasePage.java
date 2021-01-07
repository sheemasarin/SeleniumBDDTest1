package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.ElectronicsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BasePage
{
    public static WebDriver driver;
    public static Properties prop;
    public static HomePage homepage;
    public static LoginPage loginpage;
    public static RegisterPage registerPage;
    public static ElectronicsPage electronicsPage;
    public static final String AUTOMATE_USERNAME = "sheemasarin1";
    public static final String AUTOMATE_ACCESS_KEY = "cyk1goUdicYZqNpWKWzd";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeAll
    public static void setup() throws MalformedURLException {
        prop = new Properties();
        try
        {
            FileInputStream fs = new FileInputStream("src/main/java/config/data.properties");
            prop.load(fs);
        }catch(Exception e)
        {
            e.printStackTrace();
        }



        //WebDriverManager.chromedriver().setup();
       // driver=new ChromeDriver();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.navigate().to(prop.getProperty("url"));
        driver.manage().window().maximize();
        homepage =new HomePage(driver);
        loginpage =new LoginPage(driver);
        registerPage =new RegisterPage(driver);
        electronicsPage=new ElectronicsPage(driver);
    }

    @AfterAll
    public static void tearDown()
    {
       // driver.close();
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void pageRefresh()
    {
        driver.navigate().refresh();
    }


}
