package pages.fastMail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractBasePage;
import java.time.Duration;
import java.util.List;

public class FastMailMainPage extends AbstractBasePage {

    @FindBy(xpath = "//*[text()='Inbox']/..")
    private WebElement inboxButton;

    @FindBy(xpath = "//label[text()='Unread']")
    private WebElement unreadButton;

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

        webDriverWait().until(ExpectedConditions.elementToBeClickable(inboxButton));
        inboxButton.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(unreadButton));
        unreadButton.click();
        List<WebElement> listOfUnreadMails = new WebDriverWait(driver, Duration.ofSeconds(50))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='v-MailboxItem u-list-item is-unread']")));
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
