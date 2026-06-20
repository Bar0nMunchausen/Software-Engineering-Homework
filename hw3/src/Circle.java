public class Circle extends Shape{
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return  Math.PI * (radius * radius);
    }

    public double perimeter() {
        return Math.PI * (radius * 2);
    }

    @Override
    public int getWidth() {
        return 2*radius;
    }

    @Override
    public int getHeight() {
        return 2*radius;
    }

    @Override
    public char[][] getSymbol() {
        symbol = new char[radius][radius+2];

        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                double distance = Math.sqrt((radius-i)*(radius-i)+(radius-j)*(radius-j));
                if(distance <= radius + 0.3) {
                    symbol[i][j] = '*';
                }else{
                    symbol[i][j] = ' ';
                }
            }
        }
        return new char[0][];
    }


}
