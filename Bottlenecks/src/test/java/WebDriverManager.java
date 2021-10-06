import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.download.folderList", 2);
            options.addPreference("browser.download.dir", "C:\\Windows\\temp");
            options.addPreference("browser.download.useDownloadDir", true);
            options.addPreference("browser.download.viewableInternally.enabledTypes", "");
            options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip");
            options.addPreference("pdfjs.disabled", true);
            driver = new FirefoxDriver(options);

            /*// Instructing firefox to use custom download location
            //profile.setPreference("browser.download.folderList", 2);

            // Setting custom download directory
            profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "externalFiles"
                    + File.separator + "downloadFiles" + File.separator);

            // Skipping Save As dialog box for types of files with their MIME
            //profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            //        "text/csv,application/java-archive, csx, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");

            // Creating FirefoxOptions to set profile
            FirefoxOptions option = new FirefoxOptions();
            option.setProfile(profile);

            driver = new FirefoxDriver(option);*/
            //driver = new ChromeDriver();
        }
        return driver;
    }

    public static void delDriver() {
        driver = null;
    }

    /*Map<String, Object> prefs = new HashMap<String, Object>();

    // Use File.separator as it will work on any OS
            prefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "externalFiles" + File.separator + "downloadFiles");

    // Adding cpabilities to ChromeOptions
    ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

    // Printing set download directory
            System.out.println(options.getExperimentalOption("prefs"));

    // Launching browser with desired capabilities
    driver= new ChromeDriver(options);
    //driver = new ChromeDriver();*/
}
