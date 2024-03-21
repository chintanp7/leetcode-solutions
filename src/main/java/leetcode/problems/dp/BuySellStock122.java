package leetcode.problems.dp;

public class BuySellStock122 {

    public static void main(String[] args) {
        BuySellStock122 obj = new BuySellStock122();
        int[] prices = new int[]{6, 2, 4, 5, 8, 6, 2, 9};
        int maxProfit = obj.maxProfit2(prices);
        System.out.println(maxProfit);
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int days = prices.length;
        for (int i = 1; i < days; i++) {
            if (buy < prices[i]) {
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int maxProfit = 0;
        int i = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] < prices[j - 1]) {
                totalProfit += maxProfit;
                maxProfit = 0;
                i = j;
            } else {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        totalProfit += maxProfit;
        return totalProfit;
    }
}
