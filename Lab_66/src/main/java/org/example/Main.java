package org.example;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int SIZE = 90_000_001;
    static final int HALF = SIZE / 2;
    static final int COUNT_THREAD = 7;

    public static void main(String[] args) {
        float[] first = new float[SIZE];
        Arrays.fill(first, 1.0f);
        long time1 = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            first[i] = (float) (first[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        long elapsedTime1 = System.currentTimeMillis() - time1;
        System.out.println("Время создания массива первым методом: " + (elapsedTime1 / 1000.0) + " секунд");
        System.out.println("Первое число после первого метода : " + first[0]);
        System.out.println("Последнее число после первого метода : " + first[SIZE - 1]);
        System.out.println();

        float[] second = new float[SIZE];
        Arrays.fill(second, 1.0f);

        float[] second_1 = new float[HALF];
        float[] second_2 = new float[HALF];

        long time2 = System.currentTimeMillis();
        System.arraycopy(second, 0, second_1, 0, HALF);
        System.arraycopy(second, HALF, second_2, 0, HALF);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                second_1[i] = (float) (second_1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                second_2[i] = (float) (second_2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) *
                        Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(second_1, 0, second, 0, HALF);
        System.arraycopy(second_2, 0, second, HALF, HALF);

        long elapsedTime2 = System.currentTimeMillis() - time2;
        System.out.println("Время создания массива вторым методом : " + (elapsedTime2 / 1000.0) + " секунд");
        System.out.println("Первое число после второго метода : " + second[0]);
        System.out.println("Последнее число после второго метода : " + second[SIZE - 1]);
        System.out.println();

        float[] individ = new float[SIZE];
        Arrays.fill(individ, 1.0f);
        long timeIndivid = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        float[] lastThreadResults = new float[SIZE / COUNT_THREAD + (SIZE % COUNT_THREAD)];

        for (int i = 0; i < COUNT_THREAD; i++) {
            final int index = i;
            executor.execute(() -> {
                int startIndex = index * (SIZE / COUNT_THREAD);
                int endIndex = (index == COUNT_THREAD - 1) ? SIZE : startIndex + (SIZE / COUNT_THREAD);

                for (int j = startIndex; j < endIndex; j++) {
                    individ[j] = (float) (individ[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                            Math.cos(0.4f + j / 2));
                }

                if (index == COUNT_THREAD - 1) {
                    for (int j = startIndex; j < endIndex; j++) {
                        lastThreadResults[j - startIndex] = individ[j];
                    }
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        lastThreadResults[0] = first[0];

        long elapsedTimeIndivid = System.currentTimeMillis() - timeIndivid;

        System.out.println("Времени потрачено на индивидуальное задание : " + (elapsedTimeIndivid / 1000.0) + " секунд");
        System.out.println("Количество потоков для индивидуального задания : " + COUNT_THREAD);

        System.out.println("Первое число после индивидуального метода : " + individ[0]);
        System.out.println("Последнее число после индивидуального метода : " + individ[SIZE - 1]);
    }
}