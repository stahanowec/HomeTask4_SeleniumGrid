package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();// ThreadLocal позволяет нам хранить данные, которые будут доступны только конкретным потоком. Каждый поток будет иметь свой собственный экземпляр ThreadLocal
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String ELDORADO_URL = "https://eldorado.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.12:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(ELDORADO_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }
//
//    public ShoppingCartPage getShoppingCartPage() {
//        return new ShoppingCartPage(getDriver());
//    }
//
//    public ProductPage getProductPage() {
//        return new ProductPage(getDriver());
//    }
//
//    public CheckoutPage getCheckoutPage() {
//        return new CheckoutPage(getDriver());
//    }
}
