package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage extends BasePage
{
    WebDriver driver;
    //page factory initialization
    public ElectronicsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    //locators
    @FindBy(linkText = "Camera & photo") WebElement cameralink;
    @FindBy(linkText = "Nikon D5500 DSLR" ) WebElement firstProduct;
    @FindBy(xpath ="//input[@id='add-to-cart-button-14']") WebElement addtocartBtn;


    //actions
    public void clickCamera()
    {
        WebElement electronics = driver.findElement(By.linkText("Electronics")); //should remove spaces
        Actions actions =new Actions(driver);
        actions.moveToElement(electronics).perform();
        cameralink.click();
    }
    public void clickFirstProduct() throws InterruptedException {

        firstProduct.click();
    }
    public void clickAddToCart() throws InterruptedException
    {
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']")).click();
        addtocartBtn.click();
    }


}
