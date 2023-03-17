package test;
import org.testng.annotations.Test;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudSearchPage;
import pages.YopmailHandler;
import service.GoogleCloudPricingCalculatorCreator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FrameworkTest extends CommonConditions{


    @Test
    public void fullFrameworkTest() {
        GoogleCloudSearchPage googleCloudSearchPage = new GoogleCloudSearchPage(driver);

        googleCloudSearchPage.openPage()
                .searchCalculator()
                .openCalculator()
                .setEstimate(GoogleCloudPricingCalculatorCreator.withProperty())
                .emailEstimate()
                .getNewYopmail()
                .sendEmail(driver);

        YopmailHandler yopmailHandler = new YopmailHandler(driver);
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver);

        assertThat(calculatorPage.getTotalEstimatedCost(), is(equalTo(yopmailHandler.checkAndGetResult(driver))));

    }

}
