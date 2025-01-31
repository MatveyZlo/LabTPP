package com.example.zadanie7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class MainApp {
    public static final int CARS_COUNT = 17;
    public static final int TUNNEL_CONSTRAINT = 3;
    public static ArrayList<String> winners = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 2 + (int) (Math.random() * 4), cb);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (Car.finishedCars.get() < CARS_COUNT)

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победители:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + " Место: " + winners.get(i));
        }
    }
}
