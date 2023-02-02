import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
      int visit[]=new int[n+1];
      int pathVisit[]=new int[n+1];

      ArrayList < ArrayList < Integer >>adj=new ArrayList<>();

      for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
      }

      for(int i=0;i<edges.size();i++){
        adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      }

      for(int i=1;i<=n;i++){
        if(visit[i]==0){
          if(checkCycle(i,adj,visit,pathVisit)) return true;
        }
      }
      return false;
  }

  public static boolean  checkCycle(int i,ArrayList < ArrayList < Integer >>adj,
   int visit[],int pathVisit[]){

     visit[i]=1;
     pathVisit[i]=1;

     for(int e:adj.get(i)){
       if(visit[e]==0){
         if(checkCycle(e,adj,visit,pathVisit)==true) return true;
       }

       else if(pathVisit[e]==1){
         return true;
       }
     }


     pathVisit[i]=0;
     return false;
  }
}
