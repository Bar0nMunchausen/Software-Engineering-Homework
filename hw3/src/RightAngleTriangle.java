/**
 * Represents a right angle triangle shape
 * Inherits from the Shape base class and implements its abstract contract.
 */
public class RightAngleTriangle extends Shape {
    private int height;
    private int width;

    public RightAngleTriangle(int width, int height) {
        /**
         * Constructs a right-angle triangle with the given width and height dimensions.
         * Allocates and populates the inner character grid to form the triangular
         *
         * @param width  the base length of the triangle.
         * @param height the vertical height of the triangle.
         * @throws IllegalArgumentException if either the width or height is negative[cite: 85, 93].
         */
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.height = height;
        this.width = width;

        this.symbol = new char[height][width * 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = SPACE_SYMBOL;
            }
        }

        for (int i = 0; i < symbol.length; i++) {
            int starsPerLine = Math.max(1, (int) (((double) (i + 1) * width) / height));
            for (int j = 1; j < starsPerLine * 3; j += 3) {
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

    @Override
    public String toString() {
        /**
         * Generates a formatted string representation of the RightAngleTriangle for console rendering,
         * @return the complete text-based visualization of the RightAngleTriangle.
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[i].length; j++) {
                sb.append(symbol[i][j]);
            }
            if (i < symbol.length) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}