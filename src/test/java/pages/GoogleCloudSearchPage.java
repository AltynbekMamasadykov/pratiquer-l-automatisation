package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudSearchPage extends AbstractBasePage{

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    private static final String SEARCH_TEXT ="Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//devsite-search")
    private WebElement searchButton;

    @FindBy(xpath="//input[@role='searchbox']")
    private WebElement searchInputTextPlace;

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleCloudSearchResultPage searchCalculator() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(searchInputTextPlace));
        searchInputTextPlace.sendKeys(SEARCH_TEXT + Keys.ENTER);
        webDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        logger.info("Searching started");
        return new GoogleCloudSearchResultPage(driver);
    }

}
