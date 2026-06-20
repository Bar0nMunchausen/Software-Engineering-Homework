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
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (shapes[row][col] != null){
                    sum += shapes[row][col].perimeter();
                }
            }
        }

        return sum;
    }

    public double getTotalArea() {
        double sum = 0;
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (shapes[row][col] != null){
                    sum += shapes[row][col].area();
                }
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

    public boolean equals(Canvas other) {
        if (other == null) return false;
        if (this.width != other.getWidth()) return false;
        if (this.height != other.getHeight()) return false;
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                Shape thisShape = this.shapes[row][col];
                Shape otherShape = other.getShape(row, col);
                if ((thisShape == null && otherShape != null) || (thisShape != null && otherShape == null)) {
                    return false;
                }
                if (thisShape != null && !thisShape.equals(otherShape)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char[][] board;
        int start_x;
        for (int row = 0; row < this.height; row++){
            start_x = 0;
            int height = this.getMaxHeight(row);
            int width = this.calculateWidthForBoard(row);
            int maxWidth = this.getMaxWidth(row);
            board = new char[height][width];
            emptyBoard(board, width, height);

            for (int col = 0; col < this.width; col++){
                if (this.shapes[row][col] != null){
                    placeShape(board, this.shapes[row][col].getSymbol(), this.shapes[row][col].getWidth() * 3, this.shapes[row][col].getHeight(), start_x);
                    start_x += this.shapes[row][col].getWidth() + 3;
                } else {
                    start_x += maxWidth + 3;
                }
            }

            for (int i = 0; i < height; i++){
                sb.append(String.valueOf(board[i]));
                sb.append("\n");
            }
            sb.append("\n");
            start_x = 0;
        }

        return sb.toString();
    }

    private void emptyBoard(char[][] board, int width, int height){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                board[i][j] = ' ';
            }
        }
    }

    private void placeShape(char[][] board, char[][] drawing, int width, int height, int start_x){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                board[y][x + start_x] = drawing[y][x];
            }
        }
    }

    private int calculateWidthForBoard(int row){
        int sum = 0;
        int maxWidth = getMaxWidth(row);
        for (int col = 0; col < this.width; col++){
            if (this.shapes[row][col] != null){
                sum += this.shapes[row][col].getWidth() * 3;
            } else {
                sum += maxWidth * 3;
            }
        }

        sum += (this.width - 1) * 3;
        return sum;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Shape getShape(int row, int col) {
        return this.shapes[row][col];
    }

    public int getMaxWidth() {
        int max = 0;
        int width;
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                width = shapes[row][col].getWidth();
                if (width > max) max = width;
            }
        }
        return max;
    }

    public int getMaxWidth(int row){
        int max = 0;
        int width;
        for (int col = 0; col < this.width; col++) {
            if (this.shapes[row][col] != null) {
                width = shapes[row][col].getWidth();
                if (width > max) max = width;
            }
        }
        return max;
    }

    public int getMaxHeight(int row) {
        int max = 0;
        int height;
        for (int col = 0; col < this.width; col++) {
            if (this.shapes[row][col] != null){
                height = this.shapes[row][col].getHeight();
                if (height > max) max = height;
            }
        }
        return max;
    }

}
