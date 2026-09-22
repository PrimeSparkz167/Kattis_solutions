/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package horror;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Simon
 */
public class Horror {

   public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); /**

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n= nextInt(),h=nextInt(),l=nextInt(),in=0;
        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Movie> dist= new ArrayList<>();
        //boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i]=(new ArrayList<>());
            dist.add(new Movie(i,Integer.MAX_VALUE));
        }
        int[] hs = new int[h];
        for (int i = 0; i < h; i++) {
            hs[i]=nextInt();
        }
        for (int i = 0; i < l; i++) {
            int u=nextInt(),v=nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < h; i++) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist.get(hs[i]).h=0;
        q.add(hs[i]);
        while(!q.isEmpty()){
            int cur=q.poll();
            for (int node:adj[cur]) {
                if(dist.get(node).h>dist.get(cur).h){
                    dist.get(node).h=dist.get(cur).h+1;
                    q.add(node);
                }
            }
        }
        }
        Collections.sort(dist);
        System.out.println(dist.getFirst().id);
        
    }
    public static int nextInt() {
        try{
        in.nextToken();
        return (int) in.nval;
        }catch(IOException e){
            System.err.println("e");
        return -1;}
    }
    public static String next() {
        try{
        in.nextToken();
        return in.sval;
        }catch(IOException e){
            System.err.println("e");
        return "";}
    }
    
}
