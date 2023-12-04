public class IndianCoins {
    public static void main(String args[]) {
        //Indian Coins Question
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = coins.length;
        int amount = 43;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
