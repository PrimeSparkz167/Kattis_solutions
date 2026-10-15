/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Simon
 */
public class Knapsack {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            while (true) {
                st = new StringTokenizer(br.readLine());
                knapsack(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        } catch (Exception e) {
        }
    }

    public static void knapsack(int m, int n) {
        //int n=nextInt(),m=nextInt();
        int[] vs = new int[n + 1];
        int[] ws = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1];
        int[][] dpPath = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            vs[i] = nextInt();
            ws[i] = nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (((j - ws[i] >= 0) ? dp[i - 1][j - ws[i]] + vs[i] : 0) > dp[i - 1][j]) {
                    dp[i][j] = (dp[i - 1][j - ws[i]] + vs[i]);
                    dpPath[i][j] = j - ws[i];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    dpPath[i][j] = j;
                }
            }
        }
        ArrayList<Integer> inc = new ArrayList<>();
        int j = m;
        for (int i = n; i > 0; i--) {
            if (dpPath[i][j] != j) {
                inc.add(i - 1);
                j = dpPath[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(inc.size()).append("\n");
        for (int i : inc) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int nextInt() {
        return Integer.parseInt(next());
    }

    public static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

}
