package pages.fastMail;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractBasePage;

public class FastMailLoginPage extends AbstractBasePage {

    public FastMailLoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String FASTMAIL_HOMEPAGE_URL = "https://app.fastmail.com/login/";

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement LogInButton;



    public FastMailLoginPage openPage(){
        driver.switchTo().newWindow(WindowType.TAB);
        logger.info("New window opened");
        driver.navigate().to(FASTMAIL_HOMEPAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public FastMailMainPage login(User userReceiver)
    {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(userReceiver.getUsername());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(userReceiver.getPassword());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(LogInButton));
        LogInButton.click();
        logger.info("Login performed");
        return new FastMailMainPage(driver);
    }

}
