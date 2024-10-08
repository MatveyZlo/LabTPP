package org.example;

 class Fish implements FishPar {
    int maxHeight;
    String name;


    public Fish(int maxHeight, String name) {
        this.maxHeight = maxHeight;
        this.name = name;

    }
    public String getName() {
        return this.name;
    }


    @Override
    public boolean jump(int height) {
        return height <= maxHeight;

    }

 }