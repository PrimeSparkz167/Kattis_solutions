/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buttonbashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class ButtonBashing {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    /**
     *
     * /
     *
     **
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = nextInt();
        for (int test = 0; test < c; test++) {
            int m = 3601, n = nextInt(), t = nextInt();
            int[] bs = new int[n];
            int[] dist = new int[m];
            for (int i = 0; i < n; i++) {
                bs[i] = nextInt();
            }
            for (int i = 0; i < m; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[0] = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(0);
            boolean found = false;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 0; j < bs.length; j++) {
                    int node = Math.max(0, Math.min(3600, bs[j] + cur));
                    if (dist[node] == Integer.MAX_VALUE) {
                        dist[node] = dist[cur] + 1;
                        if (node == t) {
                            q.clear();
                            found=true;
                            System.out.println(dist[node] + " " + 0);
                            break;
                        } else {
                            q.add(node);
                        }
                    }
                }
            }
            if (!found) {
                int p = t + 1;
                while (dist[p] == Integer.MAX_VALUE) {
                    p++;
                }
                System.out.println(dist[p] + " " + (p - t));
            }
        }
    }

    public static int nextInt() {
        try {
            in.nextToken();
            return (int) in.nval;
        } catch (IOException e) {
            System.err.println("e");
            return -1;
        }
    }

    public static String next() {
        try {
            in.nextToken();
            return in.sval;
        } catch (IOException e) {
            System.err.println("e");
            return "";
        }
    }

}
