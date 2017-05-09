package NiukeAcm;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/9.
 * 简单动态规划问题DP
 * 问题描述：
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * 输入： 5
 *       1 4 2 5 3
 * 输出：3
 * 解决思路：dp[i]代表使用在para数组中为第i个元素作为结尾,与此同时,挑选出在第i个元素之前比它小的数(同时也是最长序列)作为它的结尾。
 * 例如对于para[0],为1,para[1]为4,para[0]比para[1]小,所以可以作为para[1]的倒数一个数,以此类推。
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] para = new int[N];
        for (int i = 0; i < N; i++) {
            para[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        dp[0] = 1;
        int max;
        int temp = 0;
        for (int i = 1; i < N; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j] > max && para[i] > para[j]) {
                    max = dp[j];
                }
                dp[i] = max + 1;
            }
            if (temp < dp[i]) {
                temp = dp[i];
            }
        }
        System.out.println(temp);
    }
}

