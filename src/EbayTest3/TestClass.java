package EbayTest3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestClass {


    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeTest(){
        //For Firefox
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void addTochartTest() {
        driver.get("https://www.ebay.com");
        HomePage homePage = new HomePage(driver);

        WebElement wait = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("gh-btn"))
        );


        homePage.searchForSomething("shoes for men");
        homePage.setSubmitSearch();


        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.chooseProduct(0);


        WebElement wait3 = (new WebDriverWait(driver , 50)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("msku-sel-1"))
        );
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        DetailsPage detailsPage = new DetailsPage(driver);
        detailsPage.chooseSize(2);
        detailsPage.addToCart();




        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CartPage cartPage= new CartPage(driver);
        double price = cartPage.getPrice();

        Assert.assertEquals(12.59,price,0 );

    }
}
