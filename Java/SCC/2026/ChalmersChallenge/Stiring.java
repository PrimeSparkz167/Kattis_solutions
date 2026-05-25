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
public class Stiring {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); /**

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int t=nextInt(),n=0,s=0;
        while(s<=t){
            n++;
            s+=n;
        }
        System.out.println(n-1);
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
