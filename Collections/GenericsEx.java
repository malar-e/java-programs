import java.util.Arrays;

public class GenericsEx { // T is object
    public static void main(String[] args) {
        System.out.println("=== Generics Example ===");

        Box<Integer> intBox = new Box<Integer>(10);
        System.out.println("Integer Box contains: " + intBox.getItem());

        Box<String> strBox = new Box<>("Hello");
        System.out.println("String Box contains: " + strBox.getItem());

        Box<int[]> arrayBox = new Box<>(new int[]{1, 2, 3});
        System.out.println("Array Box contains: " + Arrays.toString(arrayBox.getItem()));

        Box<?>[] boxes = new Box<?>[3];
        boxes[0] = new Box<>('C');
        boxes[1] = new Box<>(true);
        boxes[2] = new Box<int[]>(new int[]{1, 2, 3});

        for (Box<?> box : boxes) { // ? - wildcard (unknown type)
            if(box.getItem() instanceof Character) { // box.getItem() is an Object.
                System.out.println("Character Box contains: " + box.getItem());
            } else if (box.getItem() instanceof Boolean) {
                System.out.println("Boolean Box contains: " + box.getItem());
            } else if (box.getItem() instanceof int[]) {
                //box.setItem(new int[]{4, 5, 6}); //wildcard makes the box readonly can't set item.
                @SuppressWarnings("unchecked")
                Box<int[]> intArrayBox = (Box<int[]>) box; // box and intArrayBox refers to the same memory location.
                intArrayBox.setItem(new int[]{4, 5, 6});
                Object item = box.getItem(); 
                System.out.println("Array Box contains: " + Arrays.toString((int[]) item));
            } else {
                System.out.println("Unknown type in Box");
            }
        }

        Box<String> strBox1 = Box.createBox("Hello");
        System.out.println("String Box contains: " + strBox1.getItem());

        Box<int[]> arrayBox1 = Box.createBox(new int[]{1, 2, 3});
        System.out.println("Array Box contains: " + Arrays.toString(arrayBox1.getItem()));

        Integer[] intArray = {1, 2, 3};
        Stats<Integer, String> intStats = new Stats<>(intArray, "Integer Stats");
        System.out.println("Integer Array average: " + intStats.average());
        System.out.println("Stats name: " + intStats.getItem());

        Float[] floatArray = {1.1f, 2.2f, 3.3f};
        Stats<Float, String> floatStats = new Stats<>(floatArray, "Float Stats");
        System.out.println("Float Array average: " + floatStats.average());
        System.out.println("Stats name: " + floatStats.getItem());

    }

}

class Box<T> {
    private T item;

    Box (T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    void setItem(T item) {
        this.item = item;
    }

    public static <T> Box<T> createBox(T item) {
        return new Box<>(item);
    }
}

class Stats<T extends Number, K> { // we can't even use Integer[] for <T>
    T[] nums;
    K item;

    Stats(T[] nums, K item) {
        this.nums = nums;
        this.item = item;
    }

    K getItem() {
        return item;
    }

    double average() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum/nums.length;
    }

}