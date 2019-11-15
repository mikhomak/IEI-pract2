package persistence.siteConstants;

import org.openqa.selenium.By;

public class FnacConst extends ASiteConst {

    public FnacConst() {
        web = "Fnac";
        url = "https://www.fnac.es";
        titlePath = ".//*[contains(@class, 'Article-title')]";
        pricePath = ".//*[contains(@class, 'userPrice')]";
        itemPath = "//*[contains(@class, 'Article-item js-Search-hashLinkId')]";
        searchPath = "Search";
    }


    @Override
    public By getSearchBar() {
        return By.name(searchPath);
    }
}