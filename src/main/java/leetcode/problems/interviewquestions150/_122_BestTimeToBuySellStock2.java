package leetcode.problems.interviewquestions150;

public class _122_BestTimeToBuySellStock2 {

    public static void main(String[] args) {
        _122_BestTimeToBuySellStock2 obj = new _122_BestTimeToBuySellStock2();
        int[] prices = new int[]{7,3,2,5,1,3,6,4};
        int profit = obj.maxProfit(prices);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
