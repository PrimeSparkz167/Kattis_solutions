/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package två;

import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class Två {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        long g = sc.nextLong();
        long m = Long.valueOf(1073741824)*Long.valueOf(1073741824);
        boolean b=false;
        for (long i = 1; i < m && g>=i; i*=2) {
            if (i==g) {
                b=true;
                break;
            }
        }
        System.out.println(((b)?"Yes":"No"));
    }
    
}
