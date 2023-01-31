//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    
    void dfs(int row,int col ,int visited[][],int[][] grid,int row0,int col0,ArrayList<String>ans){
        visited[row][col]=1;
        ans.add(toString(row-row0,col-col0));
        
        int n=grid.length;
        int m=grid[0].length;
        
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                dfs(nrow,ncol,visited,grid,row0,col0,ans);
            }
        }
        
    }
    
    String toString(int i,int j){
        return Integer.toString(i)+ " " +Integer.toString(j);
    }
    
    
    
    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int [n][m];
        
        HashSet<ArrayList<String>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    ArrayList<String>ans=new ArrayList<>();
                    dfs(i,j,visited,grid,i,j,ans);
                    set.add(ans);
                    // set.add(ans.first);
                }
            }
        }
        return set.size();
    }
}
