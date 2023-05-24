package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 class Pair{
    int node;
    int parent;
    Pair(int first,int second){
        this.node=first;
        this.parent=second;
    }
}

public class Detect_Cycle_UNDIRECTED_graph {
    public static void main(String[] args) {
        //TEST CASE___________
//        first line of input : no of vertices   no of edges
//        7 7
//        1 2
//        1 3
//        2 5
//        3 4
//        3 6
//        5 7
//        6 7
       
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            int u= sc.nextInt();
            int k= sc.nextInt();

            adj.get(u).add(k);
            adj.get(k).add(u);
        }
        System.out.println(hasCycle(adj,V));
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>>adj,int V){
        boolean[] visited =new boolean[V+1];
        for(int i=1;i<=V;i++) visited[i]=false;

        for(int i=1;i<=V;i++){
            if(!visited[i]){
                if(bfs(i,adj,visited)) return true;
            }
        }
        return false;
    }

    public static boolean bfs(int i,ArrayList<ArrayList<Integer>>adj,boolean[] visited){
        visited[i]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,-1));
        while (!q.isEmpty()){
            int N=q.peek().node;
            int P=q.peek().parent;
            q.poll();
            for(int e:adj.get(N)){
                if(!visited[e]){
                    visited[e]=true;
                    q.add(new Pair(e,N));
                }
                else if(P!=e){
                    return true;
                }
            }
        }
        return false;
    }
}
