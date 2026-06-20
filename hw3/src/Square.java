/**
 * Represents a geometric square with equal sides using super and Rectangle class
 * Inherits from the Rectangle class
 */
public class Square extends Rectangle {
    //constructor to initialize
    public Square(int side) {
        /**
         * Constructs a new Square using Rectangle class
         * Initializes representation of Rectangle as a square
         */
        super(side, side);
    }
}
