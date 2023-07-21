package PartII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
    public Set<E> intersection(Set<E> s2) {
        HashSet<E> inter = new HashSet<>();
        for (E e : s2) {
            if (this.contains(e)) {
                inter.add(e);
            }
        }
        return inter;
    }

    public Set<E> union(Set<E> s2) {
        HashSet<E> u = new HashSet<>(this);
        u.addAll(s2);
        return u;
    }

    public <T> Set<Pair<E, T>> cartesianProduct(Set<T> s2) {
        Set<Pair<E, T>> prod = new HashSet<Pair<E, T>>();
        for (E e : this) {
            for (T t : s2) {
                prod.add(new Pair<E, T>(e, t));
            }
        }
        return prod;
    }

    public static void main(String[] args) {
        // create two MathSet objects of the same type.
        // See if union and intersection works.

        // create another MathSet object of a different type
        // calculate the cartesian product of this set with one of the
        // above sets

        MathSet<Integer> s1 = new MathSet<Integer>();
        s1.addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
        MathSet<Integer> s2 = new MathSet<Integer>();
        s2.addAll(Arrays.asList(new Integer[] { 2, 3, 4, 5 }));
        System.out.println("s1: " + s1.toString());
        System.out.println("s2: " + s2.toString());

        Set<Integer> inter = s1.intersection(s2);
        Set<Integer> u = s1.union(s2);

        System.out.println("inter: " + inter.toString());
        System.out.println("union: " + u.toString());

        MathSet<Integer> s3 = new MathSet<Integer>();
        s3.addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
        MathSet<String> s4 = new MathSet<String>();
        s4.addAll(Arrays.asList(new String[] { "car", "bus", "bike", "helicopter" }));
        System.out.println("s3: " + s3.toString());
        System.out.println("s4: " + s4.toString());

        Set<Pair<Integer, String>> prod = s3.cartesianProduct(s4);
        System.out.println("cartesian product: " + prod.toString());
    }
}
