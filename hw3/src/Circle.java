public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
        sb = new StringBuilder();
        symbol = new char[radius*2 + 1][(radius*2 + 1)* 3];
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length-1; j++) {
                symbol[i][j] = ' ';
            }
        }
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < symbol[0].length; j=j+3) {
                double d1 = Math.abs(radius - i);
                double d2 = Math.abs(radius - j / 3);
                double distance = Math.sqrt(d1*d1 + d2*d2);
                if (distance <= radius + 0.3) {
                    symbol[i][j + 1] = '*';
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
        return 2 * radius;
    }

    @Override
    public int getHeight() {
        return 2 * radius;
    }

    @Override
    public char[][] getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return sb.toString().replace('\0', ' ');
    }
}
