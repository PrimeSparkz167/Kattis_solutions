/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class LIS {
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static int[]arr,dp;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        
    }
    public static int f(int i){
        int maxdp=1;
        for (int j = 0; j < i; j++) {
            if(arr[j]<arr[i]){
                maxdp=Math.max(maxdp,dp[j]+1);
            }
        }
        dp[i]=maxdp;
        return maxdp;
    }
    
    
}
