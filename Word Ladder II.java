//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
         Set<String>set=new HashSet<>();
        for(int i=0;i<wordList.length;i++) set.add(wordList[i]);

        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String>ls=new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String>usedOnLevel=new ArrayList<>();
        usedOnLevel.add(startWord);

        int level=0;
        ArrayList<ArrayList<String>>ans=new ArrayList<>();

        while(!q.isEmpty()){
            ArrayList<String>vec=q.peek();
            q.poll();

            //to remove the element from set which has been used.
            if(vec.size()>level){
                level++;
                for(String e:usedOnLevel){
                    set.remove(e);
                }
            }

            String word=vec.get(vec.size()-1);

            if(word.equals(targetWord)){
                if(ans.size()==0) ans.add(vec);
                else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char original[]=word.toCharArray();
                    original[i]=ch;

                    String newWord=new String(original);
                    if(set.contains(newWord)){
                        vec.add(newWord);
                        
                        //made a temp list ,because java work by refernce
                        ArrayList<String>temp=new ArrayList<>(vec);
                        q.add(temp);

                        //mark as visited on the level
                        usedOnLevel.add(newWord);
                        vec.remove(vec.size()-1);
                        
                    }
                }
            }
        }
        return ans;
        
    }
}
