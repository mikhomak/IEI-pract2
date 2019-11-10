package persistence.siteConstants;

public class ASiteConst implements ISiteConst {
    String url;
    String itemPath;
    String titlePath;
    String pricePath;
    String manufacturerPath;

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
    public String getManufacturerPath() {
        return manufacturerPath;
    }

    @Override
    public String getItemPath() {
        return itemPath;
    }
}
