package persistence.siteConstants;


public class FnacConst extends ASiteConst {

    public FnacConst() {
        web = "Fnac";
        //url = "https://www.fnac.es/SearchResult/ResultList.aspx?Search=";
        url = "https://www.fnac.es/SearchResult/ResultList.aspx?SCat=8!1%2c8020!2&Search=";
        titlePath = ".//*[contains(@class, 'Article-title')]";
        pricePath = ".//*[contains(@class, 'userPrice')]";
        discountPath = "//*[contains(@class, 'oldPrice')]";
        itemPath = "//*[contains(@class, 'Article-item js-Search-hashLinkId')]";
        onlyPhoneSearch = "&sl";
    }

}
