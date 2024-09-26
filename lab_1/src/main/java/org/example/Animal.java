package org.example;

public abstract class Animal {
    protected String name;
    static int count = 0;
    int maxRunDist;
    int maxSwimDist;

    public Animal(String name, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;
        count++;

    }


    public void run(int RunDist) {
        if (RunDist <= this.maxRunDist) {
            System.out.println(this.name + " пробежал " + RunDist + " метров.");
        }
        else {
            System.out.println(this.name + " не пробежал.");
        }
    }

    public void swim(int swimDist) {
        if (swimDist <= this.maxSwimDist) {
            System.out.println(this.name + " проплыл " + swimDist + " метров.");
        } else {
            System.out.println(this.name + " утонул.");
        }
    }
}