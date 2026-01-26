/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fyrtorn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Fyrtorn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        ArrayList<HashSet<Integer>> xs = new ArrayList<>();
        ArrayList<HashSet<Integer>> ys = new ArrayList<>();
        ArrayList<Integer> ps= new ArrayList<>();

        for (int i = xs.size(); i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int xmatch = -1, ymatch = -1;
            for (int j = 0; j < xs.size() && xmatch == -1; j++) {
                if (xs.get(j).contains(x)) {
                    xmatch = j;
                }
            }
            for (int j = 0; j < ys.size() && ymatch == -1; j++) {
                if (ys.get(j).contains(y)) {
                    ymatch = j;
                }
            }
            if (xmatch == -1 && ymatch == -1) {//new
                xs.add(new HashSet<>());
                ys.add(new HashSet<>());
                xs.getLast().add(x);
                ys.getLast().add(y);
                ps.add(1);
            } else if (xmatch == -1 || ymatch == -1) {//add to exsisting
                int p = Math.max(xmatch, ymatch);
                xs.get(p).add(x);
                ys.get(p).add(y);
                ps.set(p, ps.get(p)+1);
            } else if (xmatch != ymatch) {//merge
                int P = Math.max(xmatch, ymatch);
                int p = Math.min(xmatch, ymatch);
                xs.get(p).addAll(xs.get(P));
                ys.get(p).addAll(ys.get(P));
                xs.remove(P);
                ys.remove(P);
                ps.set(p, ps.get(p)+ps.get(P)+1);
                ps.remove(P);
            }

        }
        Collections.sort(ps);
        Collections.reverse(ps);
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += ps.get(j);
        }
        System.out.println(sum);
    }

}
