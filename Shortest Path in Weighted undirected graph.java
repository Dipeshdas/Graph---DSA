//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    
    int first;
    int second;
    Pair(int fst,int scnd){
        this.first=fst;
        this.second=scnd;
    }
}


class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((x,y) -> x.first-y.first);
        
        int dist[]=new int[n+1];
        int parent[]=new int[n+1];
        
        for(int i=1;i<=n;i++){
            dist[i]=(int)1e9;
            parent[i]=i;
        }
        
        dist[1]=0;
        pq.add(new Pair(0,1));
        
        while(pq.size()!=0){
            int dis=pq.peek().first;
            int node=pq.peek().second;
            
            pq.poll();
            
            
            for(Pair e:adj.get(node)){
                int adjNode=e.first;
                int edw=e.second;
                if(dis+edw<dist[adjNode]){
                    dist[adjNode]=dis+edw;
                    pq.add(new Pair(dis+edw,adjNode));
                    parent[adjNode]=node;
                }
            }
        }
        List<Integer>path=new ArrayList<>();
        if(dist[n]==1e9){
            path.add(-1);
            return path;
        }
        
        
        int node=n;
        while(parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
