//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
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

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.size();i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        //System.out.println(adj.get(0));

        int dis[]=new int[n];
        int ways[]=new int[n];

        for(int i=0;i<n;i++){
            dis[i]=(int)1e9;
            ways[i]=0;
        }

        dis[0]=0;
        ways[0]=1;

        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        int mod=(int)(1e9+7);

        while(!pq.isEmpty()){
            int dist=pq.peek().first;
            int node=pq.peek().second;
            pq.poll();

            for(Pair e:adj.get(node)){
               int adjNode=e.first;
               int edw=e.second;

               if(dist+edw<dis[adjNode]){
                   dis[adjNode]=dist+edw;
                   pq.add(new Pair(dist+edw,adjNode));
                   ways[adjNode]=ways[node];
               }

               else if(dist+edw==dis[adjNode]){
                   ways[adjNode]=(ways[adjNode]+ways[node])%mod;
               }
            }
        }
        return ways[n-1]%mod;
    }
}

