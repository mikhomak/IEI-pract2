package persistence.siteConstants;

public class PccomponentsConst extends ASiteConst {

    public PccomponentsConst() {
        web ="PcComponents";
        url = "https://www.pccomponentes.com/buscar/?query=";
        titlePath = ".//a[contains(@class, 'enlace-disimulado')]";
        pricePath = ".//*[contains(@class, 'tarjeta-articulo__precio-actual')]";
        itemPath = "//article[contains(@class, 'tarjeta-articulo')]";
        // #pg-0&or-relevance better results
    }

}
