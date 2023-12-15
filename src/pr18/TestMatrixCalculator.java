package pr18;

public class TestMatrixCalculator {
    public static void main(String[] args) {

        Matrix<Integer> matrix1 = new Matrix<>(2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        System.out.println("Первая матрица:");
        matrix1.print();

        MatrixCalculator<Integer> calculator = new MatrixCalculator<>();
        double determinant = calculator.calculateDeterminant(matrix1);
        System.out.println("\nОпределитель первой матрицы: " + determinant);

        Matrix<Integer> matrix2 = new Matrix<>(2, 3);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(0, 2, 7);
        matrix2.set(1, 0, 8);
        matrix2.set(1, 1, 9);
        matrix2.set(1, 2, 10);

        System.out.println("\nВторая матрица:");
        matrix2.print();

        Matrix<Double> resultMatrix = calculator.multiplyMatrices(matrix1, matrix2);
        System.out.println("\nРезультат умножения матриц:");
        resultMatrix.print();
    }
}
