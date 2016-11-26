package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductePage {
    private By priceLabel = By.cssSelector("span#price_label");
    private By buyButton = By.cssSelector(".detail-buy-btn-link>button");

    public Integer getPrice() {
        return Integer.parseInt(DriverWraper.getDriver().findElement(priceLabel).getText());
    }

    public void clickBuy(){
        DriverWraper.getDriver().findElement(buyButton).click();
    }
}
