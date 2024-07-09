package Java.Day1.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPractice {
    /**
     * LISTS ordered Collections AP in Java - all lists will inherit from the List
     * class ONLY WORK WITH OBJECTS
     * 
     * Java gives you wrapper classes for primitive types - int -> Integer - double
     * -> Double - etc.
     */

    public static void main(String[] args) {
        /**
         * ARRAY LISTS dynamic array - grows as you add more data to it. Recreates the
         * array when bounds are exceeded Does not go both ways. Resizing down is manual
         * rather than automatic the starting capacity is 10 by default but it can be
         * changed. Capacity is the amount of memory, not elements Once full it will
         * grow by 50% 10 -> 15 -> 23 -> 35 Lookup is O(1) in time complexity with the
         * index. Insertion is constant at the end of the array. Not constant if there
         * is resizing, otherwise it's O(n) If inserting into the middle the time
         * complexity is O(n)
         */

        ArrayList<String> fruits = new ArrayList<>();

        // Adding to an arraylist
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("strawberry");
        fruits.add("pomegranate");
        fruits.add("mango");
        fruits.add("mango");

        fruits.add(0, "banana");

        System.out.println(fruits.get(0));

        // ArrayLists can resize down using the trimToSize() method
        fruits.removeIf(n -> n == "mango");
        System.out.println(fruits);

        System.out.println(fruits.indexOf("mango")); // Print the index of the object mango

        System.out.println(fruits);

        /**
         * LINKED-LISTS non-consecutive memory locations each node contains at least one
         * pointer to the next node and the data at that node no indexes, meaning no
         * insertion or removal in the middle. lookup complexity is O(n) Insertion at
         * the front is O(1) while anywhere else is O(n). Still faster than ArrayList a
         * little bit More memory efficient than an arraylist Capacity always equals
         * size, thus the better memory efficiency Java linked-lists are always doubly
         * linked Not as good as arraylists if the size is constant with frequent
         * looping
         */

        LinkedList<String> nameLinkedList = new LinkedList<>();
        nameLinkedList.add("Caroline");
        nameLinkedList.add("Bryar");
        nameLinkedList.add("Bruna");

        System.out.println(nameLinkedList.get(0));
    }
}
