/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bell.ford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class BellFord {
public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n =sc.nextInt(),s=sc.nextInt(),t=sc.nextInt(),w;
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w=sc.nextInt();
                if (i!=j) {
                    edges.add(new Edge(i,j,w));
                }
            }
        }
        solve(n,edges,s,t);
    }
    public static void solve(int n, ArrayList<Edge> edges, int s, int t) {
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        dist.set(s, 0);
        boolean changed, endloop = true;
        for (int i = 0; i < n&&endloop; i++) {
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
        
        System.out.println(dist.get(t));
        }
    }