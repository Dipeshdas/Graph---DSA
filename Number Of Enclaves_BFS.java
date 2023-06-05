// You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

// Example 1:

// Input:
// grid[][] = {{0, 0, 0, 0},
//             {1, 0, 1, 0},
//             {0, 1, 1, 0},
//             {0, 0, 0, 0}}
// Output:
// 3
// Explanation:
// 0 0 0 0
// 1 0 1 0
// 0 1 1 0
// 0 0 0 0
// The highlighted cells represents the land cells.
// Example 2:

// Input:
// grid[][] = {{0, 0, 0, 1},
//             {0, 1, 1, 0},
//             {0, 1, 1, 0},
//             {0, 0, 0, 1},
//             {0, 1, 1, 0}}
// Output:
// 4
// Explanation:
// 0 0 0 1
// 0 1 1 0
// 0 1 1 0
// 0 0 0 1
// 0 1 1 0
// The highlighted cells represents the land cells.
// Your Task:

// You don't need to print or input anything. Complete the function numberOfEnclaves() which takes a 2D integer matrix grid as the input parameter and returns an integer, denoting the number of land cells.

// Expected Time Complexity: O(n * m)

// Expected Space Complexity: O(n * m)

// Constraints:

// 1 <= n, m <= 500
// grid[i][j] == 0 or 1



//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int x;
    int y;
    Pair(int first,int second){
        this.x=first;
        this.y=second;
    }
}
class Solution {

    int numberOfEnclaves(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int [n][m];
        Queue<Pair>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){//for boundary check
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        visit[i][j]=1;
                    }
                }
            }
        }   
        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};
        
        while(!q.isEmpty()){
            int row=q.peek().x;
            int col=q.peek().y;
            q.poll();
            
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol));
                    visit[nrow][ncol]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
