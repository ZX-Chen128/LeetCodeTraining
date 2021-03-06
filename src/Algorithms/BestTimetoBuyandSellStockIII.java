package Algorithms;

/**
 * @Author: Chen Zixin
 * @Date: 2020/9/18 11:11 上午
 */

/**
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */

public class BestTimetoBuyandSellStockIII {

    public static int maxProfit(int[] prices) {
        int len = prices.length;

        int[][][] dp = new int[len][3][2];

        // 完成了不超过交易0次 手上无股票
        dp[0][0][0] = 0;
        // 完成了不超过交易0次 手上有股票
        dp[0][0][1] = -prices[0];
        // 完成了不超过交易1次 手上无股票
        dp[0][1][0] = 0;
        // 完成了不超过交易1次 手上有股票
        dp[0][1][1] = -prices[0];
        // 完成了不超过交易2次 手上无股票
        dp[0][2][0] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        return dp[len - 1][2][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 5, 4, 3, 2, 1,}));
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
