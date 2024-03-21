package leetcode.problems.dp;

public class BuySellStock121 {

    public static void main(String[] args) {
        BuySellStock121 obj = new BuySellStock121();
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = obj.maxProfit2(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int leastPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastPrice) {
                leastPrice = prices[i];
            }
            profit = prices[i] - leastPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
