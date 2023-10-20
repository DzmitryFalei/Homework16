import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3,},{4, 5, 6,},{7, 8, 9,}};
        int columnMS;
        int stringMS;
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(2);
        Future<Integer> columnMultiplicationSum= executor.submit(new ColumnMultiplicationSum(matrix));
        Future<Integer> stringMultiplicationSum= executor.submit(new StringMultiplicationSum(matrix));
        while (true) {
            if (columnMultiplicationSum.isDone() && stringMultiplicationSum.isDone()) {
                try {
                    columnMS = columnMultiplicationSum.get();
                    stringMS = stringMultiplicationSum.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } finally {
                    executor.shutdown();
                }
                break;
            }
        }
        System.out.println(Math.max(columnMS, stringMS));
    }
}
