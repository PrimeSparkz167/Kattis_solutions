/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package katt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class Katt {

    public static BufferedReader br;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]), maxi = 0, maxa = 0;
            String[] cs = new String[k];
            int[] as = new int[k];
            boolean poss = false;
            for (int i = 0; i < k; i++) {
                in = br.readLine().split(" ");
                int t = Integer.parseInt(in[1]);
                cs[i] = in[0];
                as[i] = t;
                if (t > maxa) {
                    maxa = t;
                    maxi = i;
                }
            }
            poss = (maxa<=n/2);//is this really enough?
            System.out.println(((poss) ? "Ja" : "Nej"));
            if (poss) {
                //make sure we swap this maxi to be first
            int temp = as[0];
            as[0] = maxa;
            as[maxi] = temp;
            String maxn = cs[maxi];
            cs[maxi] = cs[0];
            cs[0] = maxn;
            //make sure we swap this maxi to be first
            String[] base = new String[n];
            int ki = 0;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < as[i]; j++) {
                    base[ki] = cs[i];
                    ki++;
                }
                as[i] = 0;
            }
                StringBuilder sb = new StringBuilder();
                int ai = 0;
                int loops = 0;
                for (int i = 0; i < base.length; i++) {
                    sb.append(base[ai]).append(" ");
                    if (ai + maxa >= base.length) {
                        loops++;
                        ai = loops;
                    } else {
                        ai += maxa;
                    }
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
        }
    }

}
