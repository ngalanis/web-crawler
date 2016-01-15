package com.ngalanis.lib;

import com.ngalanis.model.sites.Site;
import com.ngalanis.model.webs.WebPage;
import com.ngalanis.model.webs.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Site crawler class implementing Runnable for multi-threading support
 *
 * Uses site info in order to check if the <title> tag contains one of the keywords.
 * If it does, the site is saved in a repository.
 *
 * Created by Nikolas Galanis on 12/01/16.
 */
@Service
public class SiteCrawler implements Runnable {

    @Autowired
    WebPageRepository repository;

    private Thread t;
    private Site site;

    public SiteCrawler(Site site) {

        this.site = site;
    }

    /**
     *  Do the "save" transaction. Should be thread-safe
     *
     * @param url
     * @param rank
     */
    @Transactional
    private void saveWebPage(String url, String rank) {
        repository.save(new WebPage(url, rank));
    }

    @Override
    public void run() {
        doCrawlerWork();
    }

    /**
     * Does the web crawling, identifying web pages with the keywords in their title and saving them
     * in the database
     */
    void doCrawlerWork() {
        Boolean keywordFound = false;

        // Get the <title> tag of the html page
        String title = WebOps.getTitleFromUrl(site.getUrl());

        // Parse title for keywords
        if (title.length() > 0) {
            keywordFound = Parser.parseTitleForKeywords(title);
        }

        if (keywordFound) {
            // Save the URL in a DB
            saveWebPage(site.getUrl(), site.getRank());
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, site.getUrl());
            t.start();
        }
    }
}
