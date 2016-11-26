package testiky;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends AbstractTest {

    @Test
    public void registrationTest() throws InterruptedException {
        mainPage.open();
    }

    @Test
    public void registrationWithWrongMail() throws InterruptedException {
        mainPage.open();
        mainPage.goToRegistration();
        registrationPage.enterName();
        //registrationPage.enterWrongMail();
        registrationPage.clickRegisterButton();
        //registrationPage.enterPassword();
        Thread.sleep(5000);
        Assert.assertTrue(registrationPage.isEmailRed());
    }
}
