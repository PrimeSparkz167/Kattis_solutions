/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fyrtorn;

import java.util.Comparator;
import java.util.HashSet;

/**
 *
 * @author Simon
 */
public class Comp implements Comparator {

    public Comp() {
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        HashSet<Integer> h1=(HashSet<Integer>)o1;
        HashSet<Integer> h2=(HashSet<Integer>)o2;
        
        return Integer.compare(h2.size(), h1.size());
    }
    
}
