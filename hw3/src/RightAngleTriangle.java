/**
 * Represents a right angle triangle shape
 * Inherits from the Shape base class and implements its abstract contract.
 */
public class RightAngleTriangle extends Shape {
    private int height;
    private int width;

    /**
     * Constructs a right-angle triangle with the given width and height dimensions.
     * Allocates and populates the inner character grid to form the triangular
     *
     * @param width  the base length of the triangle.
     * @param height the vertical height of the triangle.
     * @throws IllegalArgumentException if either the width or height is negative[cite: 85, 93].
     */
    public RightAngleTriangle(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.height = height;
        this.width = width;

        this.symbol = new char[height][width * SPACING_FACTOR];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = SPACE_SYMBOL;
            }
        }

        // builds a matrix representation of the triangle shape with given dimensions according to instructions
        // and constructs a StringBuilder containing that matrix
        for (int i = 0; i < symbol.length; i++) {
            int starsPerLine = Math.max(1, (int) (((double) (i + 1) * width) / height));
            for (int j = 1; j < starsPerLine * SPACING_FACTOR; j += 3) {
                symbol[i][j] = STAR_SYMBOL;
            }
        }
    }

    @Override
    double area() {
        return (double) (height * width) / 2;
    }

    @Override
    double perimeter() {
        double hypotenuse = Math.sqrt((height * height) + (width * width));
        return (height + width + hypotenuse);
    }

    @Override
    int getWidth() {
        return width;
    }

    @Override
    int getHeight() {
        return height;
    }

    @Override
    char[][] getSymbol() {
        return symbol;
    }

    /**
     * Generates a formatted string representation of the RightAngleTriangle for console rendering,
     * @return the complete text-based visualization of the RightAngleTriangle.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : symbol) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Compares this RightAngleTriangle to the specified object.
     * The result is true if and only if the object passes the base
     * class checks (is not null and is the exact same class), and has the
     * exact same width and height as this RightAngleTriangle.
     *
     * @param obj the object to compare.
     * @return true if the given object represents an identical RightAngleTriangle,
     * false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        RightAngleTriangle other = (RightAngleTriangle) obj;
        return this.width == other.width && this.height == other.height;
    }
}