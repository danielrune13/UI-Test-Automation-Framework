package org.uiframework.com.utils;

import java.security.SecureRandom;

public class Randomizer {
    private Randomizer() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateString(int length) {
        return RANDOM.ints('a', 'z' + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Integer generateInteger(int minBound, int maxBound) {
        return RANDOM.nextInt(maxBound - minBound + 1) + minBound;
    }

    public static String generateAlphanumericString(int length) {
        String alphanumericChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        return RANDOM.ints(length, 0, alphanumericChars.length())
                .mapToObj(alphanumericChars::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
