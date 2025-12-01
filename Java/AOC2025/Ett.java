/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ett;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class Ett {

    public static BufferedReader br;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String n;
            char c;
            int d, p = 50, co = 0;
            n = br.readLine();
            while (!n.equals("e")) {
                c = n.charAt(0);
                d = Integer.parseInt(n.substring(1));
                int i,po=p;
                for (i = 100; i < d; i += 100) {
                    co += 1;
                }
                int nd=d-i+100;
                p= (p+((c=='R')?nd:-nd));
                co += ((po!=0&&(p <= 0)||p>=100) ? 1 : 0);
                p=(p+100)%100;
                System.err.println("p"+p);
                System.err.println("co"+co);
                System.err.flush();
                n = br.readLine();
            }
            System.out.println(co);

        } catch (IOException e) {
        }
    }

}
