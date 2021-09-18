package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 30;

    @Test
    public void checkComponentsHomePage() {

        SoftAssert softAssert = new SoftAssert();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        softAssert.assertTrue(getHomePage().isLogoVisible());
        softAssert.assertTrue(getHomePage().isHeaderVisible());
        softAssert.assertTrue(getHomePage().isFooterVisible());
        softAssert.assertTrue(getHomePage().isSearchFieldVisible());
        softAssert.assertTrue(getHomePage().isCartIconVisible());
        softAssert.assertAll();
    }

    @Test
    public void checkCompareBlock() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().enterTextToSearchField("iPhone 13");
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().clickCompareIconOnFirstProduct();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertEquals(getSearchResultsPage().getCompareCounter(), "1");

    }
}
