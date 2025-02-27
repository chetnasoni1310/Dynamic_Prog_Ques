public class Climbing_Stairs {
    int countWays(int n) {

        // your code here
         if(n==0)
        return 0;
        if(n==1)
        return 1;

       int[]dp = new int[n+1];
     
       return Tabulation_DP(  n , dp);
 
      }

        private int Tabulation_DP( int up , int[]dp)
        {
          dp[0]=1;
          dp[1]=1;
           
         for(int i=2 ; i<=up;i++)
         { 
            dp[i] = dp[i-1] + dp[i-2];
         }

            return dp[up];
    }
}
