/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package brexit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *
 * @author Simon
 */
public class Brexit {

    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in))); /**
             * @param args the command line arguments
             */

    public static void main(String[] args) {
        // TODO code application logic here
        int c = nextInt(), p = nextInt(), x = nextInt() - 1, l = nextInt() - 1, a, b;
        int[] n = new int[c], ae = new int[p], be = new int[p], ns = new int[p << 1], pos = new int[p << 1], start = new int[c], size = new int[c], ptr = new int[c];
        boolean[] bs = new boolean[c];
        for (int i = 0; i < p; i++) {
            a = nextInt() - 1;
            b = nextInt() - 1;
            n[a]++;
            n[b]++;
            ae[i] = a;
            be[i] = b;
        }
        for (int i = 0; i < c - 1; i++) {
            start[i + 1] = start[i] + n[i];
            ptr[i + 1] = start[i + 1];
            size[i] = n[i];
        }
        size[c - 1] = n[c - 1];
        for (int i = 0; i < p; i++) {
            a = ae[i];
            b = be[i];
            ns[ptr[a]] = b;
            pos[ptr[a]] = ptr[b];
            ns[ptr[b]] = a;
            pos[ptr[b]] = ptr[a];
            ptr[ae[i]]++;
            ptr[be[i]]++;
        }
        int head = 0, tail = 0, curr, nb, j, last;
        int[] q = new int[c << 1];
        n[l] = Integer.MAX_VALUE;
        q[tail++] = l;
        while (head != tail && (!bs[x])) {
            curr = q[head];
            head++;
            if (!bs[curr]) {
                bs[curr] = true;
                for (int i = 0; i < size[curr]; i++) {
                    nb = ns[start[curr] + i];
                    j = pos[start[curr] + i];
                    size[nb]--;
                    last = start[nb] + size[nb];
                    ns[j] = ns[last];//replace with last
                    pos[j] = pos[last];
                    pos[pos[last]] = j;
                    if ((n[nb] >= (size[nb] << 1)) && (!bs[nb])) {
                        if (nb==l){
                            head=tail;
                            bs[nb]=true;
                            break;
                        }else{
                        q[tail] = nb;
                        tail++;}
                        
                    }
                }
            }
        }
        System.out.println((bs[x]) ? "leave" : "stay");
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


}
