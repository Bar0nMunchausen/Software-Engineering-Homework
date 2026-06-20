/**
 * Represents a geometric circle characterized by its radius.
 * Inherits from the Shape base class and implements its abstract contract.
 */
public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative");
        }
        this.radius = radius;
        sb = new StringBuilder();
        symbol = new char[radius * 2 + 1][(radius * 2 + 1) * SPACING_FACTOR];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j++) {
                symbol[i][j] = SPACE_SYMBOL;
            }
        }

        // builds a matrix representation of the circle shape with given radius according to instructions
        // and constructs a StringBuilder containing that matrix
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j = j + SPACING_FACTOR) {
                double d1 = Math.abs(radius - i);
                double d2 = Math.abs(radius - j / SPACING_FACTOR);
                double distance = Math.sqrt(d1 * d1 + d2 * d2);
                if (distance <= radius + 0.3) {
                    symbol[i][j + 1] = STAR_SYMBOL;
                }
            }
            sb.append(String.valueOf(symbol[i]));
            sb.append("\n");
        }
    }

    public double area() {
        return Math.PI * (radius * radius);
    }

    public double perimeter() {
        return Math.PI * (radius * 2);
    }

    @Override
    public int getWidth() {
        return 2 * radius + 1;
    }

    @Override
    public int getHeight() {
        return 2 * radius + 1;
    }

    @Override
    public char[][] getSymbol() {
        return symbol;
    }


    /*
     * Generates a formatted string representation of the circle for console rendering,
     * @return the complete text-based visualization of the circle.
     */
    @Override
    public String toString() {
        return sb.toString().replace('\0', SPACE_SYMBOL);
    }

    /**
     * Compares this Circle to the specified object.
     * The result is true if and only if the object passes the base
     * class checks (is not null and is the exact same class), and has the
     * exact same radius as this Circle.
     *
     * @param obj the object to compare.
     * @return true if the given object represents an identical Circle,
     * false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Circle other = (Circle) obj;
        return this.radius == other.radius;
    }
}
