RICHEST CUSTOMER WEALTH:
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bank : customer) {
                currentWealth += bank;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: Output 6
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
        System.out.println("Max Wealth: " + sol.maximumWealth(accounts1));

        // Example 2: Output 10
        int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println("Max Wealth: " + sol.maximumWealth(accounts2));
    }
}

OUTPUT:
Input
accounts =
[[1,2,3],[3,2,1]]
Output
6
Expected
6
