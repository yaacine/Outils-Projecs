package EbayTest3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(css = ".gh-tb.ui-autocomplete-input") private WebElement searchBar;
    @FindBy(id = "gh-btn") private WebElement submitSearch;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForSomething(String item){
        searchBar.sendKeys("shoes for men");
    }

    public void setSubmitSearch(){
        submitSearch.click();
    }

}
