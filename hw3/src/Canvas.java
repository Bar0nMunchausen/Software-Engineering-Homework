public class Canvas {

    private Shape[][] shapes;
    private int height;
    private int width;

    public Canvas(int height, int width) {
        this.shapes = new Shape[height][width];
        this.height = height;
        this.width = width;
    }


    public double getTotalPerimeter() {
        double sum = 0;
        for (int row = 0; row < this.height; row++){
            for (int col = 0; col < this.width; col++) {
                sum += shapes[row][col].perimeter();
            }
        }

        return sum;
    }

    public double getTotalArea() {
        double sum = 0;
        for (int row = 0; row < this.height; row++){
            for (int col = 0; col < this.width; col++) {
                sum += shapes[row][col].area();
            }
        }

        return sum;
    }

    public void addShape(Shape shape, int row, int column) {
        this.shapes[row][column] = shape;
    }

    public void removeShape(int row, int column) {
        this.shapes[row][column] = null;
    }

    @Override
    public boolean equals(Canvas other){
        if (this.width != other.getWidth()) return false;
        if (this.height != other.getHeight()) return false;

        for (int row = 0; row < this.height; row++){
            for (int col = 0; col < this.width; col++){
                if (!this.shapes[row][col].equals(other.getShape(row, col))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString(){
        int max_height = 0;
        for (int row = 0; row < this.height; row++){
            max_height = this.getMaxHeight(row);
            for (int col = 0; col < this.width; col++){

            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Shape getShape(int row, int col){
        return this.shapes[row][col];
    }

    public int getMaxWidth(){
        int max = 0;
        int width;
        for (int row = 0; row < this.height; row++){
            for (int col = 0; col < this.width; col++) {
                width = shapes[row][col].getWidth();
                if (width > max) max = width;
            }
        }
        return max * 3;
    }

    public int getMaxHeight(int row){
        int max = 0;
        int height;
        for (int col = 0; col < this.width; col++) {
            height = shapes[row][col].getHeight();
            if (height > max) max = height;
        }
        return max * 3;
    }

}
