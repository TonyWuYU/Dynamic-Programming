package com.jianzhioffer;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/10.
 * 经典背包问题:DP问题
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * 输入: [1,2,3],[1,2,3],3,6
 * 输出: 6
 * 解决思路: dp[x][y]表示物品数量为x,重量不超过y时背包中的总价值
 * 两种情况：1.将x物品不加入到背包中，那么前x-1件物品的总重量不应该超过y。dp[x][y] = dp[x-1][y]
 *         2.将x物品加入到背包中，那么前x-1前物品的总重量不应该超过y-w(x),因此dp[x][y] = dp[x-1][y-w(x)]+v(x);
 */
public class Bag {
    public static void main(String[] args) {
        new Bag().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cap = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
        }
        int[] dp = new int[cap + 1];
        for (int i = 0; i < N; i++) {
            for (int j = cap; j >= w[i]; j--) {
                dp[j] = dp[j] > dp[j - w[i]] + v[i] ? dp[j] : dp[j - w[i]] + v[i];
            }
        }
        System.out.println(dp[cap]);
    }
}
