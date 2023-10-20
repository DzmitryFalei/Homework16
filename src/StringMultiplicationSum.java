import java.util.concurrent.Callable;

public class StringMultiplicationSum implements Callable<Integer> {

    private int matrix[][];
    private int stringMultiplicationSum = 0;
    private int item = 1;

    public StringMultiplicationSum(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                item *= matrix[k][i];
            }
            stringMultiplicationSum += item;
            item = 1;
        }
        return stringMultiplicationSum;
    }
}
