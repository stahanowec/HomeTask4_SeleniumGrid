package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//img[@alt='icon_compare']")
    private List<WebElement> compareIcon;

    @FindBy(xpath = "//div[@class='counter active']")
    private WebElement CompareCounter;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCompareIconOnFirstProduct() {compareIcon.get(1).click();}

    public boolean isCompareBlockVisible() {return CompareCounter.isDisplayed();}

    public String getCompareCounter() {return CompareCounter.getText();}
}
