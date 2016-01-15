package com.ngalanis.model.webs;

import javax.persistence.*;

/**
 * Created by nikolas on 13/01/16.
 */
@Entity
@Table(name = "webs")
public class WebPage {
    @Id
    @GeneratedValue
    private long id;

    private String url;
    private String rank;

    private WebPage() {}

    public WebPage(String url, String rank) {
        this.url = url;
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format(
                "Web Page [id=%d, url='%s', rank='%s']",
                id, url, rank);
    }
}
