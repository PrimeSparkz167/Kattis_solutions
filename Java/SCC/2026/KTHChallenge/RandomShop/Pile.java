/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b;

/**
 *
 * @author Simon
 */
public class Pile implements Comparable<Pile>{
    int c;
    //int d;
    int diff;

    public Pile(int c) {
        this.c = c;
        //d=0;
    }
    public void set(int in){
        //this.d=in;
        diff=in-c;
    }
    

    @Override
    public int compareTo(Pile o) {
        return Integer.compare(this.c, o.c);
    }
    
}
