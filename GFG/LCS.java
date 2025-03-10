import java.util.Arrays;

public class LCS {
   
    static int lcs(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        
        
        //Base condition ko use karo pehle 
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
               if(s1.charAt(i-1) == s2.charAt(j-1))
               {
                   dp[i][j]= 1 + dp[i-1][j-1];
               }
               else
               {
                   dp[i][j]=Math.max( dp[i-1][j] , dp[i][j-1]);
               }
           }
       }
        
      return dp[s1.length()][s2.length()];
  }
 static int lcs_Memoization(String s1, String s2) {
     // code here
     int[][] dp=new int[s1.length()][s2.length()];
     for(int[] row : dp)
     {
         Arrays.fill(row , -1);
     }
     return LCS(s1 , s2 , s1.length()-1 , s2.length()-1 ,dp);
 }
 
 
 static int LCS(String s1, String s2,int i1 , int i2 , int[][] dp)
 {
     if(i1<0 || i2<0)
     {
         return 0;
     }
     
     if(dp[i1][i2] != -1)
     {
         return dp[i1][i2];
     }
     if(s1.charAt(i1) == s2.charAt(i2))
     {
        return dp[i1][i2] = 1 +  LCS(s1 , s2 , i1-1 , i2-1 ,dp);
     }
     
     else{
         int a= LCS(s1 , s2 , i1-1 , i2 ,dp);
         int b= LCS(s1 , s2 , i1 , i2-1 , dp);
         return dp[i1][i2] = Math.max(a , b);
     }
     
     
 }
}
