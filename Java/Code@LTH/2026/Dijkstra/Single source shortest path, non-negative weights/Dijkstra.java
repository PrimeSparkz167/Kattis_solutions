/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Simon
 */
public class Dijkstra {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    /**
     *
     * /
     *
     **
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = nextInt(), m = nextInt(), q = nextInt(), s = nextInt();

        while (n + m + q + s != 0) {
            Dijkstra(n, m, q, s);
            n = nextInt();
            m = nextInt();
            q = nextInt();
            s = nextInt();
        }

    }

    public static void Dijkstra(int n, int m, int q, int s) {
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        ArrayList<Node>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            adj[u].add(new Node(v, w));
            //adj[v].add(new Node(u, w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((z1, z2) -> Integer.compare(z1.w, z2.w));
        dist[s] = 0;
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int cd = p.w, id = p.u;
            if (!vis[id]) {
                vis[id] = true;
                for (Node pi : adj[id]) {
                    int alt = cd + pi.w;
                    if (alt < dist[pi.u]) {
                        dist[pi.u] = alt;
                        pq.add(new Node(pi.u, alt));
                    }
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int qq = nextInt();
            System.out.println((dist[qq] == Integer.MAX_VALUE) ? "Impossible" : Integer.toString(dist[qq]));
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

}
