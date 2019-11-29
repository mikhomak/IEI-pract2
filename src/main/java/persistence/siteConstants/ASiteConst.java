package persistence.siteConstants;

public class ASiteConst implements ISiteConst {

    String url;
    String itemPath;
    String titlePath;
    String pricePath;
    String discountPath;
    String web;
    String onlyPhoneSearch;

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
    public String getDiscountPath() {
        return discountPath;
    }

    @Override
    public String getItemPath() {
        return itemPath;
    }

    @Override
    public  String getOnlyPhoneSearch(){ return onlyPhoneSearch; }
}
