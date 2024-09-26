package org.example;

public class Ant extends insect{
    private static final int age = 7;

    public static int count = 0;

        public Ant(String name, int maxRunDist, int maxSwimDist) {
            super(name, age, maxRunDist, maxSwimDist);
            count++;
        }
}
