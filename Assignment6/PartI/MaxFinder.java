import java.util.ArrayList;

public class MaxFinder<T extends Number> {
    private ArrayList<T> array;
    private T maxVal;

    public MaxFinder() {
        array = new ArrayList<T>();
    }

    public T max() {
        return maxVal;
    }

    public void add(T t) {
        if (this.maxVal == null) {
            this.maxVal = t;
        } else if (t.doubleValue() > this.maxVal.doubleValue()) {
            this.maxVal = t;
        }
        this.array.add(t);
    }

    public static void main(String[] args) {
        MaxFinder<Number> m = new MaxFinder<Number>();
        ComplexNumber n1 = new ComplexNumber(1, 5);
        Integer a = Integer.valueOf(5);
        Double d = Double.valueOf(3.2);
        m.add(n1);
        m.add(a);
        m.add(d);
        Number max = m.max();
        System.out.println("max for m is " + max);
        MaxFinder<Integer> m1 = new MaxFinder<Integer>();
        Integer b = Integer.valueOf(10);
        Integer c = Integer.valueOf(20);
        Integer max1 = m1.max();
        System.out.println("max for m1 is " + max1);

    }

}
