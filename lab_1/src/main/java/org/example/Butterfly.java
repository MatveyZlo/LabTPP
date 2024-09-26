package org.example;

public class Butterfly extends insect {
    private static final int age = 9;

    public static int count = 0;

    public Butterfly(String name, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist);
        count++;
    }
}
