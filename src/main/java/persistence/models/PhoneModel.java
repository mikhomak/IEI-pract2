package persistence.models;

public class PhoneModel {
    private String name;
    private String price;
    private String web;
    private Double discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        String info = web + " : " + name + " " + price + "\u20ac";
        if (discount != null) {
            info += " (" + discount + "\u20ac)";
        }
        return info;
    }
}
