package persistence;

import org.openqa.selenium.WebDriver;

public interface IDriver {

    static IDriver getInstance() {
        return null;
    }

    void stopDriver();

    WebDriver getDriver();
}
