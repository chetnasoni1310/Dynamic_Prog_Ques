import java.util.Arrays;

public class Min_InsertionsDeletions_toMake_StringA_equal_StringB {
public int minOperations(String s1, String s2) {
        // Your code goes here
        int s1_len = s1.length();
        int s2_len = s2.length();
        
        
        
        int[][]dp = new int[s1_len + 1][s2_len + 1];
        for(int[] rows : dp)
        {
            Arrays.fill(rows , -1);
        }
        
        
        
        int LCS_len = LCS(s1 , s2 ,dp ,s1_len , s2_len);
        
        int deletions = s1_len - LCS_len ;
        int insertions =s2_len - LCS_len ;
        
        return deletions + insertions ;
    }
    
    private int LCS(String s , String t, int[][]dp , int i ,int j)
    {
        if(i==0 || j==0)
        {
            return 0;
        }
        
        if(dp[i][j] != -1)
        {
          return dp[i][j];  
        }
        
        if(s.charAt(i-1) == t.charAt(j-1))
        {
            return dp[i][j] = 1 + LCS(s,t,dp,i-1,j-1);
        }
        
        else
        {
            int sForward = LCS(s,t,dp,i-1,j);
            int tForward = LCS(s,t,dp,i,j-1);
            
            return dp[i][j] = Math.max(tForward , sForward);
        }
     }
}
