package persistence;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverChrome implements IDriver {

    private final static String DRIVER_PATH = "drivers/chromedriver78.exe";
    private final static String CHROME_PROPERTY = "webdriver.chrome.driver";
    private final static String ARGUMENTS = "--start-maximized";

    private static WebDriver driver;
    private static DriverChrome instance = null;

    static IDriver getInstance() {
        if (instance == null) {
            instance = new DriverChrome();
        }
        return instance;
    }

    private DriverChrome() {
        System.setProperty(CHROME_PROPERTY, DRIVER_PATH);
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(ARGUMENTS);
        driver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stopDriver(){
        driver.quit();
    }
}
