package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Telephone telephone = new Telephone();

        telephone.add("Иванов", "123-789");
        telephone.add("Петров", "124-789");
        telephone.add("Сидоров", "555-777");
        telephone.add("Иванов", "111-333");
        telephone.add("Петров", "444-666");
        telephone.add("Сырых", "127-779");
        telephone.add("Борисов", "909-561");
        telephone.add("Злобин", "888-432");
        telephone.add("Субботин", "111-567");
        telephone.add("Рабинович", "767-666");
        telephone.add("Иванов", "123-789");
        telephone.add("Петров", "987-321");

        System.out.println("Все номера телефонов:");
        telephone.printAll();
    }
}
