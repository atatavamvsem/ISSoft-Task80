import drivers.WebDriverManager;
import org.junit.jupiter.api.*;

import utils.ResourceProperties;

public class DownloadingTest {

    private DownloadDemoPage downloadDemoPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.getInstance().getDriver();
    }

    @Test
    public void loginTest() {
        downloadDemoPage = new DownloadDemoPage();

        downloadDemoPage.downloadScvClick();
        Assertions.assertTrue(downloadDemoPage.isFileDownloaded(ResourceProperties.getDataProperty("csvFile")), "The csv file didn't download");

        downloadDemoPage.downloadPdfClick();
        Assertions.assertTrue(downloadDemoPage.isFileDownloaded(ResourceProperties.getDataProperty("pdfFile")), "The pdf file didn't download");

        downloadDemoPage.downloadExcelClick();
        Assertions.assertTrue(downloadDemoPage.isFileDownloaded(ResourceProperties.getDataProperty("excelFile")), "The excel file didn't download");
    }

    @AfterEach
    public void closeUp() {
        WebDriverManager.getInstance().delDriver();
    }
}