package persistence.siteConstants;

public class FnacConst extends ASiteConst {

    public FnacConst() {
        url = "https://www.fnac.es";
        titlePath = "//*[contains(@class, 'Article-title')]";
        pricePath = "//*[contains(@class, 'userPrice')]";
        manufacturerPath = "//*[contains(@class, 'data')]";
        itemPath = "//*[contains(@class, 'Article-item')]";
    }
}
