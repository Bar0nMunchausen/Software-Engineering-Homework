public abstract class Shape {
    protected char[][] symbol;
    protected StringBuilder sb;

    abstract double area();
    abstract double perimeter();
    abstract int getWidth();
    abstract int getHeight();
    abstract char[][] getSymbol();
    @Override
    public abstract String toString();

    public boolean equals(Shape other) {
        return this.getClass()== (other.getClass());
    }
}
