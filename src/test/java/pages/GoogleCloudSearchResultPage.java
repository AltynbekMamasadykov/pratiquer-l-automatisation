package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudSearchResultPage extends AbstractBasePage{

    private static final String SEARCH_RESULT_TEXT = "Google Cloud Pricing Calculator";

    public GoogleCloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage openCalculator() {
        webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicElementPicker(SEARCH_RESULT_TEXT))));
        WebElement result = driver.findElement(By.xpath(dynamicElementPicker(SEARCH_RESULT_TEXT)));
        result.click();
        logger.info("Calculator page has been opened");
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    private String dynamicElementPicker(String element){
        return "//b[text()='"+element+"']";
    }

}
