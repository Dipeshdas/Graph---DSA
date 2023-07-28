// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

// Example 1:

// Input: 
// N = 5, K = 4
// dict = {"baa","abcd","abca","cab","cad"}
// Output:
// 1
// Explanation:
// Here order of characters is 
// 'b', 'd', 'a', 'c' Note that words are sorted 
// and in the given language "baa" comes before 
// "abcd", therefore 'b' is before 'a' in output.
// Similarly we can find other orders.
// Example 2:

// Input: 
// N = 3, K = 3
// dict = {"caa","aaa","aab"}
// Output:
// 1
// Explanation:
// Here order of characters is
// 'c', 'a', 'b' Note that words are sorted
// and in the given language "caa" comes before
// "aaa", therefore 'c' is before 'a' in output.
// Similarly we can find other orders.


//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        
       for(int i=0;i<N-1;i++){
           String s1=dict[i];
           String s2=dict[i+1];
           
           int len=Math.min(s1.length(),s2.length());
           for(int j=0;j<len;j++){
               if(s1.charAt(j)!=s2.charAt(j)) {
                   adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                   break;
               }
           }
       }
        ArrayList<Integer> topo=bfsTopo(K,adj);
        String ans="";
        for(int e: topo){
            ans=ans+(char)(e+(int)('a'));
        }
        return ans;
        
    }
    
    public ArrayList<Integer> bfsTopo(int k,ArrayList<ArrayList<Integer>>adj){
        int []indegree=new int[k];
        
        for(int i=0;i<k;i++){
            for(int e:adj.get(i)){
                indegree[e]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        ArrayList<Integer>topo=new ArrayList<>();
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            
            for(int e:adj.get(node)){
                indegree[e]--;
                if(indegree[e]==0) q.add(e);
            }
        }
        return topo;
        
        
    }
    
}






////CODE STUDIO

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public static char[] getAlienLanguage(int n, String[] dictionary) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<dictionary[i].length();j++){
                set.add(dictionary[i].charAt(j));
            }
        }

        int V=set.size();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
       for(int i=0;i<n-1;i++){
           String s1=dictionary[i];
           String s2=dictionary[i+1];
           
           int len=Math.min(s1.length(),s2.length());
           for(int j=0;j<len;j++){
               if(s1.charAt(j)!=s2.charAt(j)) {
                   adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                   break;
               }
           }
       }
        ArrayList<Integer> topo=bfsTopo(V,adj);
        String ans="";
        for(int e: topo){
            ans=ans+(char)(e+(int)('a'));
        }
        return ans.toCharArray();
    }

    public static ArrayList<Integer> bfsTopo(int n,ArrayList<ArrayList<Integer>>adj){
        int []indegree=new int[n];
        
        for(int i=0;i<n;i++){
            for(int e:adj.get(i)){
                indegree[e]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        ArrayList<Integer>topo=new ArrayList<>();
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            
            for(int e:adj.get(node)){
                indegree[e]--;
                if(indegree[e]==0) q.add(e);
            }
        }
        return topo;
    }
}

