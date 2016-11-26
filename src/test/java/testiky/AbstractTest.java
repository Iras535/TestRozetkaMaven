package testiky;

import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static testiky.DriverWraper.getDriver;

public abstract class AbstractTest {

    protected MainPage mainPage;
    protected SearchResultPage searchResultPage;
    protected ProductePage productPage;
    protected Cart cart;
    protected RegistrationPage registrationPage;
    protected CabinetPage cabinetPage;
    protected DriverWraper driverWraper;

    @Before
    public void preCondition(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver").getFile());
        System.setProperty("webdriver.chrome.driver",file.getPath());
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = new MainPage();
        searchResultPage = new SearchResultPage();
        productPage = new ProductePage();
        cart = new Cart();
        registrationPage = new RegistrationPage();
        cabinetPage = new CabinetPage();
    }

    @After
    public void postCondition(){
        getDriver().quit();
    }
}