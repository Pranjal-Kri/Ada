import java.util.Scanner;

public class Floyd {
    static int min(int a, int b) {
        return Math.min(a, b);
    }

    static void floyds(int[][] p, int n) {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (i != j)
                        p[i][j] = min(p[i][j], p[i][k] + p[k][j]);
                    else
                        p[i][j] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();
        int[][] p = new int[10][10];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                p[i][j] = 999; // Initializing with a large value
        System.out.println("Enter the end vertices of each edge with its weight:");
        for (int i = 1; i <= e; i++) {
            System.out.print("Edge " + i + ": ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            p[u][v] = w;
        }
        System.out.println("\nMatrix of input data:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(p[i][j] + "\t");
            System.out.println();
        }
        floyds(p, n);
        System.out.println("\nTransitive closure:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(p[i][j] + "\t");
            System.out.println();
        }
        System.out.println("\nThe shortest paths are:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    System.out.println("<" + i + "," + j + ">=" + p[i][j]);
            }
        }
    }
}