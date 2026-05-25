/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author Simon
 */
public class ThreeFlavour {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * /
     *
     **
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = next();
        char[] cs = {'a', 'b', 'c'}, ss = s.toCharArray();
        int an = 0, bn = 0, cn = 0, n = s.length();
        char c;
        for (int i = 0; i < n; i++) {
            c = ss[i];
            switch (c) {
                case 'a' ->
                    an++;
                case 'b' ->
                    bn++;
                default -> //c==c
                    cn++;
            }
        }
        if (bn >= an && bn >= cn) {
            int temp = an;
            an = bn;
            bn = temp;
            cs[0] = 'b';
            cs[1] = 'a';
        } else if (cn >= an && cn >= bn) {
            int temp = an;
            an = cn;
            cn = temp;
            cs[0] = 'c';
            cs[2] = 'a';
        }
        if ((an <= (n + 1) >> 1)) {
            char[] base = new char[n], out = new char[n];
            int ai = 0, loops = 0;
            Arrays.fill(base, 0, an, cs[0]);
            Arrays.fill(base, an, an + bn, cs[1]);
            Arrays.fill(base, an + bn, an + bn + cn, cs[2]);
            for (int i = 0; i < n; i++) {
                out[i] = base[ai];
                if (ai + an >= n) {
                    loops++;
                    ai = loops;
                } else {
                    ai += an;
                }
            }
            try {
                BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
                log.write(out, 0, n);
                log.flush();
            } catch (IOException e) {
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static String next() {
        try {
            return br.readLine();

        } catch (IOException e) {
            System.err.println("e");
            return "";
        }
    }
}
