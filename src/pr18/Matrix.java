package pr18;

public class Matrix<T> {
    private T[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = (T[][]) new Object[rows][columns];
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public T get(int row, int column) {
        return data[row][column];
    }
    public void set(int row, int column, T value) {
        data[row][column] = value;
    }
    public boolean isSquare() {
        return this.rows == this.columns;
    }
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
