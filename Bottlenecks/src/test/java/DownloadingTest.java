import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DownloadingTest {
    private WebDriver driver;

    private DownloadDemoPage downloadDemoPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverManager.getInstance();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
    }

    @Test
    public void loginTest() {
        downloadDemoPage = new DownloadDemoPage(driver);
        downloadDemoPage.downloadScvClick();

        WebDriverWait wait = new WebDriverWait(driver,30);


        wait.until(condition -> {
            File f = new File("D:\\new\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.csv");
            return f.exists();
        });
        System.out.println("d");
    }
    public ExpectedCondition<Boolean> filepresent() {
        return condition -> {
            File f = new File("D:\\new\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.csv");
            return f.exists();
        };
    }

    @AfterEach
    public void closeUp() {
        driver.quit();
        WebDriverManager.delDriver();
    }
}