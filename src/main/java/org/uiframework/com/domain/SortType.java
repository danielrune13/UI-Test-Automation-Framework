package org.uiframework.com.domain;

public enum SortType {
    NAME_ASC("Name (A to Z)", "asc"),
    NAME_DESC("Name (Z to A)", "desc"),
    PRICE_ASC("Price (low to high)", "asc"),
    PRICE_DESC("Price (high to low)", "desc");

    public final String text;
    public final String direction;

    SortType(final String text, final String direction) {
        this.text = text;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.text;
    }
    public String getDirection() {
        return this.direction;
    }

    public static SortType fromString(String text) {
        for (SortType b : SortType.values()) {
            if (b.text.equalsIgnoreCase(text)){
                return b;
            }
        }
        throw new IllegalArgumentException("Invalid sort type: " + text);
    }
}
