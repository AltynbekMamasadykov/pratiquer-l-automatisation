package test;
import org.openqa.selenium.chrome.ChromeOptions;
import page.Yopmail.YopmailHomePage;
import page.Yopmail.YopmailIndex;
import page.cloudCalculator.CloudPricingCalculatorPage;
import page.cloudCalculator.CloudPricingCalculatorResult;
import page.cloudCalculator.EmailEstimateResult;
import page.cloudSearch.CloudSearchPage;
import page.cloudSearch.CloudSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;


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

    private static final String TOTAL_COST_EXPECTED = "Estimated Monthly Cost: USD 1,081.20";


    private WebDriver driver;

    @BeforeClass(description = "Create driver and open max size window")
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void GoogleCloudPricingCalculator() {
        CloudSearchPage cloudSearchPage = new CloudSearchPage(driver);
        CloudSearchResultPage cloudSearchResultPage = new CloudSearchResultPage(driver);
        CloudPricingCalculatorPage cloudPricingCalculatorPage = new CloudPricingCalculatorPage(driver);
        CloudPricingCalculatorResult calculatorResult = new CloudPricingCalculatorResult(driver);
        YopmailHomePage yopmailHomePage = new YopmailHomePage(driver);
        EmailEstimateResult emailEstimateResult = new EmailEstimateResult(driver);
        YopmailIndex yopmailIndex = new YopmailIndex(driver);

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
        calculatorResult.clickEmailEstimateButton();

        driver.switchTo().newWindow(WindowType.TAB);
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());

        yopmailHomePage
                .openPage()
                .clickEmailGenerator()
                .copyToClipBoard();

        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        emailEstimateResult
                .clickToEmailInputField()
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));
        yopmailHomePage.clickCheckInboxButton();

        yopmailIndex.clickRefreshInboxButton();
        driver.switchTo().frame("ifmail");

        String result = yopmailIndex.getTotalEstimatedCost();


        Assert.assertEquals(result,TOTAL_COST_EXPECTED);


    }

    @AfterClass(alwaysRun = true, description = "Close browser after tests")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
