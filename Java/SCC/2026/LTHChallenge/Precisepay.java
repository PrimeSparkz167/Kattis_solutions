/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

/**
 *
 * @author Simon
 */
public class Precisepay {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); /**

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n=nextInt(),max=2,min=Integer.MAX_VALUE;
        int[] coins = new int[n];
        boolean b=true;
        //HashSet<Integer> nons = new HashSet<>();
        HashSet<Integer> cons = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coins[i]=nextInt();
            max=Math.max(coins[i],max);
            min = Math.min(coins[i],min);
            if(coins[i]==1){
                System.out.println("no change necessary");
                b=false;
                break;
            }
        }
        int c=min+1,lastnon=1;
        boolean ninc;
        cons.add(min);
        cons.add(0);
        while(b&&c<=1000000){//c<=(lastnon<<2)
            ninc=true;
            for (int i = 0; i < n; i++) {
                if (cons.contains(c-coins[i])) {
                    //System.err.println("c"+c+"co"+coins[i]);
                    ninc=false;
                    cons.add(c);
                    break;
                }
            }
            if (ninc) {
                lastnon=(c);
            }
            c++;
        }
        if (b) System.out.println(lastnon);
    }
    public static int nextInt() {
        try{
        in.nextToken();
        return (int) in.nval;
        }catch(IOException e){
            System.err.println("e");
        return -1;}
        //return Integer.parseInt(next());
    }
    public static String next() {
        try{
        in.nextToken();
        return in.sval;
        }catch(IOException e){
            System.err.println("e");
        return "";}
        //return Integer.parseInt(next());
    }
}
