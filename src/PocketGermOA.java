//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Set;
//
//public class PocketGermOA {
////最多跳过一个
//    public int movieRatings(int[] ratings) {
//        if (ratings.length == 1) return ratings[0];
//        int[] dp = new int[ratings.length];
//        dp[0] = ratings[0];
//        dp[1] = ratings[1] + Math.max(0, dp[0]);
//        for (int i = 2; i < ratings.length; i++) {
//            dp[i] = ratings[i] + Math.max(dp[i - 1], dp[i - 2]);
//        }
//
//        return Math.max(dp[ratings.length -1], dp[ratings.length - 2]);
//    }
//
////O(n) init 10000space
//    public int deleteAndEarn(int[] nums) {
//        int[] sum = new int[10001];
//        for (int num : nums) {
//            sum[num] += num;
//        }
//
//        int[] dp = new int[10001];
//        dp[1] = sum[1];
//        for (int i = 2; i <= 10000; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
//        }
//
//        return dp[10000];
//    }
//
//
////O(nlgn)
//    public int deleteAndEarn2(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0;
//        int cur = 0;
//        int prev = 0;
//        int prev2 = 0;
//        int startIndex = 0;
//
//        while(i < nums.length){
//            cur = nums[i];
//            startIndex = i - 1;
//            while(i < nums.length - 1 && nums[i] == nums[i+1]) cur += nums[i++];
//
//            if(startIndex >= 0 && nums[i] > nums[startIndex] + 1) cur += prev;
//            else cur = Math.max(cur + prev2, prev);
//
//            prev2 = prev;
//            prev = cur;
//            i++;
//        }
//        return cur;
//    }
//
//    /**
//     * This is the inventery class, update the bag of the player and his tools
//     * Use a Hasmap to keep the <Item, Quantity> pair of all items
//     * The two Sets used to keep track of the normalItem and questItem individually
//     */
//    class Inventery {
//
//        abstract class Item {
//            char identifier;
//            abstract boolean isQuestItem();
//        }
//
//        private HashMap<Item, Integer> itemMap;
//        //Although the two sets are not used in this code, the player may call some method to check their normal items or quest items in other class
//        private Set<Item> questItem;
//        private Set<Item> normalItem;
//
//        private Item lastItem;
//
//        public Item lastItemCollected() {
//            return lastItem;
//        }
//
//        /**
//         * pickItem method will realize the function picking item and increasing the item quantity in the bag
//         * @param item the item the player gets
//         * @param quantity the quantity of the item the player gets
//         */
//        public void pickItem(Item item, int quantity) {
//            itemMap.put(item, itemMap.getOrDefault(item, 0) + quantity);
//
//            if (item.isQuestItem()) {
//                questItem.add(item);
//            } else {
//                normalItem.add(item);
//            }
//            AchivementSystem.instance.didMoifyItem("gain", item.identifier, quantity);
//            didPickupItem(item);
//        }
//
//        /**
//         * loseItem method will realize the function losing certain item from the tools
//         * @param item item is the item to lose but we need to check if we have this item first
//         * @param quantity
//         * @throws Exception when can not lose certain item
//         */
//
//        public void loseItem(Item item, int quantity) {
//            if(!itemMap.containsKey(item)) {
//                throw new NullPointerException ("You don't have the item to lose");
//            } else {
//                int curQuantity = itemMap.get(item);
//                if(curQuantity < quantity) {
//                    throw new IndexOutOfBoundsException("Don't have enough items to lose");
//                } else {
//                    itemMap.put(item, itemMap.get(item) - quantity);
//                }
//
//                AchivementSystem.instance.didMoifyItem("lose", item.identifier, quantity);
//            }
//        }
//
//        /**
//         * didPickupItem method realized the function to keep track of the lastItem the player get
//         * @param item the item to pick up and we will update the lastItem
//         */
//
//        public void didPickupItem(Item item) {
//            lastItem = item;
//        }
//    }
//}