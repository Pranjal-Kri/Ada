import java.util.Scanner;

public class DFS {
    static int n, count = 0;
    static int[][] a;
    static int[] v;

    public static void dfs(int x) {
        count++;
        v[x] = count;
        if (v[x] != 0)
            System.out.print(x + "\t");

        for (int k = 1; k <= n; k++)
            if (a[x][k] == 1 && v[k] == 0)
                dfs(k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter no. of Nodes: ");
        n = sc.nextInt();

        a = new int[10][10];
        v = new int[10];

        System.out.println("\nEnter the Adjacency Matrix:-");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();

        for (int i = 1; i <= n; i++)
            v[i] = 0;

        System.out.print("\nDFS:\t");
        for (int i = 1; i <= n; i++)
            if (v[i] == 0)
                dfs(i);

        System.out.println();
    }
}
