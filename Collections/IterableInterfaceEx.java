import java.util.*;

public class IterableInterfaceEx {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();
        myCollection.add("Item 1");
        myCollection.add("Item 2");
        myCollection.add("Item 3");

        Iterator<String> iterator = myCollection.iterator();
        System.out.println(myCollection);

        while(iterator.hasNext()) {
            String item = iterator.next();
            if(item.contains("2")) {
                iterator.remove();
            }
        }
        System.out.println(myCollection);

    }
}

class MyCollection<T> implements Iterable<T> {
    private List<T> items = new ArrayList<>();

    void add (T item) {
        items.add(item);
    }

    T get (int index) {
        return items.get(index);
    }

    void remove (int index) {
        items.remove(index);
    }

    public String toString() {
        return items.toString();
    }

    public Iterator<T> iterator() {
        return new MyIterator<T>(items);
    }
}

class MyIterator<T> implements Iterator<T> {
    private List<T> items;
    private int currentIndex = 0;

    MyIterator (List<T> items) {
        this.items = items;
    }

    public boolean hasNext() {
        return currentIndex < items.size();
    }

    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate");
        }
        return items.get(currentIndex++);
    }

    public void remove() {
        if(currentIndex == 0 || currentIndex > items.size()) {
            throw new IllegalStateException("Cannot remove element before calling next()");
        }
        items.remove(--currentIndex);

    }
}