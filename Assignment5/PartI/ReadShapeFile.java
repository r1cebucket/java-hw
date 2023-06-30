import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shape) throws ShapeException {
		/*
		 * if vehicleName is "Circle" return Circle();
		 * if vehicleName is "Rectangle" return Rectangle();
		 * if vehicleName is "Square" return Square();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		switch (shape) {
			case "Circle":
				return new Circle();
			case "Rectangle":
				return new Rectangle();
			case "Square":
				return new Square();
			default:
				throw new ShapeException();
		}
		// return null;
	}

	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");

		String inString = null;

		/* create a loop to read the file line-by-line */
		Scanner input;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			return;
		}

		while (input.hasNext()) {
			inString = input.next();
			try {
				GeometricObject shape = createShape(inString);
				shapeList.add(shape);
			} catch (ShapeException e) {
				System.err.println("Cannot create Shape: " + inString);
			}
		}

		input.close();

		System.out.println(shapeList);
	}
}
