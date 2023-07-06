import java.util.ArrayList;
import java.util.Collection;

public class MaxFinder {
        
        public T max() {

        }
        
        public void add(T t) {

                
        }
        
        public static void main (String[] args) {
                MaxFinder<Number> m = new MaxFinder<Number>();
                ComplexNumber n1 = new ComplexNumber(1,5);
                Integer a = new Integer(5);
                Double d= new Double(3.2);
                m.add(n1);
                m.add(a);;
                m.add(d);
                Number max = m.max();
                System.out.println("max for m is "+ max);
                MaxFinder<Integer> m1 = new MaxFinder<Integer>();
                Integer b = new Integer(10);
                Integer c = new Integer(20);
                Integer max1 = m1.max();
                System.out.println("max for m1 is "+ max1);
                
        }
        
}
