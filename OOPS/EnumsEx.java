import mypackage.Days;

public class EnumsEx{
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main (String[] args) {
        Level medium = Level.MEDIUM;
        System.out.println(medium.toString());
        System.out.println();
        for (Level level : Level.values()) {
            switch(level) {
                case LOW:
                    System.out.println("Low level");
                    break;
                case MEDIUM:
                    System.out.println("Medium level");
                    break;
                case HIGH:
                    System.out.println("High level");
                    break;
            }
        }

        EnumsEx1 obj = new EnumsEx1();
        obj.accessEnum();
    }
}

enum Fruits {
    APPLE, ORANGE, GRAPES;
    @Override
    public String toString() {
        return "APPLE, ORANGE, GRAPES";
    }
}

class EnumsEx1 {
    void accessEnum() {
        EnumsEx.Level low = EnumsEx.Level.LOW;
        System.out.println("\n" + low);
        Fruits apple = Fruits.APPLE;
        System.out.println(apple);
        Days sunday = Days.SUNDAY;
        System.out.println(sunday);
    }
}