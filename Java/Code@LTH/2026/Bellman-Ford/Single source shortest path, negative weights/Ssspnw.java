/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ssspnw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Ssspnw {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt(), s = sc.nextInt();
        while (n != 0) {
            solve(n, m, q, s);
            n = sc.nextInt();
            m = sc.nextInt();
            q = sc.nextInt();
            s = sc.nextInt();
        }

    }

    public static void solve(int n, int m, int q, int s) {
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        dist.set(s, 0);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        boolean changed, endloop = true;
        for (int i = 0; i < n; i++) {
            changed = false;
            for (Edge e : edges) {
                if (dist.get(e.u) != Integer.MAX_VALUE && (dist.get(e.v) == Integer.MAX_VALUE || dist.get(e.v) > dist.get(e.u) + e.w)) {
                    changed = true;
                    dist.set(e.v, dist.get(e.u) + e.w);
                }
            }
            if (!changed) {
                endloop = false;
            }
        }
        if (endloop) {
            ArrayList<Integer> is_inf = new ArrayList<>();
            for (Edge e : edges) {
                if (dist.get(e.u) != Integer.MAX_VALUE && (dist.get(e.v) == Integer.MAX_VALUE || dist.get(e.v) > dist.get(e.u) + e.w)) {
                    dist.set(e.v, Integer.MIN_VALUE);
                    is_inf.add(e.v);
                }
            }
            ArrayList<Integer>[] adj;
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (Edge e : edges) {
                adj[e.u].add(e.v);
            }
            for (int i = 0; i < is_inf.size(); i++) {
                for (int nei : adj[is_inf.get(i)]) {
                    if (dist.get(nei) != Integer.MIN_VALUE) {
                        is_inf.add(nei);
                        dist.set(nei, Integer.MIN_VALUE);
                    }
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int d = dist.get(sc.nextInt());
            switch (d) {
                case Integer.MAX_VALUE ->
                    System.out.println("Impossible");
                case Integer.MIN_VALUE ->
                    System.out.println("-Infinity");
                default ->
                    System.out.println(d);
            }
        }
    }

}
