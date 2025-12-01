package slotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Simon
 */
public class Slotto {

    public static BufferedReader br;
    public static int n, W;
    public static int[] val, wt;
    public static ArrayList<ArrayList<Integer>> wts = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        wts.add(new ArrayList<>());
        wts.add(new ArrayList<>());
        wts.add(new ArrayList<>());
        wts.add(new ArrayList<>());
        wts.add(new ArrayList<>());
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] in = br.readLine().split(" ");
            n = Integer.parseInt(in[0]);
            W = Integer.parseInt(in[1]);
            val = new int[n];
            wt = new int[n];
            for (int i = 0; i < n; i++) {
                in = br.readLine().split(" ");
                int vali = Integer.parseInt(in[0]);
                val[i] = vali;
                int wti = Integer.parseInt(in[1]);
                wt[i] = wti;
                wts.get(vali - 1).add(wti);
            }
        } catch (IOException e) {
        }
        for (int i = 0; i < 2; i++) {
            Collections.sort(wts.get(i));
            int fixed = 0;
            for (int j = 1; j < wts.get(i).size() && wts.get(i).get(j - 1) <= W; j++) {
                wts.get(i).set(j, wts.get(i).get(j) + wts.get(i).get(j - 1));//prefix sum
                fixed++;
            }
            int s = wts.get(i).size();
            for (int j = fixed; j < s && wts.get(i).get(fixed) > W; j++) {
                wts.get(i).removeLast();//should remove all leftovers IT Does!
            }
        }
        int[] sizes = {wts.get(0).size(), wts.get(1).size(),
            wts.get(2).size(), wts.get(3).size(), wts.get(4).size()};
        int ans = sizes[0];
        if (sizes[2] + sizes[3] + sizes[4] == 0) {
            if (sizes[1] != 0) {
                int T = W;
                for (int i = sizes[1] - 1; i >= 0; i--) {
                    ans = Math.max(ans, ((2 * i + 2) + binarySearch(wts.getFirst(),
                            (T - wts.get(1).get(i)),0)));
                }
            }
        } else {
            ans = Math.max(ans, mknapSack());
        }
        System.out.println(ans);

    }

    public static int binarySearch(ArrayList<Integer> list, int x, int index) {
        //System.err.println("bs");
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            int atm = list.get(mid);
            if (atm == x) {
                return mid + 1;
            }
            if (atm < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
        public static int mknapSack() {
        int i, w;
        int[][] K = new int[3][W + 1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i%3][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i%3][w] = Math.max(val[i - 1] + K[(i - 1)%3][w - wt[i - 1]], K[(i - 1)%3][w]);
                } else {
                    K[i%3][w] = K[(i - 1)%3][w];
                }
            }
        }
        return K[n%3][W];
    }
}
