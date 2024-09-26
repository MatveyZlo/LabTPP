package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Animal[] animals = {
                new Cat("Barsik", 200),
                new Cat("Murzik", 200),
                new Dog("Sharik", 500, 200),
                new Tiger("Tigra", 1000, 500),
                new Ant("Матвей", 100, 10),
                new Butterfly("Альфредо", 1, 10),
                new Strekoza("Ландыш", 5, 6)};
        for (Animal a : animals) {
            a.run(10000);
            a.swim(1500);
            System.out.println();
        }
        ((insect) animals[4]).lifespan();
        ((insect) animals[5]).lifespan();
        ((insect) animals[6]).lifespan();
        System.out.println();



        //System.out.println("Средняя продолжительность жизни муравья: " + Ant.count);
        //System.out.println("Средняя продолжительность жизни бабочки: " + Butterfly.count);
        //System.out.println("Средняя продолжительность жизни стрекозы: " + Strekoza.count);

        System.out.println("Cats: " + Cat.count);
        System.out.println("Dogs: " + Dog.count);
        System.out.println("Tigers: " + Tiger.count);
    }
}