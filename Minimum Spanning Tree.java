//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int wt=edges[i][2];
	        
	        ArrayList<Integer>temp1=new ArrayList<>();
	        ArrayList<Integer>temp2=new ArrayList<>();
	        
	        temp1.add(v);
	        temp1.add(wt);
	        
	        temp2.add(u);
	        temp2.add(wt);
	        
	        adj.get(u).add(temp1);
	        adj.get(v).add(temp2);
	    }
	    
	    
	    PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.first-y.first);
	    //(wt,node)
	    pq.add(new Pair(0,0));
	    
	    int visit[]=new int[V];
	    
	    int sum=0;
	    while(!pq.isEmpty()){
	        int node=pq.peek().second;
	        int wt=pq.peek().first;
	        pq.poll();
	        
	        if(visit[node]==1) continue;
	        
	        visit[node]=1;
	        sum+=wt;
	        
	        for(int i=0;i<adj.get(node).size();i++){
	            int adjNode=adj.get(node).get(i).get(0);
	            int edWt=adj.get(node).get(i).get(1);
	            
	            if(visit[adjNode]==0){
	                pq.add(new Pair(edWt,adjNode));
	            }
	        }
	    }
	    return sum;
	}
}
