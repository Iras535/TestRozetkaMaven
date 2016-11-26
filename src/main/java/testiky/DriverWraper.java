package testiky;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWraper {
    private static WebDriver driver;
    private DriverWraper(){
    };
    //pattern Singleton
    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
