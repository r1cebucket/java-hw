import java.util.*;
import vehicles.Vehicle;

public class Lab extends LabParent {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        System.out.println(v1.getID());
        System.out.println(v2.getID());
    }
}
