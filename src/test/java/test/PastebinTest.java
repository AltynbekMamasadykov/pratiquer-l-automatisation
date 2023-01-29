package test;
import homepage.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PastebinTest {

    private static final String NAME = "helloweb";
    private static final String EXPIRATION = "10 Minutes";
    private static final String TEXT = "Hello from WebDriver";
    private WebDriver driver;

    @BeforeClass(description = "Create driver and open max size window")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste() {

        PastebinHomePage createNewPaste = new PastebinHomePage(driver)
                .openPage()
                .fillTextForm(TEXT)
                .clickExpirationsDropDown()
                .selectExpiration(EXPIRATION)
                .insertPasteName(NAME)
                .createNewPaste();

    }

    @AfterClass(alwaysRun = true, description = "Close browser after tests")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
