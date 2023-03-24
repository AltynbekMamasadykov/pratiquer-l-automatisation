package test;
import homepage.PastebinHomePage;
import homepage.PastebinResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PastebinTest {

    private static final String NAME = "how to gain dominance among developers";
    private static final String EXPIRATION = "10 Minutes";
    private static final String SYNTAX_HIGHLIGHTER = "Bash";
    private static final String TEXT = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
    private WebDriver driver;

    @BeforeClass(description = "Create driver and open max size window")
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void createAndCheckNewPaste() {

        PastebinHomePage createAndCheckNewPaste = new PastebinHomePage(driver)
                .openPage()
                .fillTextForm(TEXT)
                .clickSyntaxHighlightingDropDown()
                .selectSyntaxHighlighter(SYNTAX_HIGHLIGHTER)
                .clickExpirationsDropDown()
                .selectExpiration(EXPIRATION)
                .insertPasteName(NAME)
                .createNewPaste();

        PastebinResultPage resultPage = new PastebinResultPage(driver);
        Assert.assertEquals(resultPage.getResultpageNameTitle().getText(), NAME);
        Assert.assertEquals(resultPage.resultPageTextToString(),TEXT);
        Assert.assertEquals(resultPage.getResultpageTime().getText(), "10 MIN");
        Assert.assertEquals(resultPage.getResultPageSyntaxHighlighter().getText(), SYNTAX_HIGHLIGHTER);

    }

    @AfterClass(alwaysRun = true, description = "Close browser after tests")
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
