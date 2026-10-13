package leetcode.problems.interviewquestions150;

public class _121_BestTimeToBuySellStock {

    public static void main(String[] args) {
        _121_BestTimeToBuySellStock obj = new _121_BestTimeToBuySellStock();
        int[] prices = new int[]{7,3,2,5,1,3,6,4};
        int profit = obj.maxProfit(prices);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        } 
        return maxProfit;
    }
}
