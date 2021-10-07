import drivers.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DownloadDemoPage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'buttons-csv')]")
    private static WebElement downloadScvButton;

    @FindBy(xpath = "//a[contains(@class,'buttons-pdf')]")
    private static WebElement downloadPdfButton;

    @FindBy(xpath = "//a[contains(@class,'buttons-excel')]")
    private static WebElement downloadExcelButton;

    public DownloadDemoPage() {
        this.driver = WebDriverManager.getInstance().getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
        PageFactory.initElements(driver, this);
    }

    public void downloadScvClick() {
        downloadScvButton.click();
    }

    public void downloadPdfClick() {
        downloadPdfButton.click();
    }

    public void downloadExcelClick() {
        downloadExcelButton.click();
    }

    public boolean isFileDownloaded(String fileName) {
        try {
            new WebDriverWait(driver, 30).until(filePresent(fileName));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private ExpectedCondition<Boolean> filePresent(String fileName) {
        return condition -> {
            File f = new File(String.format("%s%s%s", WebDriverManager.getDownloadDirectory(), File.separator, fileName));
            return f.exists();
        };
    }
}
