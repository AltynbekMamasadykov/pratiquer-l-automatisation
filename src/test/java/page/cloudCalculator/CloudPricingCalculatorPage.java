package page.cloudCalculator;

import page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudPricingCalculatorPage extends BasePage {

    @FindBy(xpath = "//*[@id='input_92']")
    private WebElement instanceNumberInputField;

    @FindBy(xpath = "//label[text()='Provisioning model']/..")
    private WebElement provisioningModel;

    @FindBy(xpath = "//label[text()='Series']/..")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//label[text()='Machine type']/..")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//*[contains(@placeholder,'GPU type')]")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//*[contains(@placeholder,'Number of GPUs')]")
    private WebElement numberOfGPUDropdown;

    @FindBy(xpath = "//label[text()='Local SSD']/..")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "(//label[text()='Datacenter location']/..)[1]")
    private WebElement dataCenterLocationDropdown;

    @FindBy(xpath = "(//label[text()='Committed usage']/..)[1]")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//*[contains(text(),'Add to Estimate')][1]")
    private WebElement addToEstimateButton;

    public CloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }


    public CloudPricingCalculatorPage activateSector(String sector){
        webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicSectorActivator(sector))));
        WebElement result = driver.findElement(By.xpath(dynamicSectorActivator(sector)));
        result.click();
        return this;
    }


    public CloudPricingCalculatorPage enterInstanceNumber(String number){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(instanceNumberInputField));
        instanceNumberInputField.sendKeys(number);
        return this;
    }

    public CloudPricingCalculatorPage clickProvisioningDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(provisioningModel));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", provisioningModel);
        provisioningModel.click();
        return this;
    }

    public CloudPricingCalculatorPage selectProvisioningType(String provision){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicProvisionSelector(provision))));
        WebElement provisionType = driver.findElement(By.xpath(dynamicProvisionSelector(provision)));
        provisionType.click();
        return this;
    }

    public CloudPricingCalculatorPage clickSeriesDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(seriesDropdown));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", seriesDropdown);
        seriesDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectSeries(String series){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicSeriesSelector(series))));
        WebElement serie = driver.findElement(By.xpath(dynamicSeriesSelector(series)));
        serie.click();
        return this;
    }

    public CloudPricingCalculatorPage clickMachineTypesDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(machineTypeDropdown));
        machineTypeDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectMachineType(String machineType){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicMachineTypeSelector(machineType))));
        WebElement machineTypo = driver.findElement(By.xpath(dynamicMachineTypeSelector(machineType)));
        machineTypo.click();
        return this;
    }

    public CloudPricingCalculatorPage checkboxAddGPUs(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(addGPUsCheckBox));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", addGPUsCheckBox);
        addGPUsCheckBox.click();
        return this;
    }

    public CloudPricingCalculatorPage clickGPUTypeDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(gpuTypeDropdown));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", gpuTypeDropdown);
        gpuTypeDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectGPUType(String gpuType){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicGPUTypeSelector(gpuType))));
        WebElement gpuTypo = driver.findElement(By.xpath(dynamicGPUTypeSelector(gpuType)));
        gpuTypo.click();
        return this;
    }

    public CloudPricingCalculatorPage clickNumberOfGPUsDropDown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(numberOfGPUDropdown));
        numberOfGPUDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectNumberOfGpu(int numberOfGPU){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicGPUNumberSelector(numberOfGPU))));
        WebElement numbersOfGPU = driver.findElement(By.xpath(dynamicGPUNumberSelector(numberOfGPU)));
        numbersOfGPU.click();
        return this;
    }

    public CloudPricingCalculatorPage clickLocalSSDDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(localSSDDropdown));
        localSSDDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectLocalSSD(String localSSD){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicLocalSSDSelector(localSSD))));
        WebElement localSsd = driver.findElement(By.xpath(dynamicLocalSSDSelector(localSSD)));
        localSsd.click();
        return this;
    }

    public CloudPricingCalculatorPage clickDataCenterLocationDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(dataCenterLocationDropdown));
        dataCenterLocationDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectDataCenterLocation(String location){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicDataCenterLocationSelector(location))));
        WebElement dataCenterLocation = driver.findElement(By.xpath(dynamicDataCenterLocationSelector(location)));
        dataCenterLocation.click();
        return this;
    }

    public CloudPricingCalculatorPage clickCommittedUsageDropdown(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(committedUsageDropdown));
        committedUsageDropdown.click();
        return this;
    }

    public CloudPricingCalculatorPage selectCommittedUsage(String usage){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicUsageSelector(usage))));
        WebElement usageCommitted = driver.findElement(By.xpath(dynamicUsageSelector(usage)));
        usageCommitted.click();
        return this;
    }

    public CloudPricingCalculatorPage clickAddToEstimateButton(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();
        return this;
    }


    private String dynamicUsageSelector(String usage){
        return "(//div[text()='"+usage+"'])[2]";
    }

    private String dynamicDataCenterLocationSelector(String dataCenterLocation){
        return "(//*[contains(text(),'"+dataCenterLocation+"')])[3]/..";
    }

    private String dynamicLocalSSDSelector(String localSSD){
        return "//*[contains(text(), '"+localSSD+"')]/..";
    }

    private String dynamicGPUNumberSelector(int numberOfGPU){
        return "//*[text()="+numberOfGPU+"]";
    }

    private String dynamicGPUTypeSelector(String gpuType){
        return "//*[contains(text(),'"+gpuType+"')]";
    }

    private String dynamicMachineTypeSelector(String machineType){return "//*[contains(text(),' "+machineType+" ')]";}

    private String dynamicSeriesSelector(String series){
        return "//md-option[@value='"+series+"']";
    }

    private String dynamicSectorActivator(String sector){
        return "//span[text()='"+sector+"']";
    }

    private String dynamicProvisionSelector(String provision){return "//md-option[@value='"+provision.toLowerCase()+"']";}
}
