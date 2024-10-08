package org.example;

public enum RoadLenght implements Challenge{
    LOW("Короткая дистанция", 1), MEDIUM("Средняя дистанция", 500), HIGH("Длинная дистанция", 75000);

    private final int lenght;
    RoadLenght(String title, int lenght) {

        this.lenght = lenght;
    }

    public boolean isCan(Participant obj){
        return Contest.runContest(obj, lenght);
    }
    public boolean isCon(FishPar obj){
        return Contest.runContest(obj, lenght);
    }
}