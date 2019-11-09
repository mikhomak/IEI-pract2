package persistence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class PhoneSearch implements IPhoneSearch {


    private final static String AMAZON_URL ="https://www.amazon.es/";
    private final static String FNAC_URL ="https://www.fnac.es/";
    private final static String PCCOMPONENTS_URL ="https://www.pccomponentes.com/";

    private final static Map<Sites, String> webPages = new HashMap<>();

    public PhoneSearch() {
        initializeLinks();
    }

    private void initializeLinks() {
        webPages.put(Sites.AMAZON, AMAZON_URL);
        webPages.put(Sites.FNAC, FNAC_URL);
        webPages.put(Sites.PCCOMPONENTS, PCCOMPONENTS_URL);
    }

    public void getTheNameOfThePhone() {
        DriverChrome.getInstance().getDriver().get(webPages.get(Sites.FNAC));
        final WebElement searchBar = DriverChrome.getInstance().getDriver().findElement(By.name("Search"));
        searchBar.sendKeys("xiamoi");
        searchBar.submit();

    }

    public void changeSite(final Sites site){
        DriverChrome.getInstance().getDriver().get(webPages.get(site));
    }
}
