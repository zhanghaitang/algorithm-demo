package com.lesson.robinkarp;

public class SubstringMatch {

    public int bruteForce(String source,String target) {

        if (source.length() < target.length()) {
            return -1;
        }

        for (int i = 0; (i + target.length()) <= source.length();i++) {
            int j = 0;
            for (;j < target.length();j++) {
                if (target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }

            if (j == target.length() -1) {
                return i;
            }
        }

        return -1;
    }
}
