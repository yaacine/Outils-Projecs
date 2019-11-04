import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbayTest1 {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //For Firefox
        //System.setProperty("webdriver.gecko.driver","/opt/webdriver/geckodriver");
        // For Chrome
        System.setProperty("webdriver.chrome.driver",
                "chromedriver");



      driver = new ChromeDriver();

    }

    @Test
    public void test() {

        driver.get("https://www.ebay.com");
        WebElement wait = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("gh-shop-a"))
        );
        WebElement categoryButton  = driver.findElement(By.id("gh-shop-a"));
        categoryButton.click();

        WebElement kidsToys  = driver.findElement(By.linkText("Kids toys"));
        kidsToys.click();


        //action elements
        List<WebElement> list = driver.findElements(By.className("b-guidancecard__link"));
        list.get(2).click();

        //car element
        List<WebElement> listAction = driver.findElements(By.className("b-guidancecard__link"));
        listAction.get(1).click();

        //car element
        List<WebElement> listIron = driver.findElements(By.className("b-guidancecard__link"));
        listIron.get(4).click();

        driver.get("https://www.ebay.com/b/Action-Cast-Iron-Diecast-Toy-Cars/222/bn_107912958");

        WebElement wait2 = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.className("s-item__image-wrapper"))
        );

        List<WebElement> results = driver.findElements(By.className("s-item__image-wrapper"));
        Assert.assertEquals(results.size() ,6);

    }



}
