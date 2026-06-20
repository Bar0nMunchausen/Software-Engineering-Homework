/**
 * Represents a generic abstract geometric shape capable of being rendered on a grid.
 * Serves as the base class for all concrete shape implementations.
 */
public abstract class Shape {
    protected char[][] symbol; // char array to represent the shape as a char 2D array
    protected StringBuilder sb; //StringBuilder to represent the shape as a string

    //calculate the area of any shape derived from this class
    abstract double area();

    //calculate the perimeter of any shape derived from this class
    abstract double perimeter();

    abstract int getWidth();

    abstract int getHeight();

    abstract char[][] getSymbol();

    @Override
    public abstract String toString();

    public boolean equals(Shape other) {
        return this.getClass() == (other.getClass());
    }
}
