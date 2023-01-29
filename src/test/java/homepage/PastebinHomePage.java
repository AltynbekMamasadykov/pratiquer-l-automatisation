package homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy (id = "postform-text")
    private WebElement textPostform;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']" )
    private WebElement expirationList;

   @FindBy(xpath = "//*[@id='postform-name']")
   private WebElement pasteNameTitle;

   @FindBy(xpath = "//button[text()='Create New Paste']")
   private WebElement createNewPaste;


    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage fillTextForm(String text) {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(textPostform));
        textPostform.sendKeys(text);
        return this;
    }

    public PastebinHomePage clickExpirationsDropDown() {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(expirationList));
        expirationList.click();
        return this;
    }

    public PastebinHomePage selectExpiration(String expiration){
        WebElement exp = driver.findElement(By.xpath(dynamicExpirationMaker(expiration)));
        webDriverWait().until(ExpectedConditions.elementToBeClickable(exp));
        exp.click();
        return this;
    }

    public PastebinHomePage insertPasteName(String name){
        pasteNameTitle.sendKeys(name);
        return this;
    }

    public PastebinHomePage createNewPaste(){
        createNewPaste.click();
        return this;
    }

    private String dynamicExpirationMaker(String expiration){
        return "//li[text()='"+expiration+"']";
    }

    private WebDriverWait webDriverWait(){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
