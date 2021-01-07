package testcases;

import Base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

public class SearchProduct extends BasePage {
   // String expectedSearchResult = "Asus N551JK-XO076H Laptop";

    @Test
    public void searchForProduct() {
       // System.out.println(homepage.getPageTitle());

        homepage.enterSearchBox(prop.getProperty("searchText"));
        homepage.clickSearchbutton();

       /* //Thread.sleep(1000);

        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Asus N551JK-XO076H Laptop")));

        driver.findElement(By.linkText("Asus N551JK-XO076H Laptop")).click();


        String resultText1 = driver.findElement(By.xpath("//h1[contains(text(),'Asus N551JK-XO076H Laptop')]")).getText();
        System.out.println("First product displayed is : "+resultText1);

        Assertions.assertEquals(resultText1, expectedSearchResult);

        boolean image = driver.findElement(By.id("main-product-img-5")).isDisplayed();
        Assertions.assertTrue(image, "image is displayed");
        System.out.println("image is displayed");

        boolean price = driver.findElement(By.id("price-value-5")).isDisplayed();
        Assertions.assertTrue(price, "price is correctly displayed");
        System.out.println("price is correctly displayed");
    }

        */
    }
}
