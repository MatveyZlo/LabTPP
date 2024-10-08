package org.example;

public interface SuperRun {
    default boolean superRun(Participant actions, int dist) {
        if (Contest.hasSuperRun == true) {
            System.out.println(actions.getName() + " пробежал с помощью супер-умения " + dist + " m. ");
            Contest.hasSuperRun = false;
            return true;
        }else {
            return false;}
    }
}