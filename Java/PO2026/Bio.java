/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Simon
 */
public class Bio {
public static BufferedReader br;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]), q=Integer.parseInt(in[1]);
            int[] bio = new int[(n/30) +1];
            int[] p2=  {1,2,4,8,16,32,64,128,256,512,1024,
                2048,4096,8192,16384,32768, 65536, 131072, 262144, 524288, 1048576,
                2097152, 4194304, 8388608, 16777216,33554432, 67108864,134217728,268435456,  536870912,1073741824, 
            };
            for (int i = 0; i < q; i++) {
                in = br.readLine().split(" ");
                if (Integer.parseInt(in[0])==1) {
                    int ip = Integer.parseInt(in[1]);
                    int spot = ip/30;
                    int ipi=ip%30;
                    if ((bio[spot]&p2[ipi])==p2[ipi]) {//
                        System.out.println("Upptagen");
                    }else{
                        System.out.println("Ledig");
                        bio[spot]=(bio[spot]|p2[ipi]);
                    }
                }else{
                    int ip = Integer.parseInt(in[1]),jp=Integer.parseInt(in[2]);
                    int spoti = ip/30;
                    int ipi=ip%30;
                    int spotj = jp/30;
                    int jpj=jp%30;
                    if ((bio[spotj]&p2[jpj])==p2[jpj]) {
                        System.out.println("Upptagen");
                    }else{
                        System.out.println("Ledig");
                        bio[spoti]=bio[spoti]^p2[ipi];
                        bio[spotj]=bio[spotj]|p2[jpj];
                    }
                }
            }
        }catch(IOException e){
        }
    }
    
}
