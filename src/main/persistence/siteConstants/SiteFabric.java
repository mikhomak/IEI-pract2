package persistence.siteConstants;

import persistence.Sites;

public class SiteFabric {

    public ISiteConst createSite(final Sites site) {
        ISiteConst siteConst = null;
        switch (site) {
            case FNAC:
                siteConst = new FnacConst();
                break;
            case AMAZON:
                siteConst = new AmazonConst();
                break;
            case PCCOMPONENTS:
                siteConst = new PccomponentsConst();
                break;

        }
        return siteConst;
    }
}
