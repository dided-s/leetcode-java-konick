package hard._1872_Stone_Game_VIII;

import annotations.Hard;

@Hard
public class Solution {

    public int stoneGameVIII(int[] stones) {
        int[] dp = new int[stones.length];

        int[] sumPrefix = new int[stones.length];
        sumPrefix[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sumPrefix[i] = sumPrefix[i - 1] + stones[i];
        }

        dp[stones.length - 1] = sumPrefix[stones.length - 1];
        for (int i = stones.length - 2; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 1], sumPrefix[i] - dp[i + 1]);
        }
        return dp[1];
    }
}