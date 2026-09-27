class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i=0; i <= amount; i++){
            for(int j=0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
                }
            }
        }
        if(dp[amount] == amount + 1) return -1;
        return dp[amount];
    }

    //for each amount target, I can take one out of the coins collections such that that one coin + all the coins I took before that for amount target - coin value is the minimum
    //for target 0 I need 0 coins
    //for target that is impossible to return Return -1

}
