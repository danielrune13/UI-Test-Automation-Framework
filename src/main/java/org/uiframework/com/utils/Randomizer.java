package org.uiframework.com.utils;

import java.security.SecureRandom;

public class Randomizer {

    public static String generateString(int length) {
        return new SecureRandom().ints('a', 'z' + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Integer generateInteger(int minBound, int maxBound) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }

    public static String generateAlphanumericString(int length) {
        String alphanumericChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        return random.ints(length, 0, alphanumericChars.length())
                .mapToObj(alphanumericChars::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
