package persistence.siteConstants;

import org.openqa.selenium.By;

public class ASiteConst implements ISiteConst {
    String url;
    String itemPath;
    String titlePath;
    String pricePath;
    String searchPath;
    String web;

    @Override
    public String getWeb() {
        return web;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getTitlePath() {
        return titlePath;
    }

    @Override
    public String getPricePath() {
        return pricePath;
    }

    @Override
    public String getItemPath() {
        return itemPath;
    }

    @Override
    public By getSearchBar() {
        return null;
    }
}
