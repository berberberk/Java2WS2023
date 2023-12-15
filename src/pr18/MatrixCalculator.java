package pr18;

public class MatrixCalculator<T extends Number> {
    public double calculateDeterminant(Matrix<T> matrix) {
        if (!matrix.isSquare()) {
            throw new IllegalArgumentException("Матрица должна быть квадратной для вычисления определителя");
        }
        if (!(matrix.getRows() == 1 || matrix.getRows() == 2)) {
            throw new IllegalArgumentException("Калькулятор определителя не работает с матрицами размера больше чем 2х2!");
        }

        int size = matrix.getRows();
        if (size == 1) {
            return matrix.get(0, 0).doubleValue();
        }

        else {
            T a = matrix.get(0, 0);
            T b = matrix.get(0, 1);
            T c = matrix.get(1, 0);
            T d = matrix.get(1, 1);

            return a.doubleValue() * d.doubleValue() - b.doubleValue() * c.doubleValue();
        }
    }

    public Matrix<Double> multiplyMatrices(Matrix<T> matrix1, Matrix<T> matrix2) {
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new IllegalArgumentException("Несоответствие размеров матриц для умножения");
        }

        int rows = matrix1.getRows();
        int columns = matrix2.getColumns();
        int commonSize = matrix1.getColumns();

        Matrix<Double> resultMatrix = new Matrix<>(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double sum = 0;
                for (int k = 0; k < commonSize; k++) {
                    sum += matrix1.get(i, k).doubleValue() * matrix2.get(k, j).doubleValue();
                }
                resultMatrix.set(i, j, sum);
            }
        }

        return resultMatrix;
    }
}

