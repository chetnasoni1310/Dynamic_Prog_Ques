public class Prining_all_LCS_Sequences {

    
    
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
         Map<String , List<String>> memoization= new HashMap<>();
         int[][]dp = dpArray(s , t);
        
         
         
         return backtrack(dp , memoization ,"", s ,t , dp.length-1 , dp[0].length-1);
        }
        
        private List<String>  backtrack(int[][]dp,  Map<String , List<String>> memoization,
                                        String str ,String s,String t,int i,int j)
        {
            
            if(i==0 || j==0)
            {      //Base Case
               
                return Collections.singletonList( str );
            }
            
            String key = i+ "," + j+ "," + str;
            
            if(memoization.containsKey(key))
            {
                return memoization.get(key);
            }
            
             // Use TreeSet to keep results sorted
            Set<String> resultSet = new TreeSet<>();
            
            
            // if(s.charAt(i-1) == t.charAt(j-1))
            // {  
            //   //Agar value character ki equal hui toh diagonally move karenge   
    
            //   resultSet.addAll(backtrack(dp,memoization, s.charAt(i - 1) + str,s,t,i-1,j-1));    
              
            // }
            
            // else if( dp[i-1][j] > dp[i][j-1])
            // {
            //     // agar up wala bada hua left wale se toh up jaayenge
            //       resultSet.addAll(backtrack(dp,memoization,str,s,t,i-1,j));    
            // }
            //  else if( dp[i-1][j] < dp[i][j-1])
            // {
            //     // agar up wala bada hua left wale se toh up jaayenge
            //       resultSet.addAll(backtrack(dp,memoization,str,s,t,i,j-1));    
            // }
            
            // else
            // {
            //     //Agar dono barabar hai toh pehle up then backtrack krke left jaayenge
            //       resultSet.addAll(backtrack(dp,memoization,str,s,t,i-1,j));  
               
            //       resultSet.addAll(backtrack(dp,memoization,str,s,t,i,j-1));
            // }
            
            
               if (s.charAt(i - 1) == t.charAt(j - 1)) {
                resultSet.addAll(backtrack(dp, memoization, s.charAt(i - 1) + str, s, t, i - 1, j - 1));
            } else {
                if (dp[i - 1][j] == dp[i][j - 1]) {
                    // Move both up and left if values are equal
                    resultSet.addAll(backtrack(dp, memoization, str, s, t, i - 1, j));
                    resultSet.addAll(backtrack(dp, memoization, str, s, t, i, j - 1));
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    resultSet.addAll(backtrack(dp, memoization, str, s, t, i - 1, j));
                } else {
                    resultSet.addAll(backtrack(dp, memoization, str, s, t, i, j - 1));
                }
            }
            
            List<String> resultList = new ArrayList<>(resultSet);
            memoization.put(key, resultList);
            return resultList;
        }
        
        private  int[][] dpArray(String a, String b)
        {
           int[][]dp = new int[a.length() +1][b.length() +1];
           
           for(int i=0;i<dp.length;i++)
           {
               dp[i][0] = 0;
           }
           
           
            for(int i=0;i<dp[0].length;i++)
           {
               dp[0][i] = 0;
           }
           
           
           for(int i=1;i<dp.length;i++)
           {
               for(int j=1 ;j<dp[0].length ; j++)
               {
                   if(a.charAt(i-1) == b.charAt(j-1))
                   {
                    dp[i][j] = 1 + dp[i-1][j-1];   
                   }
                   else
                   {
                       int up  = dp[i-1][j];
                       int down= dp[i][j-1];
                       
                       dp[i][j] = Math.max(up , down);
                   }
               }
           }
           return dp;
        }
        
        
        
          //             *************************** TLE ERROR **********************
        
        
      /*  public List<String> all_longest_common_subsequences(String s, String t) {
            // Code here
             Set<String> set= new TreeSet<>();
             int[][]dp = dpArray(s , t);
             StringBuilder str=new StringBuilder("");
             backtrack(dp , set ,str, s ,t , dp.length-1 , dp[0].length-1);
             
             
             return new ArrayList<>(set);
             
        }
        
        private void backtrack(int[][]dp,Set<String>set,StringBuilder str ,
                                        String s,String t,int i,int j)
        {
            
            if(i==0 || j==0)
            {      //Base Case
                set.add(new StringBuilder(str).reverse().toString());
                return ;
            }
            
            
            if(s.charAt(i-1) == t.charAt(j-1))
            {  
              //Agar value character ki equal hui toh diagonally move karenge    
               str.append( s.charAt(i-1) ) ;  
               backtrack(dp,set,str,s,t,i-1,j-1);    
               str.deleteCharAt( str.length() - 1 ) ;  
            }
            
            else if( dp[i-1][j] > dp[i][j-1])
            {
                // agar up wala bada hua left wale se toh up jaayenge
                 backtrack(dp,set,str,s,t,i-1,j);    
            }
             else if( dp[i-1][j] < dp[i][j-1])
            {
                // agar up wala bada hua left wale se toh up jaayenge
                 backtrack(dp,set,str,s,t,i,j-1);    
            }
            
            else
            {
                //Agar dono barabar hai toh pehle up then backtrack krke left jaayenge
                 backtrack(dp,set,str,s,t,i-1,j);  
               
                 backtrack(dp,set,str,s,t,i,j-1);
                
            }
            
      
        
        }
        
        private  int[][] dpArray(String a, String b)
        {
           int[][]dp = new int[a.length() +1][b.length() +1];
           
           for(int i=0;i<dp.length;i++)
           {
               dp[i][0] = 0;
           }
           
           
            for(int i=0;i<dp[0].length;i++)
           {
               dp[0][i] = 0;
           }
           
           
           for(int i=1;i<dp.length;i++)
           {
               for(int j=1 ;j<dp[0].length ; j++)
               {
                   if(a.charAt(i-1) == b.charAt(j-1))
                   {
                    dp[i][j] = 1 + dp[i-1][j-1];   
                   }
                   else
                   {
                       int up  = dp[i-1][j];
                       int down= dp[i][j-1];
                       
                       dp[i][j] = Math.max(up , down);
                   }
               }
           }
           return dp;
        }
        
       */ 
        
}
