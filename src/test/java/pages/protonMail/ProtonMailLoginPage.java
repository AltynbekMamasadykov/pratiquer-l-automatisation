package pages.protonMail;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractBasePage;

import java.util.List;

public class ProtonMailLoginPage extends AbstractBasePage {

    private static final String PROTONMAIL_HOMEPAGE_URL = "https://account.proton.me/login";

    @FindBy(xpath = "//*[@id='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement singInButton;

    @FindBy(xpath = "//span[text()='Incorrect login credentials. Please try again']")
    private WebElement incorrectCredentials;

    @FindBy(xpath = "//*[text()='This field is required']")
    private List<WebElement> thisFieldRequired;

    public ProtonMailLoginPage(WebDriver driver) {
        super(driver);
    }

    public ProtonMailLoginPage openPage(){
        driver.navigate().to(PROTONMAIL_HOMEPAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public ProtonMailMainPage login(User user)
    {
        webDriverWait().until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(user.getUsername());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(user.getPassword());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(singInButton));
        singInButton.click();
        logger.info("Login performed");
        return new ProtonMailMainPage(driver);
    }

    public boolean loginWithInCorrectCredentials(User user){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys(user.getUsername());
        webDriverWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("wrongPassword");
        webDriverWait().until(ExpectedConditions.elementToBeClickable(singInButton));
        singInButton.click();
        logger.info("Login with incorrect credentials performed");
        webDriverWait().until(ExpectedConditions.visibilityOf(incorrectCredentials));
        return incorrectCredentials.isDisplayed();
    }

    public boolean loginWithEmptyCredentials(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys("");
        webDriverWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("");
        webDriverWait().until(ExpectedConditions.elementToBeClickable(singInButton));
        singInButton.click();
        logger.info("Login with empty credentials performed");
        webDriverWait().until(ExpectedConditions.visibilityOfAllElements(thisFieldRequired));
        return thisFieldRequired.size() == 2;
    }

}
