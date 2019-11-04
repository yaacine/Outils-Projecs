package EbayTest3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage extends PageObject {


    private Select select_active ;
    @FindBy(id = "msku-sel-1") private WebElement selectSize;
    @FindBy(id = "isCartBtn_btn") private WebElement addToCartButton;


    public DetailsPage(WebDriver driver) {
        super(driver);
        this.select_active = new Select(selectSize);
    }

    public void chooseSize(Integer index){

        select_active.selectByValue(index.toString());


    }



    public void addToCart(){
        addToCartButton.click();
    }
}
