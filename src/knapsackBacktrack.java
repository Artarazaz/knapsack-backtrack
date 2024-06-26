public class knapsackBacktrack {
    public static void main(String[] args) {
        class Utils {
            int max(int a, int b) {
                return Math.max(a, b);
            }
        }

        class Knapsack {
            int knapSack(int W, int[] wt, int[] val, int n, Utils utils) {
                if (n == 0 || W == 0)
                    return 0;

                if (wt[n - 1] > W)
                    return knapSack(W, wt, val, n - 1, utils);

                else
                    return utils.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1, utils),
                            knapSack(W, wt, val, n - 1, utils));
            }
        }

        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;

        Utils utils = new Utils();
        Knapsack knapsack = new Knapsack();

        System.out.println(knapsack.knapSack(W, wt, val, n, utils));
    }
}



