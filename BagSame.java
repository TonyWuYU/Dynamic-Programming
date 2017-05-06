package NiukeAcm;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/5.
 * 动态规划DP经典问题之类背包问题
 * Dp本质：以空间换取时间
 * 问题描述：给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 输入为两行:
 * 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 * 第二行为n个正整数A[i](32位整数)，以空格隔开。
 * 5 15
 * 5 5 10 2 3
 * 输出：
 * 4
 * DP问题核心：状态转换方程，dp[j][k] = dp[j - 1][k] + (k - para[j] >= 0 ? dp[j - 1][k - para[j]] : 0);
 * 解决关键：1.找出状态转换方程 2.找出初始化条件，本题中初始化的关键在于当sum为0的时候，方案数为1
 */
public class BagSame {
    public static void main(String[] args) {
        new BagSame().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = sc.nextInt();
        int[] para = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            para[i] = sc.nextInt();
        }
        long[][] dp = new long[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= N; j++) {
            for (int k = 1; k <= sum; k++) {
                dp[j][k] = dp[j - 1][k] + (k - para[j] >= 0 ? dp[j - 1][k - para[j]] : 0);
            }
        }
        System.out.println(dp[N][sum]);
    }
}
