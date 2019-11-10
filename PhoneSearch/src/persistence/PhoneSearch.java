package persistence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import persistence.models.PhoneModel;
import persistence.siteConstants.ISiteConst;
import persistence.siteConstants.SiteFabric;

import java.util.ArrayList;
import java.util.List;

public class PhoneSearch implements IPhoneSearch {


    private final SiteFabric siteFabric;


    public PhoneSearch() {
        siteFabric = new SiteFabric();
    }


    public List<PhoneModel> performSearch(final String searchWord, final Sites site) {
        final ISiteConst siteConst = getSiteFabric().createSite(site);
        DriverChrome.getInstance().getDriver().get(siteConst.getUrl());
        getToTheSearchPage(searchWord, siteConst);
        final List<PhoneModel> phoneModels = new ArrayList<>();
        final List<WebElement> phoneElements = getPhoneElements(siteConst);
        phoneElements.forEach(phone -> createPhone(phone, phoneModels, siteConst));
        return phoneModels;
    }

    private void createPhone(final WebElement phone, final List<PhoneModel> phoneModels, final ISiteConst siteConst) {
        final PhoneModel phoneModel = new PhoneModel();
        phoneModel.setName(phone.findElement(By.xpath(siteConst.getTitlePath())).getText());
        phoneModel.setBrand(phone.findElement(By.xpath(siteConst.getManufacturerPath())).getText());
        phoneModel.setPrice(phone.findElement(By.xpath(siteConst.getPricePath())).getText());
        phoneModels.add(phoneModel);
        System.out.println(phoneModel);
    }

    private void getToTheSearchPage(final String searchWord, final ISiteConst siteConst) {
        final WebElement searchBar = DriverChrome.getInstance().getDriver().findElement(siteConst.getSearchBar());
        searchBar.sendKeys(searchWord);
        searchBar.submit();
    }

    private List<WebElement> getPhoneElements(final ISiteConst siteConst) {
        return DriverChrome.getInstance().getDriver().findElements(By.xpath(siteConst.getItemPath()));
    }

    public List<PhoneModel> performSearch(final String searchWord, final List<Sites> sites) {
        final List<PhoneModel> phoneModels = new ArrayList<>();
        sites.forEach(site -> phoneModels.addAll(performSearch(searchWord, site)));
        DriverChrome.getInstance().stopDriver();
        return phoneModels;
    }

    public SiteFabric getSiteFabric() {
        return siteFabric;
    }
}
