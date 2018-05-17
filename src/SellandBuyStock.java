public class SellandBuyStock {
    //Say you have an array for which the ith element is the price of a given stock on day i.
    //Design an algorithm to find the maximum profit. You may complete at most two transactions.

    public  int sellStockwith2Trans(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2= Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(prices[i] + buy1, sell1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(sell1, sell2);
    }


    //hold[i][k]  ith day k transaction have stock and maximum profit
    //unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
    public int maxProfitWithKTrans(int k, int[] prices) {
        if(k>prices.length/2) return maxP(prices);
        int[][] hold = new int[prices.length][k+1];
        int[][] unhold = new int[prices.length][k+1];
        hold[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++) hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        for(int j=1;j<=k;j++) hold[0][j] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j] = Math.max(unhold[i-1][j]-prices[i],hold[i-1][j]);
                unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
    }

    public int maxP(int[] prices){
        int res =0;
        for(int i=0;i<prices.length;i++){
            if(i>0 && prices[i] > prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SellandBuyStock sellandBuyStock = new SellandBuyStock();
        int[] prices = {1,3,4,2,4,5,6,2,1,3,4,5,6,4,2,4,6,8,9};
        System.out.println(sellandBuyStock.sellStockwith2Trans(prices));
    }

}
