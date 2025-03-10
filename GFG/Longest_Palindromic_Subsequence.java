public class Longest_Palindromic_Subsequence {
    public int longestPalinSubseq(String s) {
        // code here
        String rev = new StringBuilder(s).reverse().toString();
        return LCS(rev ,s);
    }
    
    private int LCS(String s , String rev)
    {
        int[][] dp= new int[s.length() +1][rev.length() +1];
        
         for(int i=0;i<dp.length;i++)
           {
               dp[i][0]=0;
           }
            for(int i=0;i<dp[0].length;i++)
           {
               dp[0][i]=0;
           }
           
           
           //fir ghumao apne hisaab se 
          for(int i=1;i<dp.length;i++)
          {
              for(int j=1;j<dp[0].length;j++)
              {
                  if(s.charAt(i-1) == rev.charAt(j-1))
                  {
                      dp[i][j]= 1 + dp[i-1][j-1];
                  }
                  else
                  {
                      dp[i][j]=Math.max( dp[i-1][j] , dp[i][j-1]);
                  }
              }
          }
           
         return dp[s.length()][rev.length()];
    }
}
