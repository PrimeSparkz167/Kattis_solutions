/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kattis;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Kattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(),t=0,P=sc.nextInt(),A=sc.nextInt(),B=sc.nextInt();
        if (A<B) {
            while(S<=P/2){
            t+=A;
            S++;
            }
        }else if(A>B*2){
            while(S<=P/2){
            t+=B;
            S++;
            P++;}
        }else{
            if(P%2==0){
            t+=B;}
            S++;
            P++;
            
            while(S<=P/2){
            t+=A;
            S++;}
        }
        System.out.println(t);
            
        }
    }
