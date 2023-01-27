package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Creation_graph {

    public static ArrayList<Integer> BFS(int n,ArrayList<ArrayList<Integer>>adj){
        //TEST_CASE
//        9 9  no of nodes no of edges
//        1 2
//        1 6
//        2 3
//        2 4
//        6 7
//        6 9
//        4 5
//        7 8
//        5 8

        ArrayList<Integer>bfs=new ArrayList<>();
        boolean visit[]=new boolean[n+1];
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        visit[1]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
//            System.out.println(adj.get(node));
            for (int e: adj.get(node)) {
                if (!visit[e]){
                    visit[e]=true;
                    q.add(e);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//no of nodes.
        int m=sc.nextInt();//no of edges.
//        Test-Case
//        5 6// no of nodes no of edges
//        1 2
//        1 3
//        2 4
//        2 5
//        3 4
//        4 5

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

        System.out.println(BFS(n,adj));
    }
}
