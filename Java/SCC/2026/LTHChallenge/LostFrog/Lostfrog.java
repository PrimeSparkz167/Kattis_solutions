/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author Simon
 */
public class Lostfrog {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    /**
     *
     * /
     *
     **
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int L = nextInt(), n = nextInt();
        int[][] coords = new int[n][2];
        for (int i = 0; i < n; i++) {
            coords[i][0] = nextInt();
            coords[i][1] = nextInt();
        }
        ArrayList<ArrayList<Edge>> edges = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            ArrayList<Edge> temp = new ArrayList<>(n + 1);
            int[] p1 = coords[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    temp.add(new Edge(i, j, Math.hypot(coords[j][0] - p1[0], coords[j][1] - p1[1]) / 2));
                }
            }
            temp.add(new Edge(i, n, Math.min(p1[1], (L - p1[0]))));
            edges.add(temp);
        }
        //Prims algorithm
        double ans = 0;
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {//Adding connectors from node -1 to the other nodes since its special
            int[] p1 = coords[i];
            double d = Math.min(p1[0], L - p1[1]);
            pq.add(new Edge(-1, i, d));
        }
        double[] key = new double[n + 1];
        Arrays.fill(key, L << 1);//L is big, no distance is bigger than Lsqrt(2)

        while (!pq.isEmpty()) {//edges are sorted based on the third value in the constructor, the w value
            Edge ed = pq.poll();
            int u = ed.v;//this edge leads to node with index ed.v, and weight w
            if (!vis[u]) {
                vis[u] = true;
                if (u == n) {
                    ans = ed.w;
                } else {
                    for (Edge next : edges.get(u)) {
                        if (!vis[next.v]) {
                            double bottleneck = Math.max(ed.w, next.w);
                            if (bottleneck < key[next.v]) {
                                key[next.v] = bottleneck;
                                pq.add(new Edge(next.u, next.v, bottleneck));
                            }

                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean connected(int[] p1, int[] p2, double r) {
        return Math.hypot(p2[0] - p1[0], p2[1] - p1[1]) > (r * 2);
    }

    public static int nextInt() {
        try {
            in.nextToken();
            return (int) in.nval;
        } catch (IOException e) {
            System.err.println("e");
            return -1;
        }
        //return Integer.parseInt(next());
    }

    public static String next() {
        try {
            in.nextToken();
            return in.sval;
        } catch (IOException e) {
            System.err.println("e");
            return "";
        }
        //return Integer.parseInt(next());
    }
}
