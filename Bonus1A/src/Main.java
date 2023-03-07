import java.util.Scanner;

public class Main {

    public static int[][] adjPower(int[][] aMatrix, int power) {
        int n = aMatrix.length;
        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(aMatrix[i], 0, b[i], 0, n);
        }

        for (int i = 2; i <= power; i++) {
            int[][] c = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        c[j][k] += b[j][l] * aMatrix[l][k];
                    }
                }
            }
            for (int m = 0; m < n; m++) {
                System.arraycopy( c[m], 0, b[m], 0, n);
            }

        }

        return b;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int n = 0;
        int power = 0;

        System.out.print("Introdu numarul de noduri:");
        n = keyboard.nextInt();
        System.out.print("Introdu puterea matricei:");
        power = keyboard.nextInt();

        int[][] adjacency = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            adjacency[i][i + 1] = 1;
            adjacency[i + 1][i] = 1;
        }
        adjacency[0][n - 1] = 1;
        adjacency[n - 1][0] = 1;

        int [][] powerAdj = adjPower(adjacency,power);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacency[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(powerAdj[i][j] + " ");
            }
            System.out.println();
        }


    }
}