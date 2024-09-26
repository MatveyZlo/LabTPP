package org.example;

public class Strekoza extends insect {
    private static final int age = 12;

    public static int count = 0;

    public Strekoza(String name, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        count++;
    }
}