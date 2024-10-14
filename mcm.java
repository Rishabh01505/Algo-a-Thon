public class solution {

    // Function to calculate min multiplication cost
    static int minMult(int[] arr) {
        int n = arr.length;
      
        // Create a 2D DP array to store minimum
        // multiplication costs
        int[][] dp = new int[n][n];

        // Fill the DP array
        // len is the chain length
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] +
                      arr[i] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        // Minimum cost is in dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(minMult(arr));
    }
}
