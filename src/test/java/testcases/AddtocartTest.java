package testcases;

import Base.BasePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtocartTest extends BasePage {
    @Test
    public void addproductToCart() throws InterruptedException {
        homepage.clickElectronics();

        electronicsPage.clickCamera();

        Thread.sleep(2000);

        electronicsPage.clickFirstProduct();

        electronicsPage.clickAddToCart();
        Thread.sleep(2000);


        homepage.clickShoppingCart();
        Thread.sleep(1000);
        boolean selection = driver.findElement(By.linkText("Nikon D5500 DSLR - Black")).isDisplayed();
        System.out.println("Product added to cart : " + selection);

        Thread.sleep(2000);

        driver.findElement(By.id("itemquantity11218")).sendKeys("2");
        driver.findElement((By.className("button-2 update-cart-button"))).click();
        boolean newprice = driver.findElement(By.xpath("//span[contains(text(),'$1,340.00')]")).isDisplayed();
        System.out.println(newprice);



    }
}
