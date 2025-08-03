class Constructors {
    public static void main(String[] args) {
        PublicConstructors pubCons = new PublicConstructors(4);
        ProtectedConstructors proCons = new ProtectedConstructors('c');
        DefaultConstructors defCons = new DefaultConstructors(false);
        PrivateConstructors priCons = PrivateConstructors.getInstance(3.14f);
    }
}
class PublicConstructors {
    int number;
    public PublicConstructors(int number) {
        this.number = number;
        System.out.println("=== Public Constructor ====");
    }

    // Copy Constructors
    public PublicConstructors(PublicConstructors obj) {
        this.number = obj.number;
        System.out.println("=== Copy Constructor ====");
    }

}
class PrivateConstructors {
    float number;
    private PrivateConstructors(float number) {
        this.number = number;
        System.out.println("=== Private Constructor ====");
    }

    //static factory method - a method that returns an instance of a class
    static PrivateConstructors getInstance(float number) {
        return new PrivateConstructors(number);
    }
}
class ProtectedConstructors {
    char character;
    protected ProtectedConstructors(char character) {
        this.character = character;
        System.out.println("=== Protected Constructor ====");
    } 
} // also we can call private constructor from outside of the class using java reflection api, but it is not recommended.
class DefaultConstructors {
    boolean bool;
    DefaultConstructors(boolean bool){
        this.bool = bool;
        System.out.println("=== Default Constructor ====");
    }   
}
