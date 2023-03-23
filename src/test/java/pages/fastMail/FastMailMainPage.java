package pages.fastMail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractBasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FastMailMainPage extends AbstractBasePage {

    @FindBy(xpath = "//*[text()='Inbox']/..")
    private WebElement inboxButton;

    @FindBy(xpath = "//label[text()='Unread']")
    private WebElement unreadButton;

    @FindBy(xpath = "//li[@class='v-MailboxItem u-list-item is-unread']")
    private List<WebElement> listOfUnreadMails;

    @FindBy(xpath = "//span[@class='v-MailboxSource-badge']")
    private WebElement mailboxSourceBadge;

    @FindBy(xpath = "//button[text()='Show details']")
    private WebElement showDetailsButton;

    @FindBy(xpath = "(//dd[@class='v-Message-detailsValue'])[1]/span/a")
    private WebElement mailFrom;

    @FindBy(xpath = "(//dd[@class='v-Message-detailsValue'])[3]")
    private WebElement subject;

    @FindBy(xpath = "(//div[@class='u-containSelection v-Message-body']/div/div)[1]")
    private WebElement messageBody;


    public FastMailMainPage(WebDriver driver) {
        super(driver);
    }

    public void checkMail(){

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait().until(ExpectedConditions.visibilityOf(mailboxSourceBadge));
        webDriverWait().until(ExpectedConditions.elementToBeClickable(inboxButton));
        inboxButton.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(unreadButton));
        unreadButton.click();
        webDriverWait().until(ExpectedConditions.visibilityOfAllElements(listOfUnreadMails));
        listOfUnreadMails.get(0).click();
        webDriverWait().until(ExpectedConditions.visibilityOfAllElements(showDetailsButton));
        showDetailsButton.click();
        logger.info("Unread mail opened to read");
    }

    public String getSender(){
        return webDriverWait().until(ExpectedConditions.visibilityOf(mailFrom)).getText();
    }

    public String getSubject(){
        return webDriverWait().until(ExpectedConditions.visibilityOf(subject)).getText();
    }

    public String getEmailText(){
        return webDriverWait().until(ExpectedConditions.visibilityOf(messageBody)).getText();
    }

}
