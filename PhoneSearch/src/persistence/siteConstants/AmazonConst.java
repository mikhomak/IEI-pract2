package persistence.siteConstants;

import org.openqa.selenium.By;

public class AmazonConst extends ASiteConst {

    public AmazonConst() {
        url = "https://www.amazon.es";
        titlePath = ".//*[contains(@class, 'Article-title')]";
        pricePath = ".//*[contains(@class, 'userPrice')]";
        manufacturerPath = ".//*[contains(@class, 'data')]";
        itemPath = "//*[contains(@class, 'Article-item js-Search-hashLinkId')]";
        searchPath = "twotabsearchtextbox";
    }



    @Override
    public By getSearchBar() {
        return By.id(searchPath);
    }


}
