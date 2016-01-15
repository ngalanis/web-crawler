package com.ngalanis.model.sites;

import java.util.List;

/**
 * Created by nikolas on 11/01/16.
 */
public class SiteWrapper {

    private List<Site> sites;

    /**
     * @return the webs
     */
    public List<Site> getSites() {
        return sites;
    }

    /**
     * @param sites The webs to set
     */
    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
