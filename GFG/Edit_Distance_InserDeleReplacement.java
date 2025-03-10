import java.util.Arrays;

public class Edit_Distance_InserDeleReplacement {
  public int editDistance(String s1, String s2) {
         if(s1.equals(s2))
         {
             return 0;
         }
         
        int n = s1.length();
        int m = s2.length();
        
        int[][]dp = new int[n+1][m+1];
         
        for(int i=0;i<=m;i++)
        {
            //if n=0 i.e s1 is 0
            dp[0][i]=i;
        }
        
        for(int i=0;i<=n;i++)
        {
            //if m=0 i.e s2 is 0
            dp[i][0]=i;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {  
                if(s1.charAt(i-1) == s2.charAt(j-1))
               { dp[i][j] = dp[i-1][j-1];}
               else 
               { 
                int insertions = dp[i][j-1];
                int deletions = dp[i-1][j];
                int replacements = dp[i-1][j-1];
                
                dp[i][j] = 1 + Math.min( Math.min(insertions , deletions) , replacements);
                }
            }
        }
        return dp[n][m];
     }
    public int editDistance_Memoizations(String s1, String s2) {
        // Code here
        if(s1.equals(s2))
        {
            return 0;
        }
        
        
        int s1_len = s1.length();
        int s2_len = s2.length();
        
        
        
        int[][]dp = new int[s1_len + 1][s2_len + 1];
        for(int[] rows : dp)
        {
            Arrays.fill(rows , -1);
        }
        
        return LCS(s1 ,s2 ,dp ,s1.length() , s2.length());
    }
    
    private int LCS(String s ,String t ,int[][]dp ,int i ,int j)
    {
        if(i==0)
        {
            //S1 hi zero hogya toh humein j insertions krne padenge
            return j;
        }
        
        if(j==0)
        {
            //S2 hi null hogyi toh humein fir i deletions krne padenge
            return i;
        }
        
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        
        if(s.charAt(i-1) == t.charAt(j-1))
        {
            return dp[i][j] = LCS(s,t,dp,i-1,j-1);
        }
        
        int insertions = LCS(s,t,dp,i,j-1);
        int deletions = LCS(s,t,dp,i-1,j);
        int replacements = LCS(s,t,dp,i-1,j-1);
        
        
        dp[i][j] = 1 + Math.min( Math.min(insertions , deletions) , replacements);
        
        return dp[i][j] ; 
    }
}
