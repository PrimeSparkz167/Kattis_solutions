package hemligvandring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class Hemligvandring {

    public static BufferedReader br;
    public static int n, c = 0;
    private static String[] og;
    public static City city;
    public static int[] asks;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        asks = new int[365];
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            og = new String[n];
            for (int i = 0; i < n; i++) {
                og[i] = br.readLine();
            }
        } catch (IOException e) {
        }
        city = new City(n, og);
        city.block(0, 1);//up
        city.block(1, 0);//left
        city.block(1, 2);//right
        city.block(2, 1);//below
        asks[0] = ask();
        String ans = "";
        if (asks[0] == -1) {
            if (n == 5) {
                city.block(2, 2);
                city.block(1, 2);
                asks[1] = ask();
                String s = switch (asks[1]) {
                    case 2 ->
                        "3 1";
                    case 4 ->
                        "3 3";
                    case 6 ->
                        "1 3";
                    default ->
                        null;
                };
                ans = ("! 1 1 " + s);
            } else {
                asks[1] = ask();
                if (asks[1] == 2) {
                    city.block(2, 2);
                    city.block(1, 2);
                    asks[2] = ask();
                    ans = ("! 1 1 " + ((asks[2] == 2) ? "3 1" : "1 3"));
                } else {
                    ArrayList<int[]> suspect = new ArrayList<>();
                    for (int r = 0; r <= asks[1]; r += 2) {
                        if ((asks[1] - r + 1) < n && r + 1 < n) {
                            int[] a = {r + 1, asks[1] - r + 1};
                            suspect.add(a);
                        }
                    }
                    int si = suspect.size();
                    while (si != 1) {
                        ArrayList<int[]> block = new ArrayList<>(suspect.subList(0, si / 2));
                        for (int i = 0; i < block.size(); i++) {
                            int[] su = suspect.get(i);
                            city.block(su[0] - 1, su[1]);
                            city.block(su[0], su[1] - 1);
                            city.block(su[0], su[1] + 1);
                            city.block(su[0] + 1, su[1]);
                        }
                        suspect = ((ask() == -1) ? new ArrayList<>(block) : new ArrayList<>(suspect.subList(si / 2, si)));
                        si = suspect.size();
                    }
                    ans = ("! 1 1 " + suspect.getFirst()[0] + " " + suspect.getFirst()[1]);
                }
            }
        } else {
            int d = asks[0];
            ArrayList<int[]> suspect = new ArrayList<>();
            for (int r = 1; r < n; r += 2) {
                for (int c = 1; c < n; c += 2) {
                    int[] a = {r, c};
                    suspect.add(a);
                }
            }
            suspect.remove(0);
            int si = suspect.size();
            while (si != 1) {
                ArrayList<int[]> block = new ArrayList<>(suspect.subList(0, si / 2));
                for (int i = 0; i < block.size(); i++) {
                    int[] su = suspect.get(i);
                    city.block(su[0] - 1, su[1]);
                    city.block(su[0], su[1] - 1);
                    city.block(su[0], su[1] + 1);
                    city.block(su[0] + 1, su[1]);
                }
                suspect = ((ask() == -1) ? new ArrayList<>(block) : new ArrayList<>(suspect.subList(si / 2, si)));
                si = suspect.size();
            }
            
            int[] hus = suspect.get(0);
            suspect = new ArrayList<>();
            for (int r = 0; r <= d; r += 2) {
                if ((d - r + hus[1]) < n && r + hus[0] < n) {
                    int[] a = {r + hus[0], d - r + hus[1]};
                    suspect.add(a);
                }
                if (hus[0]-r>0 && hus[1]+r-d>0) {
                    int[] a = {hus[0]-r, hus[1]+r-d};
                    suspect.add(a);
                }
                if ((d - r + hus[1]) < n && hus[0]-r >0) {
                    int[] a = {hus[0]-r, d - r + hus[1]};
                    suspect.add(a);
                }
                if (r+hus[0]<n && hus[1]+r-d>0) {
                    int[] a = {hus[0]+r, hus[1]+r-d};
                    suspect.add(a);
                }
            }
            si = suspect.size();
            while (si > 1) {
                ArrayList<int[]> block = new ArrayList<>(suspect.subList(0, si / 2));
                for (int i = 0; i < block.size(); i++) {
                    int[] su = suspect.get(i);
                    city.block(su[0] - 1, su[1]);
                    city.block(su[0], su[1] - 1);
                    city.block(su[0], su[1] + 1);
                    city.block(su[0] + 1, su[1]);
                }
                suspect = ((ask() == -1) ? new ArrayList<>(block) : new ArrayList<>(suspect.subList(si / 2, si)));
                si = suspect.size();
            }
            ans = ("! " +hus[0]+" "+hus[1]+" " + suspect.getFirst()[0] + " " + suspect.getFirst()[1]);
        }
        System.out.println(ans);
    }

    public static int ask() {
        System.out.println("?");
        System.out.println(city.toString());
        try {
            int i = Integer.parseInt(br.readLine());
            //System.err.println(i);
            city = null;
            city = new City(n, og);
            asks[c] = i;
            c++;
            return i;
        } catch (IOException e) {
            System.err.println("Error");
            System.err.flush();
            return 0;
        }

    }

}
