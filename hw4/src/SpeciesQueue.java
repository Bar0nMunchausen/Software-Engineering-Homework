import java.util.Iterator;

public class SpeciesQueue <T extends Animal & Cloneable> implements Iterable<T>{

    private Object[] array;
    private int currentSize;
    private static final int CAPACITY = 10;

    /**
     * init of empty queue with capacity of 10.
     */
    public SpeciesQueue() {
        this.array = new Object[CAPACITY];
        this.currentSize = 0;
    }
    /**
     * Adds an element based on its priority.
     * @param element The animal to add.
     * @throws InvalidInputException if the element is null.
     */
    public void add(T element) {
        if (element == null) {
            throw new InvalidInputException("Species queue element cannot be null");
        }

        if (this.currentSize == this.array.length) {
            resize();
        }

        int insertIndex = 0;
        while (insertIndex < this.currentSize) {
            T current = (T) this.array[insertIndex];
            if (element.compareTo(current) > 0) {
                break;
            }
            if (element.compareTo(current) == 0 && element.getClass() == current.getClass()) {
                break;
            }
            insertIndex++;
        }

        for (int i = this.currentSize; i > insertIndex; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[insertIndex] = element;
        this.currentSize++;
    }
    /**
     * Removes and returns the animal at the front of the queue.
     * @return The front animal.
     * @throws EmptyQueueException If the queue is empty.
     */
    public T remove() {
        if (currentSize == 0){
            throw new EmptyQueueException();
        }
        Object returnObj = this.array[0];
        for (int i = 1; i < currentSize; i++){
            array[i - 1] = array[i];
        }
        currentSize--;
        return (T) returnObj;
    }

    /**
     * Doubles the size of the array when it runs out of space.
     */
    private void resize() {
        Object[] newArray = new Object[this.array.length * 2];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length); //?
        this.array = newArray;
    }

    /**
     * Returns the animal at the front without removing it.
     * @return The front animal.
     * @throws EmptyQueueException If the queue is empty.
     */
    public T peek() {
        if (this.currentSize == 0){
            throw new EmptyQueueException();
        }
        return (T) array[0];
    }

    /**
     * @return the number of animals currently in the queue.
     */
    public int size() {
        return this.currentSize;
    }

    /**
     * @return if the queue is empty.
     */
    public boolean isEmpty() {
        return !(this.currentSize > 0);
    }

    /**
     * Returns an iterator to loop through the queue from start to end.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < currentSize;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }

    public void emptify(){
        this.array = new Object[CAPACITY];
        this.currentSize = 0;
    }

    /**
     * Creates a deep copy of the queue using reflection.
     * Returns null if the cloning fails, without throwing exceptions.
     */
    @Override
    @SuppressWarnings("unchecked")
    public SpeciesQueue<T> clone() {
        try {
            SpeciesQueue<T> clonedQueue = (SpeciesQueue<T>) super.clone();
            clonedQueue.array = new Object[this.array.length];

            for (int i = 0; i < this.currentSize; i++) {
                if (this.array[i] != null) {
                    java.lang.reflect.Method cloneMethod = this.array[i].getClass().getMethod("clone");
                    clonedQueue.array[i] = cloneMethod.invoke(this.array[i]);
                }
            }
            return clonedQueue;
        } catch (Exception e) {
            return null;
        }
    }
}
