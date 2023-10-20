import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class ColumnMultiplicationSum implements Callable<Integer> {
    private int matrix[][];
    private int columnMultiplicationSum = 0;
    private int item = 1;

    public ColumnMultiplicationSum(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                item *= matrix[i][k];
            }
            columnMultiplicationSum += item;
            item = 1;
        }
        return columnMultiplicationSum;
    }
}
