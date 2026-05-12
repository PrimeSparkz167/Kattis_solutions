/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 *
 * @author Simon
 */
public class PaceParadox {

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
        int n = nextInt(), m = nextInt();
        int[] a = new int[n];
        Arrays.fill(a, (int) n / (3));
        int low = ((n - n % m) / m);
        int high = low + 1,big=n;
        if (n == 2 || m*low==n) {
            System.out.println("NO");
        } else {
            for (int i = m - 1; i < n; i += m) {
                a[i] = big;
                //big--;
            }
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.print("" + a[i] + " ");
            }
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
