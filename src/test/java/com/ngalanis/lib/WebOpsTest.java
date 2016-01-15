package com.ngalanis.lib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nikolas Galanis on 14/01/16.
 */
public class WebOpsTest {

    @Test
    public void testGetTitleFromUrl() {
        String url = "http://www.upc.edu";
        WebOps wo = new WebOps();

        String result = wo.getTitleFromUrl(url);
        assertEquals(result, "UPC. Universitat Politècnica de Catalunya. BarcelonaTech.");
    }
}