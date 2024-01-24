import java.util.Scanner;

public class Warshall {
    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static void warshall(int[][] p, int n) {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    p[i][j] = max(p[i][j], (p[i][k] & p[k][j]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();
        int[][] p = new int[10][10];
        System.out.println("Enter the end vertices of each edge:");
        for (int i = 1; i <= e; i++) {
            System.out.print("Edge " + i + ": ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            p[u][v] = 1;
        }
        System.out.println("\nMatrix of input data:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(p[i][j] + "\t");
            System.out.println();
        }
        warshall(p, n);
        System.out.println("\nTransitive closure:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(p[i][j] + "\t");
            System.out.println();
        }
        scanner.close();
    }
}