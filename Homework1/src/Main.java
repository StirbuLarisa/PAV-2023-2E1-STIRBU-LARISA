import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int n = 0;
        try {
            n = keyboard.nextInt();
        } catch (Exception e) {
            System.out.println("This is not a number");
            return;
        }
        int[][] matrix = new int[n][n];
        int i, j;

        long start = System.nanoTime();

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                matrix[i][j] = (i + j) % n + 1;
            }
        }

        long end = System.nanoTime();
        long time = end - start;

        if (n > 30000) {
            System.out.println(time);
        } else {
            String matrix1 = "";
            String matrix2 = "";;
            System.out.println("Rows:");

            for (i = 0; i < n; i++) {
                String col = "";
                String row = "";

                for (j = 0; j < n; j++) {
                    row = row.concat(Integer.toString(matrix[i][j]));
                    col = col.concat(Integer.toString(matrix[j][i]));
                }
                matrix1 = matrix1.concat(row + "\n");
                matrix2 = matrix2.concat(col + "\n");

            }
            System.out.println(matrix1);
            System.out.println(matrix2);

        }


    }
}