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

/**
 *
 * @author Simon
 */
public class RandomShop {

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
        int n = nextInt();
        long m = nextInt();
        ArrayList<Pile> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(new Pile(nextInt()));
        }

        //int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            c.get(i).set(nextInt());
        }
        Collections.sort(c);
        for (int i = 0; i < n && m >= c.get(i).c; i++) {
            if (c.get(i).diff > 0) {
                m += c.get(i).diff;
            }
        }
        System.out.println(m);
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
