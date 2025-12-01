/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hemligvandring;

/**
 *
 * @author Simon
 */
public class City {
    int[][] map; //0=.
    String[] smap;
    int n;

    public City(int n) {
        this.n=n;
        map = new int[n][n];
        smap = new String[n];
    }
    public City(int n, String[] og){//reset
        this.n = n;
        map = new int[n][n];
        smap=new String[n];
        smap[0] = og[0];
        for (int i = 1; i < n; i+=2) {
            smap[i]=og[i];
            smap[i+1]=og[i+1];
            for (int j = 1; j < n; j+=2) {
                map[i][j]=2;
            }
        }
    }
    
    public void updatesmap(){
        
    }
    public void edit(int r, int c, int i){
        map[r][c]=i;
        smap[r] = smap[r].substring(0, c) + itoc(i) + smap[r].substring(c+1);
    }
    public void block(int r, int c){
        if (r>=0&&r<n&&c>=0&&c<n) {
        map[r][c]=1;
        smap[r] = smap[r].substring(0, c) + '#' + smap[r].substring(c+1);
        }
    }
    /*
    public boolean[][] A(){//we should change to boolean matrix
        boolean[][] A = new boolean[n*n][n*n];//maybe do the same trick as in bio?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int spot =i*n+j;
                if (map[i][j]!=1) {
                    if (j>0) {//can go left/decrease j
                        A[spot][spot-1] = (map[i][j-1]!=1);
                    }
                    if (i>0) {//can go up/decrease i
                        A[spot][spot-n] = (map[i-1][j]!=1);
                        
                    }
                    if (j<n-1) {//can go right/ increase j
                        A[spot][spot+1] = (map[i][j+1]!=1);
                    }
                    if (i<n-1) {// can go down/increase i
                        A[spot][spot+n] = (map[i+1][j]!=1);
                    }
                }
            }
        }
        return A;
    }
    public boolean[][] atok(boolean[][] A , int k){//binary matrix multiplication for symmetric matrices;
        boolean [][] Ak = A;//A a must be size nxnxnxn
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n*n; j++) {
            }
        }
        return Ak;
}*/
    
    public int[] stringtoints(String s){
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i]= ctoi(s.charAt(i));
        }
        return ans;
    }
    public char itoc(int i){
        return switch (i) {
            case  1-> '#';
            case 2 -> 'H' ;
            default -> '.';
        };
    }
    
    public int ctoi(char c){
        return switch (c) {
            case '.' -> 0;
            case '#' -> 1;
            case 'H' -> 2;
            default -> 3;
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < smap.length-1; i++) {
            sb.append(smap[i]).append("\n");
        }
        sb.append(smap[smap.length-1]);
        return sb.toString();
    }
    
    
}

