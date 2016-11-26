package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CabinetPage {
//    public CabinetPage(WebDriver driver) {
//        this.driver = driver;
//    }

//    protected WebDriver driver;
    private By checkButton = By.id("confirm_email_btn");
    public static By actualMail = By.xpath("//div[contains(text(), \"@walkmail.ru\")]");

    public void clickConfirmMail() throws InterruptedException {
        DriverWraper.getDriver().findElement(checkButton).click();
        Thread.sleep(10000);
    }
}

