package pages.protonMail;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractBasePage;
import service.TestDataReader;

import java.util.concurrent.TimeUnit;

public class ProtonMailMainPage extends AbstractBasePage {

    public static final String TESTDATA_USER_MAILSUBJECT = "testdata.user.emailSubject";
    public static final String TESTDATA_USER_MAILTEXT = "testdata.user.emailText";

    @FindBy(xpath = "//button[@data-testid='heading:userdropdown']/span[1]")
    private WebElement profileName;

    @FindBy(xpath = "//button[text()='New message']")
    private WebElement newMessageButton;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement mailToInputField;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement mailSubjectInputField;

    @FindBy(xpath = "//div[@id='rooster-editor']/div")
    private WebElement mailTextInputField;


    @FindBy(xpath = "//button[@data-testid='composer:send-button']")
    private WebElement sendButton;



    public ProtonMailMainPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(profileName));
        return profileName.getText();
    }

    public ProtonMailMainPage clickNewEmailButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(newMessageButton));
        newMessageButton.click();
        logger.info("New email button clicked");
        return new ProtonMailMainPage(driver);
    }

    public void sendNewEmail(User testUser){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(mailToInputField));
        mailToInputField.sendKeys(testUser.getUsername());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(mailSubjectInputField));
        mailSubjectInputField.sendKeys(TestDataReader.getTestData(TESTDATA_USER_MAILSUBJECT));
        driver.switchTo().frame(0);
        webDriverWait().until(ExpectedConditions.elementToBeClickable(mailTextInputField));
        mailTextInputField.sendKeys(TestDataReader.getTestData(TESTDATA_USER_MAILTEXT));
        driver.switchTo().defaultContent();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logger.info("Email sent");

    }


}
