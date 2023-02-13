package homepage.cloudSearch;
import homepage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudSearchPage extends BasePage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//devsite-search")
    private WebElement searchButton;

    @FindBy(xpath="//input[@role='searchbox']")
    private WebElement searchInputTextPlace;


    public CloudSearchPage(WebDriver driver){
        super(driver);
    }

    public CloudSearchPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudSearchPage clickSearchButton() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public CloudSearchPage EnterSearchElementAndSearch(String text) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(searchInputTextPlace));
        searchInputTextPlace.sendKeys(text+Keys.ENTER);
        return this;
    }


}
