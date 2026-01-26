/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package godis;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Godis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//dp?
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[][][] dp ;
        int n = sc.nextInt();
        dp=new int[n][n][41];
        int[][] bags = new int[n][41];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int s=sc.nextInt(),a=sc.nextInt();
                
            }
        }
    }
    
}
