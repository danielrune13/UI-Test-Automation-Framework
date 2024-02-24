package org.hashiro.maven.domain;

public enum UserType {
    STANDARD_USER("Standard User"),
    LOCKED_OUT_USER("Locked out User"),
    PROBLEM_USER("Problem User"),
    PERFORMANCE_GLITCH_USER("Performance Glitch User"),
    ERROR_USER("Error User"),
    VISUAL_USER("Visual User");

    public final String text;

    UserType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

    public static UserType fromString(String text) {
        for (UserType b : UserType.values()) {
            if (b.text.equalsIgnoreCase(text)){
                return b;
            }
        }
        return null;
    }
}
