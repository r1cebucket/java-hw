import java.util.Scanner;

public class RestaurantMenu {

	public static double itemCost(char item) {
		switch (item) {
			case 'H':
				return 5.25;
			case 'F':
				return 2.50;
			case 'C':
				return 7.00;
			case 'M':
				return 3.75;
			case 'B':
				return 6.25;
			case 'S':
				return 1.25;
			default:
				System.out.println("Invalid menu item");
				return 0.;
		}
	}

	public static void main(String[] args) {

		/*
		 * you probably want to use user input for the
		 * menu item using Scanner
		 * I've written some code that will get the
		 * menu item code and read it in as a char
		 */

		Scanner in = new Scanner(System.in);
		char item;
		double total = 0.;
		while (true) {
			System.out.print("Enter menu item: ");
			item = in.next().charAt(0);
			if (item == 'X') {
				break;
			}
			if (itemCost(item) == 0.) {
				continue;
			}
			total += itemCost(item);
			System.out.printf("Total = 	$%.2f\n", total);
		}
		System.out.printf("Order complete. Total is $%.2f\n", total);
		in.close();
	}
}
