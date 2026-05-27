/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b;

/**
 *
 * @author Simon
 */
public class Berg implements Comparable<Berg>{
    int diff,alt;
    //String name;
    boolean fav=false;

    public Berg(int diff, int alt) {
        this.diff = diff;
        this.alt = alt;
    }

    @Override
    public int compareTo(Berg o) {
        return (this.diff==o.diff)?(Integer.compare(o.alt, this.alt)):(Integer.compare(o.diff, this.diff));
    }
    
    
}
