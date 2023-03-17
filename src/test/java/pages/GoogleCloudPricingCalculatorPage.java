package pages;
import model.GoogleCloudPricingCalculator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class GoogleCloudPricingCalculatorPage extends AbstractBasePage{

    @FindBy(xpath = "//*[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement instanceNumberInputField;

    @FindBy (xpath = "//label[text()='Operating System / Software']/..")
    private WebElement operatingSystem;

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

    @FindBy(xpath = "//*[contains(text(), 'Total Estimated Cost:')]")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//*[@id='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;


    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }


    public void addToEstimate(GoogleCloudPricingCalculator calculator){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
//        driver.switchTo().frame(0);
//        driver.switchTo().frame("myFrame");
        WebElement iframe1 = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//devsite-iframe//iframe")));
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", iframe1);
        driver.switchTo().frame(iframe1);
        WebElement iframe2 = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//iframe[@id='myFrame']")));
        //javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", iframe2);
        driver.switchTo().frame(iframe2);
        logger.info("switch to frame");



        //Number of instances field
        webDriverWait().until(ExpectedConditions.elementToBeClickable(instanceNumberInputField));
        instanceNumberInputField.sendKeys(calculator.getNumberOfInstances());


        //Operation_System/Software
        WebElement op = webDriverWait().until(ExpectedConditions.elementToBeClickable(operatingSystem));
        actions.moveToElement(op).click().build().perform();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicOperatingSystemSelector(calculator.getOperationSystem()))));
        WebElement operatingSystemType = driver.findElement(By.xpath(dynamicOperatingSystemSelector(calculator.getOperationSystem())));
        operatingSystemType.click();

        // Provisioning Model
        webDriverWait().until(ExpectedConditions.elementToBeClickable(provisioningModel));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", provisioningModel);
        provisioningModel.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicProvisionSelector(calculator.getProvisioningModel()))));
        WebElement provisionType = driver.findElement(By.xpath(dynamicProvisionSelector(calculator.getProvisioningModel())));
        provisionType.click();

        //Series
        webDriverWait().until(ExpectedConditions.elementToBeClickable(seriesDropdown));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", seriesDropdown);
        seriesDropdown.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicSeriesSelector(calculator.getSeries()))));
        WebElement serie = driver.findElement(By.xpath(dynamicSeriesSelector(calculator.getSeries())));
        serie.click();

        //Machine Type
        webDriverWait().until(ExpectedConditions.elementToBeClickable(machineTypeDropdown));
        machineTypeDropdown.click();
        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicMachineTypeSelector(calculator.getMachineType()))));
        WebElement machineTypo = driver.findElement(By.xpath(dynamicMachineTypeSelector(calculator.getMachineType())));
        machineTypo.click();

//        //GPU checkbox
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(addGPUsCheckBox));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", addGPUsCheckBox);
//        addGPUsCheckBox.click();
//
//        //GPU Type
//
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(gpuTypeDropdown));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", gpuTypeDropdown);
//        gpuTypeDropdown.click();
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicGPUTypeSelector(calculator.getGPUType()))));
//        WebElement gpuTypo = driver.findElement(By.xpath(dynamicGPUTypeSelector(calculator.getGPUType())));
//        gpuTypo.click();
//
//        //Number of GPU
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(numberOfGPUDropdown));
//        numberOfGPUDropdown.click();
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicGPUNumberSelector(calculator.getNumberOfGPU()))));
//        WebElement numbersOfGPU = driver.findElement(By.xpath(dynamicGPUNumberSelector(calculator.getNumberOfGPU())));
//        numbersOfGPU.click();
//
//        //Local SSD
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(localSSDDropdown));
//        localSSDDropdown.click();
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicLocalSSDSelector(calculator.getLocalSSD()))));
//        WebElement localSsd = driver.findElement(By.xpath(dynamicLocalSSDSelector(calculator.getLocalSSD())));
//        localSsd.click();
//
//        //Data Center
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(dataCenterLocationDropdown));
//        dataCenterLocationDropdown.click();
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicDataCenterLocationSelector(calculator.getDatacenterLocation()))));
//        WebElement dataCenterLocation = driver.findElement(By.xpath(dynamicDataCenterLocationSelector(calculator.getDatacenterLocation())));
//        dataCenterLocation.click();
//
//        //usage
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(committedUsageDropdown));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", committedUsageDropdown);
//        committedUsageDropdown.click();
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicUsageSelector(calculator.getCommittedUsage()))));
//        WebElement usageCommitted = driver.findElement(By.xpath(dynamicUsageSelector(calculator.getCommittedUsage())));
//        usageCommitted.click();
//
//        //Add to Estimate
//
//        webDriverWait().until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", addToEstimateButton);
//        addToEstimateButton.click();


    }

    public GoogleCloudPricingCalculatorPage switchToFrame(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        driver.switchTo().frame(0);
//        driver.switchTo().frame("myFrame");
        WebElement iframe1 = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//devsite-iframe//iframe")));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", iframe1);
        driver.switchTo().frame(iframe1);
        WebElement iframe2 = webDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//iframe[@id='myFrame']")));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", iframe2);
        driver.switchTo().frame(iframe2);
        logger.info("switch to frame");
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    public YopmailHandler openNewWindow(WebDriver driver){
        driver.switchTo().newWindow(WindowType.TAB);
        logger.info("New window opened");
        return new YopmailHandler(driver);
    }


    public GoogleCloudPricingCalculatorPage setEstimate(GoogleCloudPricingCalculator calculator){
        addToEstimate(calculator);
        logger.info("New Estimation set");
        return this;
    }


    public GoogleCloudPricingCalculatorPage emailEstimate(){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        emailEstimateButton.click();
        logger.info("email Estimate button clicked");
        return this;
    }

    public YopmailHandler sendEmail(WebDriver driver){
        webDriverWait().until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInputField.click();
        emailInputField.sendKeys(Keys.CONTROL + "v");
        webDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        logger.info("sent email of Estimation");
        return new YopmailHandler(driver);
    }

    public String getTotalEstimatedCost(){
        String preResult = totalEstimatedCost.getText();
        int secondParameter = preResult.indexOf("per");
        String preResultSub = preResult.substring(preResult.indexOf("USD"),secondParameter-1);
        String estimatedSub = "Estimated Monthly Cost: ";
        logger.info("getTotalEstimateCost");
        return estimatedSub+preResultSub;
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

    private String dynamicGPUNumberSelector(String numberOfGPU){
       return "//*[contains(@ng-repeat,'supportedGpuNumber') and @value='"+numberOfGPU+"' ]";
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

    private String dynamicOperatingSystemSelector(String operatingSystem){return "//div[contains(text(), '"+ operatingSystem +"')]/parent::md-option";}

}
