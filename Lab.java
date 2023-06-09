import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int i = input.nextInt();
        // double[] a = new double[i];

        // System.out.println(a[0]);

        // int a = 1;
        // double b = a / 2.;
        // System.out.println(b);
        double[] a = { 1., 2., 3. };
        // // System.out.println(a.length);

        // for (double b : a) {
        // System.out.println(b);
        // }

        // System.arraycopy(args, 0, a, 0, 0);

        // int[] t1 = { 1, 2, 3 };
        // int[] t2 = t1;

        // changeVal(t2);
        // System.out.println(t1[0]);
        // System.out.println(t2[0]);

        printNums(1., 2., 3.);

    }

    public static void printNums(double... nums) {
        for (double num : nums) {
            System.out.println(num);
        }
    }

    public static void changeVal(int[] a) {
        a[0] = -1;
    }
}
