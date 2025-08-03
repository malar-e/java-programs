package mypackage;
public class Car {
    String name;
    char category;
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