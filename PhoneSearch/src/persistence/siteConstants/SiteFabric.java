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
                break;
            case PCCOMPONENTS:
                break;

        }
        return siteConst;
    }
}
