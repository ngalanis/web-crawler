package com.ngalanis.lib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nikolas Galanis on 14/01/16.
 */
public class ParserTest {
    String[] titles = new String[]{
        "These are the News of the day",
        "These are the news of the day",
        "These are the neWs of the day",
        "These are the NEWS of the day",
        "Estas son las noticias del día",
        "Estas son las Noticias del día",
        "Estas son las noTicias del día",
        "Estas son las NOTICIAS del día",
        "news",
        "noticias"
    };

    String title1 = "These are the events of the day";

    Parser parser = new Parser();

    @Test
    public void testParser() {
        for (String title : titles) {
            assertEquals(true, parser.parseTitleForKeywords(title));
        }
        assertEquals(false, parser.parseTitleForKeywords(title1));
    }
}