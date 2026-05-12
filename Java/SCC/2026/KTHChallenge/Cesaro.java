/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *
 * @author Simon
 */
public class Cesaro {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); /**

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n=nextInt();
        double[] sum= new double[n];
        int[] in = new int[n];
        in[0]=nextInt();
            sum[0]=in[0];
        for (int i = 1; i < n; i++) {
            in[i]=nextInt();
            sum[i]=in[i]+sum[i-1];
        }
        int k=0;
        double avg=1;
        
        
        if (Math.abs(sum[n-1])>n){
            if (sum[n-1]>0) {
                System.out.println("INFINITY");
            }else{
                System.out.println("-INFINITY");}
        }else{
            double s=0;
            for (int i = 0; i < n; i++) {
                s+=sum[i];
            }
        System.out.println(s/n);
        }
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
