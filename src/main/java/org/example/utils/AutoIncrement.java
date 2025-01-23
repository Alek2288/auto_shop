package org.example.utils;

public class AutoIncrement {
    private static Long id = 0L;

    public static Long getId() {
        return ++id;
    }
}
