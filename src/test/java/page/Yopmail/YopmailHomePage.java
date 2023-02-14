package page.Yopmail;

import page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailHomePage extends BasePage {

    private static final String YOPMAIL_URL = "https://yopmail.com/";



    @FindBy(xpath = "//*[text()='Random Email generator']/../..")
    private WebElement yopmailGenerator;

    @FindBy(xpath = "//*[text()='Copy to clipboard']/..")
    private WebElement copyToClipBoard;

    @FindBy(xpath = "//*[contains(text(), 'Check Inbox')]")
    private WebElement checkInboxButton;



    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopmailHomePage openPage() {
        driver.get(YOPMAIL_URL);
        return this;
    }

    public YopmailHomePage clickEmailGenerator(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(yopmailGenerator));
        yopmailGenerator.click();
        return this;
    }

    public YopmailHomePage copyToClipBoard(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(copyToClipBoard));
        copyToClipBoard.click();
        return this;
    }

    public YopmailHomePage clickCheckInboxButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(checkInboxButton));
        checkInboxButton.click();
        return this;
    }

}
