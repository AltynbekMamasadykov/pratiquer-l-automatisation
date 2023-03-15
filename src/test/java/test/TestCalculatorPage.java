package test;
import org.testng.annotations.Test;
import pages.GoogleCloudSearchPage;
import service.GoogleCloudPricingCalculatorCreator;

public class TestCalculatorPage extends CommonConditions{

    @Test
    public void smokeTestCalculatorPage(){
        GoogleCloudSearchPage googleCloudSearchPage = new GoogleCloudSearchPage(driver);
        googleCloudSearchPage.openPage()
                .searchCalculator()
                .openCalculator()
                .switchToFrame(driver)
                .setEstimate(GoogleCloudPricingCalculatorCreator.withProperty());

    }
}
