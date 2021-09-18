package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@src='/img/logos/logo_red.svg?3']")
    private WebElement logo;

    @FindBy(xpath = "//header[@class='header-content desktop-header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//input[@class='search-input']")
    private WebElement searchField;

    @FindBy(xpath = "//img[@src='/img/icons/cart-icon.svg?3']")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@class='city-select-text']")
    private WebElement citySelector;

    @FindBy(xpath = "//div[@class='city-modal-title']")
    private WebElement CatalogOfCity;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);
    }
}

