package com.ngalanis.model.webs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Defines the repository functionality for storing the marfeelizable web pages
 *
 * Created by Nikolas Galanis on 13/01/16.
 */
@RepositoryRestResource(collectionResourceRel = "webs", path = "webs")
public interface WebPageRepository extends JpaRepository<WebPage, Long> {

    /**
     * Find web page by its URL
     *
     * @param url
     * @return a list of web pages
     */
    List<WebPage> findByUrl(@Param("url") String url);

    /**
     * Find web page by its rank
     *
     * @param rank
     * @return a list of web pages
     */
    List<WebPage> findByRank(@Param("rank") String rank);

}
