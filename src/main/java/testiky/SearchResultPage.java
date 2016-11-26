package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static testiky.DriverWraper.getDriver;

public class SearchResultPage {

private By searchResult = By.cssSelector("rz-header-search-suggest-i-title-link");

    public void clickFirstProduct() {
        getDriver().findElement(searchResult).click();
    }
}

