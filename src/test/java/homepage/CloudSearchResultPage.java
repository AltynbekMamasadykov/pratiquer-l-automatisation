package homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudSearchResultPage extends BasePage{

    public CloudSearchResultPage(WebDriver driver){
       super(driver);
    }

    public CloudSearchResultPage findFromResultsAndClick(String element) {
        webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicElementPicker(element))));
        WebElement result = driver.findElement(By.xpath(dynamicElementPicker(element)));
        result.click();
        return this;
    }

    private String dynamicElementPicker(String element){
        return "//b[text()='"+element+"']";
    }

}
