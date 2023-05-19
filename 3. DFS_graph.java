package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_graph {
    public static void DFS(int node, ArrayList<Integer>dfs, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node]=true;
        dfs.add(node);

        for(int e:adj.get(node)) {
            if (!visited[e]) {
                DFS(e, dfs, adj, visited);
            }
        }
    }
    public static void main(String[] args) {
        //TEST_CASE
//        first line of input : no of nodes   no of edges
//        8 8
//        1 2
//        1 3
//        2 5
//        2 6
//        3 4
//        3 7
//        4 8
//        7 8
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer>dfs=new ArrayList<>();
        boolean[] visited =new boolean[n+1];
        DFS(1,dfs,adj,visited);

        System.out.println(dfs);

    }
}
