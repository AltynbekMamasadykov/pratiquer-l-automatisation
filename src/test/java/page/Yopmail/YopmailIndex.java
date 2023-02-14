package page.Yopmail;

import page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailIndex extends BasePage {

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshInboxButton;


    @FindBy(xpath = "//*[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimationResultLine;

    public YopmailIndex(WebDriver driver) {
        super(driver);
    }

    public String getTotalEstimatedCost(){
       return webDriverWait().until(ExpectedConditions.visibilityOf(estimationResultLine)).getText();
    }
    ////*[contains(text(), 'Estimated Monthly Cost:')]

    public YopmailIndex clickRefreshInboxButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(refreshInboxButton));
        refreshInboxButton.click();
        return this;
    }
}
