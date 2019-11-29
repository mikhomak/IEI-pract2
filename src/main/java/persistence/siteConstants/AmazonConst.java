package persistence.siteConstants;

public class AmazonConst extends ASiteConst {

    public AmazonConst() {
        web ="Amazon";
        url = "https://www.amazon.es/s?k=";
        titlePath = ".//*[contains(@class, 'a-size-medium a-color-base a-text-normal')]";
        pricePath = ".//*[contains(@class, 'a-price-whole')]";
        itemPath = "//*[contains(@class, 's-result-item sg-col-0-of-12 sg-col-28-of-32 sg-col-16-of-20 sg-col sg-col-32-of-36 sg-col-12-of-16 sg-col-24-of-28')]";
        onlyPhoneSearch = "&rh=n%3A931491031";
    }

}
