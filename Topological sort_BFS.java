//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[V];
        
        for(int i=0;i<V;i++){
            for(int e:adj.get(i)){
                indegree[e]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int ans[]=new int[V];
        int i=0;
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans[i++]=node;
            
            for(int e:adj.get(node)){
                indegree[e]--;
                if(indegree[e]==0) q.add(e);
            }
        }
        return ans;
        
    }
}

//CODE STUDIO
import java.util.*;

public class Solution {

    //TOPO SORT (BFS)-- KHAN'S ALGORITHM
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int l=edges[i][1];

            adj.get(u).add(l);
        }

        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer>ansTopoSort=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ansTopoSort.add(node);

            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode]==0){
                    q.add(adjNode);
                }
            }
        }   
        return ansTopoSort;

    }

    //TOPO SORT DFS--------------

    // public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
    //     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    //     for(int i=0;i<v;i++){
    //         adj.add(new ArrayList<>());
    //     }

    //     for(int i=0;i<edges.length;i++){
    //         int u=edges[i][0];
    //         int l=edges[i][1];

    //         adj.get(u).add(l);
    //     }

    //     List<Integer>ansTopoSort=new ArrayList<>();
    //     Stack<Integer>st=new Stack<>();
    //     int visit[]=new int[v];

    //     for(int i=0;i<v;i++){
    //         if(visit[i]==0){
    //             dfs(i,adj,visit,st);
    //         }
    //     }

    //     while(!st.isEmpty()){
    //         ansTopoSort.add(st.pop());
    //     }
    //     return ansTopoSort;

    // }

    // public static void dfs(int i,ArrayList<ArrayList<Integer>>adj,int visit[],Stack<Integer>st){
    //     visit[i]=1;

    //     for(int adjNode : adj.get(i)){
    //         if(visit[adjNode]==0){
    //             dfs(adjNode,adj,visit,st);
    //         }
    //     }
    //     st.push(i);
    // }
}
