package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Creation_graph {

    public static void main(String[] args) {
        //Test-Case
//        first line of input : no of nodes   no of edges
//        5 6
//        1 2
//        1 3
//        2 4
//        2 5
//        3 4
//        4 5

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//no of nodes.
        int m=sc.nextInt();//no of edges.


       // USING MATRIX---------
//        int adj[][]=new int[n+1][n+1];
//        for(int i=0;i<m;i++){
//            int u= sc.nextInt();
//            int v= sc.nextInt();
//
//            adj[u][v]=1;
//            adj[v][u]=1;
//        }
//
//        for(int i=0;i<=n;i++){
//            for(int j=0;j<=n;j++){
//                System.out.print(adj[i][j]+" ");
//            }
//            System.out.println();
//        }

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u= sc.nextInt();
            int v= sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(adj);
    }
}
