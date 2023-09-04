public class subset {
    public static boolean hasSubsetSum(int[] nums, int targetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        // Base case: an empty subset can always achieve a sum of 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // If the current number is greater than the target sum, skip it
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either include the current number or exclude it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int targetSum = 9;

        boolean result = hasSubsetSum(nums, targetSum);
        if (result) {
            System.out.println("There is a subset that adds up to the target sum.");
        } else {
            System.out.println("No subset adds up to the target sum.");
        }
    }
}
