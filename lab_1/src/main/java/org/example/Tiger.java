package org.example;

public class Tiger extends Animal {
    public static int count = 0;
    public Tiger(String name, int maxRunDist, int maxSwimDist) {
        super(name, maxRunDist, maxSwimDist);
        count++;
    }
}