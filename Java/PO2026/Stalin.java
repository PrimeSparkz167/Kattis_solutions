/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stalin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class Stalin {

    public static BufferedReader br;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            boolean added = false;
            int f = Integer.parseInt(in[0]);
            list.getFirst().add(f);
            ArrayList<Integer> last = new ArrayList<>();
            last.add(f);
            for (int i = 1; i < n; i++) {
                int num = Integer.parseInt(in[i]);
                if (num>last.getFirst()) {
                    last.set(0, num);
                    list.getFirst().add(num);
                }else if (num<= last.getLast()){
                    last.add(num);
                    list.add(new ArrayList<>());
                    list.getLast().add(num);
                }else{//binary search, 
                    //return number 0<res<(last.size())
                    int lo =1,hi=last.size()-1;
                    while(lo<hi){
                        int mid = (lo+hi)/2;
                        if (last.get(mid)<num) {//we can go earlier
                            hi=mid-1;
                        }else{ 
                            lo=mid+1;
                        }
                    }
                    last.set(lo, num);
                    list.get(lo).add(num);
                }
                /*
                for (int k = 0; k < list.size(); k++) {//iterativt, what if you could binary search over this instead
                    if (list.get(k).getLast() < num) {
                        list.get(k).add(num);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    list.add(new ArrayList<>());
                    list.getLast().add(num);
                } else {
                    added = false;
}**/
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    sb.append(list.get(i).get(j)).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
        }

    }
}
