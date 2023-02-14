package page.cloudCalculator;

import page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudPricingCalculatorResult extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Provisioning model:')]")
    private WebElement provisioningModel;

    @FindBy(xpath = "//*[contains(text(), 'Instance type:')]")
    private WebElement instanceType;

    @FindBy(xpath = "//*[contains(text(),' Region:')]")
    private WebElement region;

    @FindBy(xpath = "//*[contains(text(), 'Commitment term:')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//*[contains(text(), 'Local SSD:')]")
    private WebElement localSSD;

    @FindBy(xpath = "//*[contains(text(), 'Total Estimated Cost:')]")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//*[@id='Email Estimate']")
    private WebElement emailEstimateButton;

    public CloudPricingCalculatorResult(WebDriver driver) {
        super(driver);
    }

    public String getProvisioningModel(){
        return provisioningModel.getText();
    }

    public String getInstanceType(){
        return instanceType.getText();
    }

    public String getRegion(){
        return region.getText();
    }

    public String getCommitmentTerm(){
        return commitmentTerm.getText();
    }

    public String getLocalSSD(){
        return localSSD.getText();
    }

    public String getTotalEstimatedCost(){
        return totalEstimatedCost.getText();
    }

    public CloudPricingCalculatorResult clickEmailEstimateButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        emailEstimateButton.click();
        return this;
    }


}
