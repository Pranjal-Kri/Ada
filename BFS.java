import java.util.Scanner;

public class BFS {
    static void bfs(int[][] a, int source, int[] visited, int n) {
        int[] queue = new int[20];
        int f = 0, r = -1;
        queue[++r] = source;

        while (f <= r) {
            int u = queue[f++];
            for (int v = 1; v <= n; v++) {
                if (a[u][v] == 1 && visited[v] == 0) {
                    queue[++r] = v;
                    visited[v] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices:");
        int n = scanner.nextInt();

        int[][] a = new int[20][20];
        int[] visited = new int[20];

        System.out.println("\nEnter the adjacency matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = scanner.nextInt();

        for (int i = 1; i <= n; i++)
            visited[i] = 0;

        System.out.print("\nEnter the source node:");
        int source = scanner.nextInt();
        visited[source] = 1;

        bfs(a, source, visited, n);

        for (int i = 1; i <= n; i++) {
            if (visited[i] != 0)
                System.out.println("\n Node " + i + " is reachable");
            else
                System.out.println("\n Node " + i + " is not reachable");
        }
    }
}
