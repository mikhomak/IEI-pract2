package persistence.siteConstants;

import org.openqa.selenium.By;

public class PccomponentsConst extends ASiteConst {

    public PccomponentsConst() {
        web ="PcComponents";
        url = "https://www.pccomponentes.com/";
        titlePath = ".//*[contains(@class, 'title')]";
        pricePath = ".//*[contains(@class, 'price')]";
        itemPath = "//*[contains(@class, 'ais-Hits-item')]";
        searchPath = "query";
    }

    @Override
    public By getSearchBar() {
        return By.name(searchPath);
    }
}
