package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
//    private WebDriver driver;

    private By priceInCart = By.cssSelector("span[name='cost']");

//    public Cart(WebDriver driver) {
//        this.driver = driver;
//    }

    public Integer getPriceInCart() {
        return Utils.formatPrice(DriverWraper.getDriver().findElement(priceInCart).getText());
    }

    public void changeQuantitiesPlus() throws InterruptedException {
        DriverWraper.getDriver().findElement(By.className("cart-amount-plus")).click();
        WebDriverWait wait = new WebDriverWait(DriverWraper.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#cart_payment_info img")));
    }

    public void changeQuantitiesSendOne() {
        DriverWraper.getDriver().findElement(By.name("quantity")).sendKeys(Keys.BACK_SPACE);
        DriverWraper.getDriver().findElement(By.name("quantity")).sendKeys("1");
        DriverWraper.getDriver().findElement(By.name("quantity")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(DriverWraper.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#cart_payment_info img")));
    }
}
