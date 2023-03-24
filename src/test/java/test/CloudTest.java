package test;
import homepage.CloudPricingCalculatorPage;
import homepage.CloudPricingCalculatorResult;
import homepage.CloudSearchPage;
import homepage.CloudSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CloudTest {

    private static final String SEARCH_TEXT ="Google Cloud Platform Pricing Calculator";

    private static final String SEARCH_RESULT_TEXT = "Google Cloud Pricing Calculator";

    private static final String ACTIVATE_SECTOR = "Compute Engine";

    private static final String PROVISION = "Regular";

    private static final String INSTANCE_NUMBER = "4";

    private static final String SERIES ="n1";

    private static final String MACHINE_TYPE = "n1-standard-8";

    private static final String GPU_TYPE = "NVIDIA Tesla V100";

    private static final int NUMBER_OF_GPU = 1;

    private static final String LOCAL_SSD = "2x375";

    private static final String DATA_CENTER_LOCATION = "Frankfurt";

    private static final String COMMITTED_USAGE = "1 Year";

    private static final String TOTAL_COST_EXPECTED = "USD 1,081.20 per 1 month";

    private WebDriver driver;

    @BeforeClass(description = "Create driver and open max size window")
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void GoogleCloudPricingCalculator(){
        CloudSearchPage cloudSearchPage = new CloudSearchPage(driver);
        CloudSearchResultPage cloudSearchResultPage = new CloudSearchResultPage(driver);
        CloudPricingCalculatorPage cloudPricingCalculatorPage = new CloudPricingCalculatorPage(driver);
        CloudPricingCalculatorResult calculatorResult = new CloudPricingCalculatorResult(driver);

            cloudSearchPage
                .openPage()
                .clickSearchButton()
                .EnterSearchElementAndSearch(SEARCH_TEXT);
            cloudSearchResultPage
                .findFromResultsAndClick(SEARCH_RESULT_TEXT);

            driver.switchTo().frame(0);
            driver.switchTo().frame("myFrame");

            cloudPricingCalculatorPage
                    .activateSector(ACTIVATE_SECTOR)
                    .clickProvisioningDropdown()
                    .selectProvisioningType(PROVISION)
                    .enterInstanceNumber(INSTANCE_NUMBER)
                    .clickSeriesDropdown()
                    .selectSeries(SERIES)
                    .clickMachineTypesDropdown()
                    .selectMachineType(MACHINE_TYPE)
                    .checkboxAddGPUs()
                    .clickGPUTypeDropdown()
                    .selectGPUType(GPU_TYPE)
                    .clickNumberOfGPUsDropDown()
                    .selectNumberOfGpu(NUMBER_OF_GPU)
                    .clickLocalSSDDropdown()
                    .selectLocalSSD(LOCAL_SSD)
                    .clickDataCenterLocationDropdown()
                    .selectDataCenterLocation(DATA_CENTER_LOCATION)
                    .clickCommittedUsageDropdown()
                    .selectCommittedUsage(COMMITTED_USAGE)
                    .clickAddToEstimateButton();


        Assert.assertTrue(calculatorResult.getProvisioningModel().contains(PROVISION));
        Assert.assertTrue(calculatorResult.getInstanceType().contains(MACHINE_TYPE));
        Assert.assertTrue(calculatorResult.getRegion().contains(DATA_CENTER_LOCATION));
        Assert.assertTrue(calculatorResult.getLocalSSD().contains(LOCAL_SSD));
        Assert.assertTrue(calculatorResult.getCommitmentTerm().contains(COMMITTED_USAGE));
        Assert.assertTrue(calculatorResult.getTotalEstimatedCost().contains(TOTAL_COST_EXPECTED));

    }


    @AfterClass(alwaysRun = true, description = "Close browser after tests")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }


}
