package homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PastebinResultPage {

    private WebDriver driver;

    public PastebinResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//ol[@class='bash']")
    private List<WebElement> resultpageText;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement resultpageNameTitle;

    @FindBy(xpath = "//*[@title='When this paste gets automatically deleted'][1]")
    private WebElement resultpageTime;

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement resultPageSyntaxHighlighter;

    public List<WebElement> getResultpageText() {
        return resultpageText;
    }

    public WebElement getResultpageNameTitle() {
        return resultpageNameTitle;
    }

    public WebElement getResultpageTime() {
        return resultpageTime;
    }

    public WebElement getResultPageSyntaxHighlighter(){
        return resultPageSyntaxHighlighter;
    }

    public String resultPageTextToString(){
        String result = """
                """;
        for (WebElement element:getResultpageText()) {
            result = result + element.getText();
        }
        return result;
    }

}
