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
        long start = System.nanoTime();
        String[][] matrix = new String[n][n];
        int i, j;

        try{
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    int num = (i + j) % n + 1;
                    matrix[i][j] = Integer.toString(num);
                }
            }
        }catch (Exception exp){
            long end = System.nanoTime();
            long time = end-start;
            System.out.println(time);
            return;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Rows:");

        for (i = 0; i < n; i++) {
            String string = "";
            for (j = 0; j < n; j++) {
                string = string.concat(matrix[i][j]);
            }
            System.out.println(string);
        }

        System.out.println("Columns:");

        for (i = 0; i < n; i++) {
            String string = "";
            for (j = 0; j < n; j++) {
                string = string.concat(matrix[j][i]);
            }
            System.out.println(string);
        }




    }


}