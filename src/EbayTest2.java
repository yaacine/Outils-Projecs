import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbayTest2 {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //For Firefox
        System.setProperty("webdriver.gecko.driver","geckodriver");
        // For Chrome
        //System.setProperty("webdriver.chrome.driver",
        //        "chromedriver");



        driver = new FirefoxDriver();



    }

    @Test
    public void test2() {
        driver.get("https://www.ebay.com");


        WebElement wait = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("gh-btn"))
        );
        WebElement searchBar = driver.findElement(By.cssSelector(".gh-tb.ui-autocomplete-input"));


        searchBar.sendKeys("shoes for men");
        WebElement submitSearch = driver.findElement(By.id("gh-btn"));
        submitSearch.click();

        List<WebElement> searchResults = driver.findElements(By.className("s-item__title"));
        searchResults.get(0).click();
        WebElement wait2 = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("gh-btn"))
        );

        WebElement wait3 = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("msku-sel-1"))
        );


        Select sizeSelect = new Select(driver.findElement(By.id("msku-sel-1")));
        sizeSelect.selectByIndex(1);

        WebElement addChart = driver.findElement(By.id("isCartBtn_btn"));
        //WebElement addChart = driver.findElement(By.xpath("//a[@href='javascript:;']"));

        addChart.click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement totalPrice = driver.findElement(By.cssSelector(".val-col.total-row")).findElement(By.tagName("span")).findElement(By.tagName("span"));

        String price = totalPrice.getText();

        System.out.println(price);
       String price1=price.substring(4);
        System.out.println(price1);
        double priceNumber =Double.parseDouble(price1) ;
        Assert.assertTrue(priceNumber ==10.49);



    }
}
