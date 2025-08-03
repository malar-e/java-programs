public class EnumWithInterface {
    public static void main(String[] args) {
        Level low = Level.LOW;
        low.print();
        low.age=18;
        System.out.println("name: "+low.name);
        System.out.println("age: "+low.age);
        low.setValue(4);
        System.out.println(low.name+": "+low.getValue());
        System.out.println();

        Level medium = Level.MEDIUM;
        medium.print();
        medium.age=18;
        System.out.println("name: "+medium.name);
        System.out.println("age: "+medium.age);
        medium.setValue(7);
        System.out.println(medium.name+": "+medium.getValue());
        System.out.println();

        System.out.println("=== Static members ===");
        Level.setNumber(6);
        System.out.println("Number: "+Level.getNumber());
    }
}

interface printable {
    void print();
}
enum Level implements printable {
    LOW("Low"), MEDIUM("Medium"), HIGH("High");
    String name;
    int age;
    int value;
    static int number;

    Level (String name){ //always private
        this.name= name;
    }

    void setValue(int value){
        this.value = value;
    }
    int getValue(){
        return value;
    }
    public void print() {
        switch(this){
            case LOW:
                System.out.println("=== Low level ===");
                break;
            case MEDIUM:
                System.out.println("=== Medium level ===");
                break;
            case HIGH:
                System.out.println("=== High level ===");
                break;
        }
    }
    static void setNumber(int n){
        System.out.println("Number: "+number);
        number = n;
    }
    static int getNumber(){
        return number;
    }
}
