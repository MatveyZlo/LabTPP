package org.example;

public class Cat implements Participant, SuperRun {
    int maxHeight;
    int maxLenght;
    String name;


    public Cat(int maxHeight, int maxLenght, String name) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;

    }
    public String getName() {
        return this.name;
    }

    @Override
    public boolean run(int dist) {
        return dist <= maxLenght;

    }

    @Override
    public boolean jump(int height) {
        return height <= maxHeight;

    }


}