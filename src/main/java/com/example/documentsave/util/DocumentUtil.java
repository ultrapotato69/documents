package com.example.documentsave.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentUtil {
    public DocumentUtil() {
    }

    public static Set<Long> parseCodes(String text) {
        Set<Long> codes = new HashSet<Long>();
        Pattern pattern = Pattern.compile("(\\{)([+-]?\\d*)(\\})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            try {
                codes.add(Long.parseLong(matcher.group(2)));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }

        }
        return codes;
    }
}