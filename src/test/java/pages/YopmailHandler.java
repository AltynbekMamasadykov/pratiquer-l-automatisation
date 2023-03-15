package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class YopmailHandler extends AbstractBasePage{

    private static final String YOPMAIL_URL = "https://yopmail.com/";

    @FindBy(xpath = "//*[text()='Random Email generator']/../..")
    private WebElement yopmailGenerator;

    @FindBy(xpath = "//*[text()='Copy to clipboard']/..")
    private WebElement copyToClipBoard;

    @FindBy(xpath = "//*[contains(text(), 'Check Inbox')]")
    private WebElement checkInboxButton;

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshInboxButton;


    @FindBy(xpath = "//*[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimationResultLine;


    public YopmailHandler(WebDriver driver) {
        super(driver);
    }

    public YopmailHandler openPage() {
        driver.get(YOPMAIL_URL);
        logger.info("Yopmail page has been opened");
        return this;
    }

    public YopmailHandler clickEmailGenerator(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(yopmailGenerator));
        yopmailGenerator.click();
        logger.info("New email from Yopmail has been generated");
        return this;
    }

    public YopmailHandler copyToClipBoard(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(copyToClipBoard));
        copyToClipBoard.click();
        logger.info("email address copied to clipboard");
        return this;
    }

    public YopmailHandler clickCheckInboxButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(checkInboxButton));
        checkInboxButton.click();
        return this;
    }

    public String getTotalEstimatedCost(){
        return webDriverWait().until(ExpectedConditions.visibilityOf(estimationResultLine)).getText();
    }

    public YopmailHandler getNewYopmail(){
        openPage();
        clickEmailGenerator();
        copyToClipBoard();
        return this;
    }

    public GoogleCloudPricingCalculatorPage backSwitchToCalcPage(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        logger.info("Switch back to Calculator page");
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    public String checkAndGetResult(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        webDriverWait().until(ExpectedConditions.elementToBeClickable(checkInboxButton));
        checkInboxButton.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(refreshInboxButton));
        refreshInboxButton.click();
        driver.switchTo().frame("ifmail");
        logger.info("Get result from Yopmail inbox");
        return getTotalEstimatedCost();

    }


}
