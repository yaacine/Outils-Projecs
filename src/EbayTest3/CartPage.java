package EbayTest3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage extends PageObject {



    WebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);

    }


    public double getPrice(){

        WebElement wait3 = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".val-col.total-row"))
        );


        totalPrice = driver.findElement(By.cssSelector(".val-col.total-row")).
                findElement(By.tagName("span")).
                findElement(By.tagName("span"));
        String price = totalPrice.getText();
        String price1=price.substring(4);
        double priceNumber =Double.parseDouble(price1) ;
        return priceNumber;
    }
}
