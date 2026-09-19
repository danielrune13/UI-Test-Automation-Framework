package org.uiframework.com.utils;

import java.util.List;
import java.util.stream.IntStream;

public class ListUtils {
    private ListUtils() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }

    public static boolean stringListIsSorted(List<String> list, String sortDirection){
        return switch (sortDirection.toLowerCase()){
            case "asc" -> IntStream.range(0, list.size() - 1).allMatch(i -> list.get(i).compareTo(list.get(i + 1)) <= 0);
            case "desc" -> IntStream.range(0, list.size() - 1).allMatch(i -> list.get(i).compareTo(list.get(i + 1)) >= 0);
            default -> throw new IllegalArgumentException("Invalid sort direction");
        };
    }

    public static boolean floatListIsSorted(List<Float> list, String sortDirection){
        return switch (sortDirection.toLowerCase()){
            case "asc" -> IntStream.range(0, list.size() - 1).allMatch(i -> list.get(i) <= list.get(i + 1));
            case "desc" -> IntStream.range(0, list.size() - 1).allMatch(i -> list.get(i) >= list.get(i + 1));
            default -> throw new IllegalArgumentException("Invalid sort direction");
        };
    }
}
