/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VacationTime;

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
public class VacationTime {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    /**
     *
     * /
     *
     **
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = nextInt(), e = nextInt(), s = n << 1;
        //Edge[] edges = new Edge[e];
        ArrayList<Pair>[] adj = new ArrayList[s];
        
        int[] dist = new int[s];
        for (int i = 0; i < s; i++) {
            adj[i] = (new ArrayList<>());
            dist[i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < e; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            if (next().equals("A380")) {
                adj[u].add(new Pair(v + n, w));
                adj[u + n].add(new Pair(v + n, w));
            } else {
                adj[u].add(new Pair(v, w));
                adj[u + n].add(new Pair(v + n, w));
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((z1, z2) -> Integer.compare(z1.w, z2.w));
        dist[0] = 0;
        pq.add(new Pair(0,0));
        boolean[] vis = new boolean[s];
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int cd=p.w,id=p.u;
            if(!vis[id]){
                vis[id]=true;
                for (Pair pi:adj[id]) {
                    int alt =cd+pi.w;
                    if(alt<dist[pi.u]){
                        dist[pi.u]=alt;
                        pq.add(new Pair(pi.u,alt));
                    }
                }
            }
        }
        System.out.println((dist[s - 1]==Integer.MAX_VALUE)?-1:(dist[s - 1]));
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
