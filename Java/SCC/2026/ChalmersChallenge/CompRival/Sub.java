/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b;

/**
 *
 * @author Simon
 */
public class Sub implements Comparable<Sub>{
    int  s,t;

    public Sub( int s, int t) {
        //his.p = p;
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Sub o) {
        return Integer.compare(this.t, o.t);
    }
    
    
}
