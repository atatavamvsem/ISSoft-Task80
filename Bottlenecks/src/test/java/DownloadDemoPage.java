import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadDemoPage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'buttons-csv')]")
    private static WebElement downloadScvButton;

    public DownloadDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void downloadScvClick(){
        downloadScvButton.click();
    }

}
