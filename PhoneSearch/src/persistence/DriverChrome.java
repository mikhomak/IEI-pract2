package persistence;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverChrome {

    private final static String DRIVER_PATH = "B:\\Documents\\Java projects\\IEI pract2\\Selenium\\chromedriver.exe";
    private final static String CHROME_PROPERTY = "webdriver.chrome.driver";
    private final static String ARGUMENTS = "--start-maximized";

    private static WebDriver driver;
    private static DriverChrome instance = null;

    public static DriverChrome getInstance() {
        if (instance == null) {
            instance = new DriverChrome();
        }
        return instance;
    }

    public DriverChrome() {
        System.setProperty(CHROME_PROPERTY, DRIVER_PATH);
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(ARGUMENTS);
        driver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
