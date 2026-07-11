public abstract class Animal implements Comparable<Animal>, Cloneable {
    /**
     * Abstract base class representing an animal
     */
    private final int dominance;
    public final static int LION_DOMINANCE = 4;
    public final static int TIGER_DOMINANCE = 4;
    public final static int MONKEY_DOMINANCE = 3;
    public final static int SNAKE_DOMINANCE = 2;
    public final static int ZEBRA_DOMINANCE = 1;

    /**
     * Initializes the animal with a specific dominance level.
     * @param dominance The dominance level.
     */
    public Animal(int dominance){
        this.dominance = dominance;
    }

    /**
     * Compares this animal with another based on dominance.
     * @param other The animal to compare against.
     * @return Positive if more dominant, negative if less, 0 if equal
     */
    @Override
    public int compareTo(Animal other){
        return this.dominance - other.dominance;
    }

    /**
     * Creates and returns a copy of this animal.
     * @return A copied Animal instance, or null if cloning fails.
     */
    public Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }

    /**
     * Returns the class name as the string
     * @return The animal's type name.
     */
    public String toString(){
        return this.getClass().getName();
    }
}




