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
public class CompRival {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        // TODO code application logic here
        int n = nextInt(), x = nextInt(), y;
        ArrayList<ArrayList<Sub>> xs = new ArrayList<>(n);
        ArrayList<ArrayList<Sub>> ys = new ArrayList<>(n);
        //ArrayList<ArrayList<Sub>> sxs = new ArrayList<>(n);
        //ArrayList<ArrayList<Sub>> sys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            xs.add(new ArrayList<>());
            ys.add(new ArrayList<>());
            //sxs.add(new ArrayList<>());
            //sys.add(new ArrayList<>());
        }
        int p, s, t;
        for (int i = 0; i < x; i++) {
            p = nextInt()-1;
            s = nextInt();
            t = nextInt();
            xs.get(p).add(new Sub(s, t));
            //sxs.get(p).add(new Sub(t,s));
        }
        y = nextInt();
        for (int i = 0; i < y; i++) {
            p = nextInt()-1;
            s = nextInt();
            t = nextInt();
            //System.err.println(s);
            ys.get(p).add(new Sub(s, t));
            //sys.get(p).add(new Sub(t,s));
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(xs.get(i));
            Collections.sort(ys.get(i));
            //Collections.sort(sxs.get(i));
            //Collections.sort(sys.get(i));
        }
        int xscore = 0, yscore = 0, xf = 0, yf = 0, sco = 0, jm = 0;
        long xts=0,yts=0;
        for (int i = 0; i < n; i++) {
            ArrayList<Sub> xss = xs.get(i);
            ArrayList<Sub> yss = ys.get(i);
            for (int j = 0; j < xss.size(); j++) {
                if (sco < xss.get(j).s) {
                    sco=xss.get(j).s;
                    jm = j;
                }
            }
            xscore += sco;
            if (sco > 0) {
                xts += (xss.get(jm).t) + (20 * jm);
                xf = Math.max(xf, xss.get(jm).t);
            }
            sco = 0;
            jm = 0;
            for (int j = 0; j < yss.size(); j++) {
                if (sco < yss.get(j).s) {
                    sco=yss.get(j).s;
                    jm = j;
                }
            }
            yscore += sco;
            if (sco > 0) {
                yts += (yss.get(jm).t) + (20 * jm);
                yf = Math.max(yf, yss.get(jm).t);
                //System.err.println(yf);
            }
            sco = 0;
            jm = 0;
        }
        if (xscore == yscore) {
            StringBuilder sb = new StringBuilder();
            sb.append((xts < yts) ? "YES " : "NO ");
            sb.append((x < y) ? "YES " : "NO ");//done
            sb.append((xf < yf) ? "YES" : "NO");
            System.out.println(sb.toString());
        } else {
            System.out.println((xscore > yscore) ? "YES YES YES" : "NO NO NO");
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
