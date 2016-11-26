package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class RegistrationPage {

    private By nameForm = By.name("title");
    private By emailForm = By.name("email");
    private By passwordForm = By.name("password");
    private By registerButton = By.cssSelector(".signup-submit button");
    public String generateEmail() {
        Random r = new Random(System.currentTimeMillis() );
        return "ari" + ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)) + "@mailinator.com";
    }
    public void enterWrongName (){
        DriverWraper.getDriver().findElement(nameForm).click();
        DriverWraper.getDriver().findElement(nameForm).sendKeys("!@#$%^&*");
    }
    public void enterName (){
        DriverWraper.getDriver().findElement(nameForm).click();
        DriverWraper.getDriver().findElement(nameForm).sendKeys("Аристотель");
    }
    public void enterWrongMail (){
        DriverWraper.getDriver().findElement(emailForm).click();
        DriverWraper.getDriver().findElement(emailForm).sendKeys("my@mom.com");
    }
    public void clickRegisterButton() {
        DriverWraper.getDriver().findElement(registerButton).click();
    }
    public void enterPassword () {
        DriverWraper.getDriver().findElement(passwordForm).click();
        DriverWraper.getDriver().findElement(passwordForm).sendKeys("example12345");
    }
    public boolean isEmailRed (){
        return  DriverWraper.getDriver().findElement(By.name("email")).getCssValue("background-color").contains("rgba(255, 214, 214, 1)");
    }
}
