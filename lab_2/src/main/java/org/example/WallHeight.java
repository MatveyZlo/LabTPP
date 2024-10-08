package org.example;

public enum WallHeight implements Challenge{
    LOW("Маленькая", 1),MEDIUM("Средняя", 6), HIGH("Высокая", 10);

    private final   int height;
    WallHeight(String title, int height) {

        this.height = height;
    }

    public boolean isCan(Participant obj) {
        return Contest.jumpContest(obj, height);
    }
    public boolean isCon(FishPar obj) {
        return Contest.jumpContest(obj, height);
    }
}