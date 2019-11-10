package persistence.siteConstants;

public class AmazonConst extends ASiteConst {

    public AmazonConst() {
        url = "https://www.amazon.es";
        titlePath = ".//*[contains(@class, 'Article-title')]";
        pricePath = ".//*[contains(@class, 'userPrice')]";
        manufacturerPath = ".//*[contains(@class, 'data')]";
        itemPath = "//*[contains(@class, 'Article-item js-Search-hashLinkId')]";
    }


}
