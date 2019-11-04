package EbayTest3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends PageObject{


    @FindBy(className = "s-item__title") private List<WebElement> results;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseProduct(int index){
        results.get(index).click();
    }

}
