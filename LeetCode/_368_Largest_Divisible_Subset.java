public class _368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        int n=nums.length;

        int[]dp = new int[n];
        int[]prev = new int[n];

        //Dp will store the current length of largest divisible subset
        //Prev will store the prev index tak ki length 

        Arrays.fill(dp , 1);
        Arrays.fill(prev , -1);

        //For every pair (j,i) where j < i
         int maxIndex = 0;          // Index of the largest subset's last element

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            result.add(nums[current]);
            current = prev[current];
        }

        Collections.reverse(result); // Because we built it backwards
        return result;

    }
}
