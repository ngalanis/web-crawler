package com.ngalanis.model.sites;

/**
 *  Class representing a web site
 *
 * Created by nikolas on 11/01/16.
 */
public class Site {
    private String url;
    private String rank;

    private Site() {}

    public Site(String url, String rank) {
        setUrl(url);
        setRank(rank);
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    private void setRank(String rank) {
        this.rank = rank;
    }
}
