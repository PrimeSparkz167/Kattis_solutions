/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unionfind;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author Simon
 */
public class Unionfind {

    public static int[] parent;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter( new BufferedOutputStream(System.out));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String in[] = br.readLine().split(" ");
            int q = Integer.parseInt(in[1]);
            parent = new int[Integer.parseInt(in[0])];
            Arrays.fill(parent, -1);
            for (int i = 0; i < q; i++) {
                in = br.readLine().split(" ");
                if (in[0].equals("=")) {
                    merge(Integer.parseInt(in[1]), Integer.parseInt(in[2]));
                } else {
                    out.println(((find(Integer.parseInt(in[1])) == find(Integer.parseInt(in[2]))) ? "yes" : "no"));
                    
                }
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("fel");
        }
    }

    public static int find(int a) {
        if (parent[a] < 0) {
            return a;
        } else {
            int repr = find(parent[a]);
            parent[a] = repr;
            return repr;
        }
    }

    public static int size(int a) {
        int repr = find(a);
        return - parent[repr];
    }

    public static boolean merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        int as = - parent[a];
        int bs = - parent[b];
        if (as < bs) {
            parent[a] = b;
            parent[b] -= as;
        } else {
            parent[b] = a;
            parent[a] -= bs;
        }
        return true;

    }
}
