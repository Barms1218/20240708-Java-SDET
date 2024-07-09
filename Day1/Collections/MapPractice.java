package Java.Day1.Collections;

import java.util.HashMap;

public class MapPractice {
    public static void main(String[] args) {
        /**
         * MAPS unordered and operates on key-value pairs key has to be 100% unique
         * value can be anything
         * 
         * 
         * HASHMAPS Uses a hashcode to determine index location creates constant lookup
         * time of O(1) built on arrays
         * 
         * COLLISIONS Technically should not happen but can happens when multiple keys
         * have the same hashcode and get put into the same index location -> Java
         * creates a linked-list at that index location -> Under the hood, our hashmaps
         * are arrays of linked-lists.
         */

        HashMap<String, Animal> animalMap = new HashMap<>();
        Animal lion = new Animal("leo");
        Animal dog = new Animal("kuma");
        Animal turtle = new Animal("tilly");

        animalMap.put("lion", lion);
        animalMap.put("dog", dog);
        animalMap.put("turtle", turtle);

        animalMap.get("lion");

        System.out.println(animalMap.get("lion"));
        Animal lion2 = new Animal("leonardo");
        animalMap.put("lion", lion2);
        System.out.println(animalMap);
    }
}
