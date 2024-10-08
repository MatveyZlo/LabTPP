package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Cat(4, 500, "Kit"),
                new Cat(3, 400, "Biba"),
                new Human(1, 300, "Steve"),
                new Human(3, 250, "Bill"),
                new Robot(11, 600, "Vintik"),
                new Robot(11, 700, "Bender"),
        };

        Challenge[] challenges = {
                RoadLenght.LOW,
                RoadLenght.LOW,
                RoadLenght.LOW,
                RoadLenght.HIGH,
                RoadLenght.LOW,

        };



        for (Participant p : participants) {
            for (Challenge c : challenges) {
                if (!c.isCan(p))
                    break;

            }
        }
        new Fish(5,"Fufa");
    }
}

