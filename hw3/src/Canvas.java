public class Canvas {
    /**
     * Printing settings constants.
     */
    private static final char STAR_SYMBOL = '*';
    private static final char SPACE_SYMBOL = ' ';
    private static final int SPACING_FACTOR = 3;

    private Shape[][] shapes;
    private int height;
    private int width;

    public Canvas(int height, int width) {
        if (height < 0 || width < 0) return;
        this.shapes = new Shape[height][width];
        this.height = height;
        this.width = width;
    }

    /**
     * Calculates the total perimeter of all shapes in the canvas memory
     * @return total perimeter
     */
    public double getTotalPerimeter() {
        double sum = 0;
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (shapes[row][col] != null) {
                    sum += shapes[row][col].perimeter();
                }
            }
        }

        return sum;
    }

    /**
     * Calculates the total area of all shapes in the canvas memory
     * @return total area
     */
    public double getTotalArea() {
        double sum = 0;
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (shapes[row][col] != null) {
                    sum += shapes[row][col].area();
                }
            }
        }

        return sum;
    }

    /**
     * Adds a given shape at the provided index
     * @throws IllegalArgumentException when provided illegal indexes
     */
    public void addShape(Shape shape, int row, int column) {
         if ((0 <= row && row <= height) && (0 <= column && column <= width)){
            this.shapes[row][column] = shape;
         } else {
             throw new IllegalArgumentException("Illegal indexes provided");
         }
    }

    /**
     * Removes the shape at the provided index
     * @throws IllegalArgumentException when provided illegal indexes
     */
    public void removeShape(int row, int column) {
        if ((0 <= row && row <= height) && (0 <= column && column <= width)){
            this.shapes[row][column] = null;
        } else {
            throw new IllegalArgumentException("Illegal indexes provided");
        }
    }
    /**
     * Compares two canvases
     * @return true if the canvases have identical shapes at the same coordinates
     */
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

    /**
     * Prints the canvas in the console
     * @return Formatted string as requested
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char[][] board;
        int start_x;
        for (int row = 0; row < this.height; row++) {
            start_x = 0;
            int height = this.getMaxHeight(row);
            int width = this.calculateWidthForBoard(row);
            int maxWidth = this.getMaxWidth(row);
            board = new char[height][width];
            emptyBoard(board, width, height);

            for (int col = 0; col < this.width; col++) {
                if (this.shapes[row][col] != null) {
                    placeShape(board, this.shapes[row][col].getSymbol(), this.shapes[row][col].getWidth() * SPACING_FACTOR, this.shapes[row][col].getHeight(), start_x);
                    start_x += this.shapes[row][col].getWidth() + SPACING_FACTOR;
                } else {
                    start_x += maxWidth + SPACING_FACTOR;
                }
            }

            for (int i = 0; i < height; i++) {
                sb.append(String.valueOf(board[i]));
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Fills a 2D char array with SPACE_SYMBOL
     * @param board     The 2D array of characters.
     * @param width     The width of the 2D array.
     * @param height     The height of the 2D array.
     */
    private void emptyBoard(char[][] board, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = SPACE_SYMBOL;
            }
        }
    }

    /**
     * Copies drawing 2D array into the specified coordinates of the board 2D array
     * @param board     The destination array.
     * @param drawing     The source array.
     * @param width     The width of the 2D array.
     * @param height     The height of the 2D array.
     * @param start_x     X axis offset.
     */
    private void placeShape(char[][] board, char[][] drawing, int width, int height, int start_x) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[y][x + start_x] = drawing[y][x];
            }
        }
    }

    /**
     * Calculates the required width for a row in the canvas display form.
     * @param row     The row that is being requested.
     * @return returns the required width.
     */
    private int calculateWidthForBoard(int row) {
        int sum = 0;
        int maxWidth = getMaxWidth(row);
        for (int col = 0; col < this.width; col++) {
            if (this.shapes[row][col] != null) {
                sum += this.shapes[row][col].getWidth() * SPACING_FACTOR;
            } else {
                sum += maxWidth;
            }
        }

        sum += (this.width - 1) * SPACING_FACTOR;
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

    /**
     * Finds the maximum width of a shape in the whole canvas.
     * @return returns the maximum width.
     */
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

    /**
     * Finds the maximum width of a shape in the specified row in the canvas.
     * @return returns the maximum width.
     */
    public int getMaxWidth(int row) {
        int max = 0;
        int width;
        for (int col = 0; col < this.width; col++) {
            if (this.shapes[row][col] != null) {
                width = shapes[row][col].getWidth();
                if (width > max) max = width;
            }
        }
        return max * SPACING_FACTOR;
    }

    /**
     * Finds the maximum height of a shape in the specified row in the canvas.
     * @return returns the maximum height.
     */
    public int getMaxHeight(int row) {
        int max = 0;
        int height;
        for (int col = 0; col < this.width; col++) {
            if (this.shapes[row][col] != null) {
                height = this.shapes[row][col].getHeight();
                if (height > max) max = height;
            }
        }
        return max;
    }

}
