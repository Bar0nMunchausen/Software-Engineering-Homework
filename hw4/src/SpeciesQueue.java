import java.util.Iterator;

public class SpeciesQueue <T extends Animal & Comparable<T> & Cloneable>
        implements Iterable<T>, Comparable {

    private Object[] array;
    private int currentSize;
    private static int CAPACITY = 10;

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
    public Object remove() {
        if (currentSize == 0){
            throw new EmptyQueueException();
        }
        Object returnObj = this.array[0];
        for (int i = 1; i < currentSize; i++){
            array[i - 1] = array[i];
        }
        currentSize--;
        return returnObj;
    }
    private void resize() {
        Object[] newArray = new Object[CAPACITY * 2];
        System.arraycopy(this.array, 0, newArray, 0, CAPACITY); //?
        this.array = newArray;
        CAPACITY *= 2;
    }

    public Object peek() {
        if (this.currentSize == 0){
            throw new EmptyQueueException();
        }
        return array[0];
    }

    public int size() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return !(this.currentSize > 0);
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
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

    public class QueueIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext(){
            return cursor < currentSize;
        }

        @Override
        public T next(){
            if (!hasNext()){
                throw new EmptyQueueException();
            }
            return (T) array[cursor++];
        }

        @Override
        public void remove() {
            throw new InvalidInputException();
        }
    }
}
