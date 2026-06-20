/**
 * Represents a generic abstract geometric shape capable of being rendered on a grid.
 * Serves as the base class for all concrete shape implementations.
 */
public abstract class Shape {
    protected char[][] symbol; // char array to represent the shape as a char 2D array
    protected StringBuilder sb; //StringBuilder to represent the shape as a string

    public static final char STAR_SYMBOL = '*';
    public static final char SPACE_SYMBOL = ' ';
    public static final int SPACING_FACTOR = 3;

    // calculate the area of any shape derived from this class
    abstract double area();

    // calculate the perimeter of any shape derived from this class
    abstract double perimeter();

    abstract int getWidth();

    abstract int getHeight();

    abstract char[][] getSymbol();

    @Override
    public abstract String toString();


    /**
     * Compares this Shape to the specified object.
     * The result is true if and only if identical to the specified object
     * or the object passes the base class checks (is not null and is the exact same class).
     *
     * @param obj the object to compare.
     * @return true if the given object represents an identical Shape,
     * false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return true;
    }
}
