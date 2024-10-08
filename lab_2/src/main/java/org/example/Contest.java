package org.example;

public class Contest {
    static boolean hasSuperRun = true;

    public static boolean jumpContest(Participant actions, int height) {
        if (actions.jump(height)) {
            System.out.printf("'%s' перепрыгнул %s m.\n", actions.getName(), height);
            return true;
        } else {
            hasSuperRun = true;
            System.out.printf("'%s' не смог перепрыгнуть %s m.\n", actions.getName(), height);
            System.out.printf("'%s' выбывает.\n\n", actions.getName());
            return false;
        }
    }

    public static boolean jumpContest(FishPar actions, int height) {
        if (actions.jump(height)) {
            System.out.printf("'%s' перепрыгнул %s m.\n", actions.getName(), height);
            return true;
        } else {
            System.out.printf("'%s' не смог перепрыгнуть %s m.\n", actions.getName(), height);
            System.out.printf("'%s' выбывает.\n\n", actions.getName());
            return false;
        }
    }

    public static boolean runContest(FishPar actions, int dist) {
        System.out.println(actions.getName() + "Рыба не умеет бегать." + dist);
        return false;
    }

    public static boolean runContest(Participant actions, int dist) {
        if (actions.run(dist)) {
            System.out.println(actions.getName() + " пробежал " + dist + " m.");
            return true;
        } else if (((SuperRun) actions).superRun(actions, dist)) {
            return true;
        } else {
            hasSuperRun = true;
            System.out.println(actions.getName() + " не смог пробежать " + dist + " m.");
            System.out.println(actions.getName() + " выбывает.");
            return false;
        }
    }
}


