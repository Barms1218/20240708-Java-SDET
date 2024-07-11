package Java;

// Java program to show multiple
// type parameters in Java Generics
// Example provided by GeeksForGeeks.com

// We use < > to specify Parameter type
class Test<T, U> {
    T obj1; // An object of type T, can become any type, hence generic
    U obj2; // An object of type U, can become any type, hence generic

    // constructor
    Test(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

public class GenericQA {
    public static void main(String[] args) {
        // Call Test constructor and send in data types to make objects
        Test<String, Integer> obj = new Test<String, Integer>("GfG", 15);
        Test<Boolean, Double> obj2 = new Test<Boolean, Double>(true, 32.1);

        obj.print();
        obj2.print();
    }
}
