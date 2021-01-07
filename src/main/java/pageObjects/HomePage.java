package pageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
    WebDriver driver;


    //Locators
    @FindBy(linkText = "Register") public WebElement registerlink;
    @FindBy(linkText = "Log in") public WebElement loginLink;
    @FindBy(className = "ico-wishlist") public WebElement wishlistLink;
    @FindBy(id = "small-searchterms") public WebElement searchBox;
    @FindBy(className = "search-box-button") public WebElement searchBtn;
    @FindBy(linkText = "Electronics") public WebElement electronicslink;
    @FindBy(css = "a.ico-cart") public WebElement shoppingcartLink;

    //pagefactory initialisation

   public HomePage(WebDriver driver) //constructor
   {
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }




    //actions
    public void clickRegisterLink()
    {
        registerlink.click();
    }

    public void clickLoginLink()
    {
        loginLink.click();
    }

    public void clickWishlist()
    {
        wishlistLink.click();
    }

    public void enterSearchBox(String productName)
    {
        searchBox.sendKeys(productName);
    }
    public void clickSearchbutton()
    {
        searchBtn.click();
    }
    public void clickElectronics()
    {
        electronicslink.click();
    }
    public void clickShoppingCart()
    {

         pageRefresh();
        shoppingcartLink.click();
    }
}