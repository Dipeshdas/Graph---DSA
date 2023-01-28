package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_graph {

    public static ArrayList<Integer> BFS(int n, ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer>bfs=new ArrayList<>();
        boolean[] visit =new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
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
        //TEST_CASE
//        first line of input : no of nodes   no of edges
//        9 9
//        1 2
//        1 6
//        2 3
//        2 4
//        6 7
//        6 9
//        4 5
//        7 8
//        5 8

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        System.out.println(BFS(n,adj));
    }
}
