package persistence.siteConstants;

import org.openqa.selenium.By;

public interface ISiteConst {
    String getWeb();
    String getUrl();
    String getTitlePath();
    String getPricePath();
    String getManufacturerPath();
    String getItemPath();
    By getSearchBar();
}
