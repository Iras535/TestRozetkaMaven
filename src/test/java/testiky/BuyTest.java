package testiky;

import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

import static testiky.DriverWraper.getDriver;

public class BuyTest extends AbstractTest{

    @Test
    public void testSum() throws InterruptedException {
        mainPage.open();
        mainPage.searchProduct("Apple iPhone SE");
        searchResultPage.clickFirstProduct();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        int expectedPrice = productPage.getPrice();
        productPage.clickBuy();
        int priceInCart = cart.getPriceInCart();

        Assert.assertEquals(expectedPrice, priceInCart);
    }

    @Test
    public void testPrice() throws InterruptedException {
        mainPage.open();
        mainPage.searchProduct("Apple iPhone SE");
        searchResultPage.clickFirstProduct();
        productPage.clickBuy();

        int priceInCartOne = cart.getPriceInCart();
        int priceInCartTwoCheck = priceInCartOne * 2;
        cart.changeQuantitiesPlus();
        int priceInCartTwo = cart.getPriceInCart();
        Assert.assertEquals(priceInCartTwoCheck, priceInCartTwo);

        cart.changeQuantitiesSendOne();
        int priceInCartThree = cart.getPriceInCart();
        Assert.assertEquals(priceInCartOne, priceInCartThree);
    }
}
