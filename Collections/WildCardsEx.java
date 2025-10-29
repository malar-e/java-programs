import java.util.*;

public class WildCardsEx {
    public static void main(String[] args) {
        List<? extends Animal> list = Arrays.asList(new Dog(), new Cat()); // extends wildcard boundary, can add subtype of animal
        Animal a = list.get(0); // can read as animals, but not as subtypes like Dog, Cat
        a.sound();
        // list.add(new Cat()); not allowed to write

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        List<Dog> dog = new ArrayList<>();
        dog.add(dog1);
        dog.add(dog2);
        List<Cat> cat = new ArrayList<>();
        cat.add(cat1);
        cat.add(cat2);
        processAnimals(dog);
        processAnimals(cat);

        List<? super Animal> superList = new ArrayList<>(); // super wildCard boundary, can add animal and its supertypes
        superList.add(new Dog());
        superList.add(new Cat());

        // Animal a = superList.get(0); can't read as animal

        List<Object> objects = new ArrayList<>();
        List<Animal> animal = new ArrayList<>();
        insertAnimals(objects);
        insertAnimals(animal);



    }

    public static void processAnimals (List<? extends Animal> list) { // compiler only knows this is subtype of animal, even though you give list of Dog and Cat
        Animal animal = list.get(0);
        animal.sound();

        for(Animal a : list) {
            a.sound();
        }
    }

    public static void insertAnimals (List<? super Animal> list) {
        list.add(new Dog());
        list.add(new Cat());

        Object obj1 = list.get(0);
        if (obj1 instanceof Dog) {
            ((Dog) obj1).sound();
        } else if (obj1 instanceof Cat) {
            ((Cat) obj1).sound();
        }

        for (Object obj : list) {
            if(obj instanceof Dog) {
                ((Dog) obj).sound();
            } else if (obj instanceof Cat) {
                ((Cat) obj).sound();
            } else if (obj instanceof Animal) {
                ((Animal) obj).sound();
            }
        }
    }

}

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }       
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}