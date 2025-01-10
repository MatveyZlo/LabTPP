package org.example;

import java.util.*;

class Telephone {
    private final Map<String, TreeSet<String>> telephone;

    public Telephone() {
        telephone = new TreeMap<>();
    }

    public void add(String surname, String phone) {
        if (telephone.containsKey(surname)) {
            if (telephone.get(surname).contains(phone)) {
                System.out.println("Этот номер уже добавлен для " + surname);
                return;
            }
            telephone.get(surname).add(phone);
        } else {
            TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
            set.add(phone);
            telephone.put(surname, set);
        }
    }

    public void printAll() {
        Set<String> surnames = telephone.keySet();
        for (String name : surnames) {
            TreeSet<String> nums = telephone.get(name);
            StringBuilder sb = new StringBuilder(name + ": ");

            for (String num : nums) {
                sb.append(num).append(", ");
            }

            if (sb.length() > name.length() + 2) {
                sb.setLength(sb.length() - 2);
            }

            System.out.println(sb.toString());
        }
    }

    public Map<String, TreeSet<String>> getTelephone() {
        return telephone;
    }
}
