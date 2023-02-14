package page.cloudCalculator;

import page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailEstimateResult extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;

    public EmailEstimateResult(WebDriver driver) {
        super(driver);
    }

    public EmailEstimateResult clickToEmailInputField(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInputField.click();
        emailInputField.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public EmailEstimateResult clickSendEmailButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        return this;
    }


}
