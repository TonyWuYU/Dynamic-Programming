package NiukeAcm;

import java.util.Scanner;

/**
 * Created by TonyWu on 2017/4/16.
 * 动态规划DP经典问题
 * Dp本质：以空间换取时间
 * 问题描述：人民币纸币目前的金额的有1元、2元、5元、10元，求它们组成的N元钱共有几种组成方法？
 * DP问题核心：状态转换方程，dp[i - 1][j] + dp[i][j - RMB[i]]
 */
public class CoinDp{
    public static void main(String[] args) {
        new CoinDp().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] RMB = {1, 2, 5, 10};
        int[][] dp = new int[RMB.length][N + 1];
        for (int i = 0; i < RMB.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= N; i++) {
            if (i % RMB[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < RMB.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (RMB[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - RMB[i]];
                }
            }
        }
        System.out.println(dp[RMB.length - 1][N]);
    }

}
