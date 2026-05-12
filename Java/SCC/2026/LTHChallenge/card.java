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
import java.util.HashSet;

/**
 *
 * @author Simon
 */
public class card {

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
        int n = nextInt(), d = nextInt();
        ArrayList<String> keys = new ArrayList<>(n);
        HashMap<String,Integer> kids = new HashMap<>();
        ArrayList<ArrayList<String>> cards = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String name = next();
            kids.put(name, i);
            keys.add(name);
            int k = nextInt();
            cards.add(new ArrayList<>(k));
            for (int j = 0; j < k; j++) {
                cards.get(i).add(next());
            }
        }
        //int[] in = new int[n];
        for (int i = 0; i < d; i++) {
            String kid1=next(),card1=next(),kid2=next(),card2=next();
            cards.get(kids.get(kid1)).remove(card1);
            cards.get(kids.get(kid2)).remove(card2);
            cards.get(kids.get(kid1)).add(card2);
            cards.get(kids.get(kid2)).add(card1);
        }
        StringBuilder sb = new StringBuilder();
        for (String key:keys) {
            //int i =;
            ArrayList<String> out = new ArrayList<>(cards.get(kids.get(key)));
            Collections.sort(out);
            for (String card:out) {
                sb.append(card).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
