import java.util.Iterator;

public class SpeciesQueue <T extends Animal & Comparable<T> & Cloneable>
        implements Iterable<T>,Comparable{

    private Object[] array;
    private int currentSize;
    private static final int CAPACITY = 10;

    public SpeciesQueue() {
        this.array = new Object[CAPACITY];
        this.currentSize = 0;
    }

    public void add(T element) {
        if(element == null){
            throw new InvalidInputException();
        }
        if (this.currentSize == this.array.length) {
            resize();
        }

        currentSize++;
    }
    public void remove() {

        currentSize--;
    }
    private void resize() {
        Object[] newArray = new Object[this.array.length * 2];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length); //?
        this.array = newArray;
    }

    public Object peek() {
        if(this.currentSize == 0){
            throw new EmptyQueueException();
        }
        return array[this.currentSize - 1];
    }
    public int size() {
        return this.currentSize;
    }
    public boolean isEmpty() {
        return (this.currentSize > 0);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void emptify(){
        this.array = new Object[CAPACITY];
        this.currentSize = 0;
    }

    @Override
    public SpeciesQueue clone() {
        try {
            SpeciesQueue clone = (SpeciesQueue) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
