public class EncapsulationDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("BMW");
        car.setCategory('A');
        System.out.println("Car name is " + car.getName());
        System.out.println("Car category is " + car.getCategory());
        System.out.println(car);
    }
}

class Car {
    private String name;
    private char category;

    String getName() {
        return name;
    }

    void setName(String name) {
        System.out.println("name: " + this.name);
        this.name=name;
    }

    char getCategory() {
        return category;
    }

    void setCategory(char category) {
        System.out.println("category: " + this.category);
        this.category=category;
    }
    
    @Override
    public String toString() {
        return "Car [name=" + name + ", category=" + category + "]";
    }

}