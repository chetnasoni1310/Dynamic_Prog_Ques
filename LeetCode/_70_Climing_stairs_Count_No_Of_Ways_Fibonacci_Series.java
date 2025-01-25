public class _70_Climing_stairs_Count_No_Of_Ways_Fibonacci_Series{

     //Intuition Nice hai
     public int climbStairs_RECURSIVE_TLE_Exceeded(int n) {
        if(n==0 || n==1)
        {
            return 1;
        }
        int total= climbStairs(n-1) + climbStairs(n-2);
        return total;
    }
    public int climbStairs(int n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
         return dp[n];
    }
  /*  I figured out a better way to explain the Fibonacci solution for this this climbing stairs problem. Personally, I do think it makes more sense.

If we try to reach level n, we either take one step or two step for the last move.
For the one step case, we need to be at the level n - 1, and say we have x1 ways to get level n - 1. For every way of reaching level n - 1, we can only take 1 step at the end to get level n. So, we have x1 ways to reach level n by taking 1 step at the last move.
Similarly, for the two steps case, we need to be at the level n - 2, and say we has x2 ways to get level n - 2. For every way of reaching level n - 2, we can only take 2 stpes at the end to get level n. So, we have x2 ways to reach level n by taking 2 steps at the last move.
Thus, to reach level n, we have x1 + x2 ways.

I hope this make sense to you as well.
//     1-> total 1

// 2 -> total 2
// 1+1
// 2

// 3 -> total 3
// 111
// 12
// 21

// 4->5
// 1111
// 121
// 211
// 112
// 22

// 5->8
// 11111
// 221
// 212
// 122
// 1112
// 1121
// 1211
// 2111

// 0 1 1 2 3 5 8 13 21 */
}