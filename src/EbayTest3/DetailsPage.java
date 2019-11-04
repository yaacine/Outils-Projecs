package EbayTest3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage extends PageObject {


    @FindBy(id = "msku-sel-1") private Select selectSize;
    @FindBy(id = "isCartBtn_btn") private WebElement addToCartButton;


    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseSize(int index){
        selectSize.selectByIndex(index);

    }


    public void addToCart(){
        addToCartButton.click();
    }
}
