/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author nikhilv85
 */
import java.util.Arrays;

class Item implements Comparable<Item> {
    public int value;

    public Item(int value) {
	this.value = value;
    }

    public int compareTo(Item item) {
	// Compare both value fields.
	return Integer.compare(this.value, item.value);
    }

    public String toString() {
	return String.valueOf(value);
    }
}

