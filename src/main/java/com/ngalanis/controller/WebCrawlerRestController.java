package com.ngalanis.controller;

import com.ngalanis.lib.SiteCrawler;
import com.ngalanis.model.sites.Site;
import com.ngalanis.model.sites.SiteWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nikolas on 11/01/16.
 */
@RestController
public class WebCrawlerRestController {

    @RequestMapping(value = "/webs", method = RequestMethod.POST, consumes = "application/json")
    public void readUrlList(@RequestBody SiteWrapper wrapper) {

        // Create a thread pool equal to the size of the received URLs
        ExecutorService executorService = Executors.newFixedThreadPool(wrapper.getSites().size());

        for (Site site: wrapper.getSites()) {
            System.out.println("Creating crawler for url:" + site.getUrl());
            // Run a crawler thread for each site
            executorService.execute(new SiteCrawler(site));
        }

        // Shut down the executor. Will wait for current threads to finish before doing so.
        executorService.shutdown();
    }
}