package persistence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import persistence.models.PhoneModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneSearch implements IPhoneSearch {


    private final static String AMAZON_URL = "https://www.amazon.es/";
    private final static String FNAC_URL = "https://www.fnac.es/";
    private final static String PCCOMPONENTS_URL = "https://www.pccomponentes.com/";

    private final static String SEARCH = "Search";

    private final static String PHONE_SEARCH_CLASS = "//*[contains(@class, 'Article-title')]";

    private final static Map<Sites, String> webPages = new HashMap<>();

    public PhoneSearch() {
        initializeLinks();
    }

    private void initializeLinks() {
        webPages.put(Sites.AMAZON, AMAZON_URL);
        webPages.put(Sites.FNAC, FNAC_URL);
        webPages.put(Sites.PCCOMPONENTS, PCCOMPONENTS_URL);
    }

    public void performSearch() {
        DriverChrome.getInstance().getDriver().get(webPages.get(Sites.FNAC));
        getToTheSearchPage();

        final List<PhoneModel> phoneModels = new ArrayList<>();
        final List<WebElement> phoneElements = getPhoneElements();
        phoneElements.forEach(phone -> createPhone(phone, phoneModels));
        System.out.println(phoneModels);
    }

    private void createPhone(final WebElement phone, final List<PhoneModel> phoneModels) {
        final PhoneModel phoneModel = new PhoneModel();
        phoneModel.setName(phone.getText());
        phoneModels.add(phoneModel);
    }

    private void getToTheSearchPage() {
        final WebElement searchBar = DriverChrome.getInstance().getDriver().findElement(By.name(SEARCH));
        searchBar.sendKeys("xiamoi");
        searchBar.submit();
    }

    private List<WebElement> getPhoneElements() {
        return DriverChrome.getInstance().getDriver().findElements(By.xpath(PHONE_SEARCH_CLASS));
    }

    public void changeSite(final Sites site) {
        DriverChrome.getInstance().getDriver().get(webPages.get(site));
    }
}
