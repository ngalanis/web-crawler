package com.ngalanis.lib;

import com.ngalanis.controller.WebCrawlerRestController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Contains operations related to web pages
 *
 * Created by Nikolas Galanis on 13/01/16.
 */
@Service
public class WebOps {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerRestController.class);

    /**
     * Returns the value of the <title> tag of the web page at the given URL
     *
     * @param url The URL of the web page
     * @return a String
     */
    @Autowired
    public static String getTitleFromUrl(String url) {
        String title = "";
        try {
            // Get the html page from the URL
            Document doc = Jsoup.connect(url).get();
            // Get page title
            title = doc.title();
        } catch (IOException e) {
            LOGGER.error("Exception while getting web page title: ", e);
        }

        return title;
    }
}
