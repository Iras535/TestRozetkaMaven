package testiky;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static testiky.DriverWraper.getDriver;

public class MainPage {
    private By searchProductField = By.cssSelector("#rz-search > form > div.rz-header-search-inner > div.rz-header-search-input-text-wrap.sprite-side > input");
    private By enterButton = By.cssSelector("a.header-user-link.sprite-side.novisited.xhr");
    private By registerButton = By.cssSelector(".auth-f-signup>a");
    private By blockAlert = By.cssSelector("div.notificationPanelBlock");
    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("configuration.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("browser"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void open() throws InterruptedException {
        getDriver().get("http://www.rozetka.com.ua");
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().findElement(blockAlert).click();
        Thread.sleep(300);
    }

    public void searchProduct(String productName) {
        getDriver().findElement(searchProductField).click();
        getDriver().findElement(searchProductField).sendKeys(productName);
        //getDriver().findElement(searchProductField).sendKeys(Keys.ENTER);
    }


    public void goToRegistration() {
        getDriver().findElement(enterButton).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        getDriver().findElement(registerButton).click();
    }
}
