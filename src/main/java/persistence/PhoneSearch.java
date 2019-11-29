package persistence;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import persistence.models.PhoneModel;
import persistence.siteConstants.ISiteConst;
import persistence.siteConstants.SiteFabric;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PhoneSearch implements IPhoneSearch {

    private final SiteFabric siteFabric;

    private String phoneNameLower;

    public PhoneSearch() {
        siteFabric = new SiteFabric();
    }

    public List<PhoneModel> performSearch(final String searchWord, final Sites site) throws UnsupportedEncodingException {
        final ISiteConst siteConst = getSiteFabric().createSite(site);
        getToTheSearchPage(searchWord, siteConst);
        final List<PhoneModel> phoneModels = new ArrayList<>();

        List<WebElement> phoneElements = new ArrayList<>();
        while (phoneElements.isEmpty()) {
            phoneElements = getPhoneElements(siteConst);
            if (phoneElements.isEmpty()) DriverChrome.getInstance().getDriver().navigate().refresh();
        }
        phoneElements.forEach(phone -> createPhone(phone, phoneModels, siteConst));
        return phoneModels;
    }

    private void createPhone(final WebElement phone, final List<PhoneModel> phoneModels, final ISiteConst siteConst) {
        final PhoneModel phoneModel = new PhoneModel();
        Boolean hasGarbage = false;
        phoneModel.setWeb(siteConst.getWeb());
        try {
            phoneModel.setName(phone.findElement(By.xpath(siteConst.getTitlePath())).getText());
        } catch (NoSuchElementException ex) {
            phoneModel.setName("No name");
        }

        phoneNameLower = phoneModel.getName().toLowerCase();

        if(phoneNameLower.contains("funda") || phoneNameLower.contains("case") || phoneNameLower.contains("carcasa")) {
            hasGarbage = true;
        }

        if(!hasGarbage) {
            try {
                String price = phone.findElement(By.xpath(siteConst.getPricePath())).getText().replaceAll(",", ".").replaceAll("[^\\d.]", "");
                phoneModel.setPrice(price);
            } catch (NoSuchElementException ex) {
                phoneModel.setPrice("");
            }

            try {
                String discount = phone.findElement(By.xpath(siteConst.getDiscountPath())).getText().replaceAll(",", ".").replaceAll("[^\\d.]", "");
                System.out.println(discount);
                phoneModel.setDiscount(Double.parseDouble(discount));
            } catch (NoSuchElementException | NumberFormatException en) {
                phoneModel.setDiscount(null);
            }

            phoneModels.add(phoneModel);
            System.out.println(phoneModel);
        }
    }

    private void getToTheSearchPage(final String searchWord, final ISiteConst siteConst) throws UnsupportedEncodingException {
        String url = siteConst.getUrl() + URLEncoder.encode(searchWord, StandardCharsets.UTF_8.toString()) + siteConst.getOnlyPhoneSearch();
        DriverChrome.getInstance().getDriver().get(url);
    }

    private List<WebElement> getPhoneElements(final ISiteConst siteConst) {
        return DriverChrome.getInstance().getDriver().findElements(By.xpath(siteConst.getItemPath()));
    }

    public List<PhoneModel> performSearch(final String searchWord, final List<Sites> sites) {
        final List<PhoneModel> phoneModels = new ArrayList<>();
        sites.forEach(site -> {
            List<PhoneModel> phoneModel = null;
            try {
                phoneModel = performSearch(searchWord, site);
                phoneModels.addAll(phoneModel);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        return phoneModels;
    }

    public SiteFabric getSiteFabric() {
        return siteFabric;
    }
}
