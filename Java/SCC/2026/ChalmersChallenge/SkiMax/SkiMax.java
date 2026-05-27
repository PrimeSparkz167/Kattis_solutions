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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Simon
 */
public class SkiMax {

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
        int k = nextInt(), m = nextInt(), y = nextInt();
        HashMap<String, Integer> diffs = new HashMap<>(5);
        diffs.put("Green", 0);
        diffs.put("Blue", 1);
        diffs.put("Red", 2);
        diffs.put("Black", 3);
        diffs.put("DoubleBlack", 4);
        HashMap<String, int[]> names = new HashMap<>(m);
        ArrayList<ArrayList<Berg>> berg = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            berg.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String n = next();
            int alt = nextInt();
            int d = diffs.get(next());
            int[] os = {d, berg.get(d).size()};
            names.put(n, os);
            berg.get(d).add(new Berg(d, alt));
        }
        int[] fav = names.get(next());
        berg.get(fav[0]).get(fav[1]).fav = true;
        int favalt = berg.get(fav[0]).get(fav[1]).alt;
        for (int i = fav[0]; i < 5; i++) {
            Collections.sort(berg.get(i));
            //berg.set(i, new ArrayList<>(binarySearch(berg.get(i),favalt,berg.get(i).size())));
        }
        int favpos=0;
        for (int i = 0; i < berg.get(fav[0]).size(); i++) {
            if(berg.get(fav[0]).get(i).fav){favpos=i;break;}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            int alt = nextInt();
            if (alt <= favalt) {
                //ArrayList<Berg> over = new ArrayList<>();
                int c=0;
                for (int j = 4; j > fav[0]; j--) {
                    c+=binarySearch(berg.get(j), alt, berg.get(j).size()).size();
                }
                sb.append((c+favpos<k) ? "YES" : "NO").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static List<Berg> binarySearch(ArrayList<Berg> ber, int key, int n) {
        if (n > 0) {
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = lo + ((hi - lo) / 2);
                if (ber.get(mid).alt >= key) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return ber.subList(0, lo);
        }
        return new ArrayList<>();
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
    }
}
