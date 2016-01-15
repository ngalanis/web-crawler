package com.ngalanis.lib;

import com.ngalanis.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Parser class.
 * Contains operations for parsing web page contents
 *
 * Created by Nikolas Galanis on 13/01/16.
 */
@Service
public class Parser {

    /**
     * Checks if the title string contains one of the keywords defined in Consts.TITLE_KEYWORDS
     *
     * @param title the web pag title to examine
     * @return true if the title contains the keyword. False if not
     */
    @Autowired
    public static boolean parseTitleForKeywords(String title) {
        for (Consts.TITLE_KEYWORDS keyword : Consts.TITLE_KEYWORDS.values()) {
            if (title.toLowerCase().contains(keyword.toString().toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
