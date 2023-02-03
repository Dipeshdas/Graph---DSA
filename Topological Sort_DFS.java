import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        int visit[]=new int[v];
        for(int i=0;i<v;i++){
            if(visit[i]==0){
                dfs(i,visit,adj,st);
            }
        }

        ArrayList<Integer>ans=new ArrayList<>();

        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }

    public static void dfs(int i,int visit[],ArrayList<ArrayList<Integer>>adj,Stack<Integer>st){
        visit[i]=1;

        for(int e:adj.get(i)){
            if(visit[e]==0){
                dfs(e,visit,adj,st);
            }
        }

        st.push(i);
    }
}
