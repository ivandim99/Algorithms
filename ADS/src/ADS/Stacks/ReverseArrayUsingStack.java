package ADS.Stacks;

import java.util.Arrays;


/**
 * Reversing an array using a stack.
 * Using 2 for loops.
 * We create a buffer stack which will store the reversed array from the first array
 * and will pop its elements to the original array.
 */

public class ReverseArrayUsingStack {

    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new SimpleArrayBasedIplementation<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int j = 0; j < a.length; j++) {
            a[j] = buffer.pop();
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        String[] b = {"a", "b", "c", "d"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
        reverse(a);
        reverse(b);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
    }


}
