/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package horror;

/**
 *
 * @author Simon
 */
public class Movie implements Comparable<Movie>{
    int id;
    int h;

    public Movie(int id, int h) {
        this.id = id;
        this.h = h;
    }
    @Override
    public int compareTo(Movie o) {
        return Integer.compare(o.h, h)==0?Integer.compare(id,o.id):Integer.compare(o.h, h);
    }
    
    
}
