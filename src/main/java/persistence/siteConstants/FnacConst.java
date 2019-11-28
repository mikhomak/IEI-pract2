package persistence.siteConstants;


public class FnacConst extends ASiteConst {

    public FnacConst() {
        web = "Fnac";
        url = "https://www.fnac.es/SearchResult/ResultList.aspx?Search=";
        titlePath = ".//*[contains(@class, 'Article-title')]";
        pricePath = ".//*[contains(@class, 'userPrice')]";
        itemPath = "//*[contains(@class, 'Article-item js-Search-hashLinkId')]";
    }

}
