package testiky;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeRegistrationTest extends AbstractTest {

    @Test
    public void negativeRegistrationTest() throws InterruptedException {
        mainPage.open();
    }



    private By emailField = By.cssSelector("input[name = email]");
    private By nameField = By.cssSelector("input[name = title]");
    private By passwordField = By.cssSelector("input[name = password]");
    private By registeredButton = By.cssSelector("#signup_form > div.signup-submit > span > button");

    String email = "@h.com";
    String name = "Me";
    String password = "My123456";



    @Test
    public void makeNegativeRegistration() throws InterruptedException{
        mainPage.open();
        mainPage.goToRegistration();

        DriverWraper.getDriver().findElement(emailField).click();
        DriverWraper.getDriver().findElement(emailField).sendKeys(email);

        DriverWraper.getDriver().findElement(nameField).click();
        DriverWraper.getDriver().findElement(nameField).sendKeys(name);

        DriverWraper.getDriver().findElement(passwordField).click();
        DriverWraper.getDriver().findElement(passwordField).sendKeys(password);

        DriverWraper.getDriver().findElement(registeredButton).click();

        Thread.sleep(5000);
        Assert.assertTrue(registrationPage.isEmailRed());
    }

}