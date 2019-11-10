package persistence.siteConstants;

import org.openqa.selenium.By;

public class AmazonConst extends ASiteConst {

    public AmazonConst() {
        web ="Amazon";
        url = "https://www.amazon.es";
        titlePath = ".//*[contains(@class, 'a-size-medium a-color-base a-text-normal')]";
        pricePath = ".//*[contains(@class, 'a-price-whole')]";
        manufacturerPath = ".//*[contains(@class, 'data')]";
        itemPath = "//*[contains(@class, 's-result-item')]";
        searchPath = "twotabsearchtextbox";
    }



    @Override
    public By getSearchBar() {
        return By.id(searchPath);
    }


}
