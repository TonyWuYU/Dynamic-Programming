package NiukeAcm;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/6.
 * DP问题
 * 问题描述：
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 * 输入实例：  3
 * -1 2 1
 * 输出实例：  3
 * 状态转换方程：dp[i] = max{para[i] + dp[i - 1],para[i]}
 * 解决关键：dp[i] 表示以para[i]为结尾的最大连续长度。
 */
public class MaxCombo {
    public static void main(String[] args) {
        new MaxCombo().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] para = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            para[i] = sc.nextInt();
        }
        int max = para[0];
        dp[0] = para[0];
        for (int i = 1; i < N; i++) {
            if (para[i] + dp[i - 1] > para[i]) {
                dp[i] = para[i] + dp[i - 1];
            } else {
                dp[i] = para[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
