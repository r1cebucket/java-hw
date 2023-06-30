import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ListOfNumbers {

    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;

    public ListOfNumbers() {
        // create an ArrayList of Pairs of Integers
        this.rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    }

    public ListOfNumbers(String fileName) {
        this();
        this.fileName = fileName; // output
    }

    public ArrayList<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
        return this.rdfTripleList;
    }

    public void createList() {
        for (int i = 0; i < 100; i++) {
            Integer number1 = (int) (Math.random() * 10000);
            Integer number2 = (int) (Math.random() * 10000);
            Integer number3 = (int) (Math.random() * 10000);
            // fill the existing list with RDFTriple objects
            // of three numbers.
            rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(number1, number2, number3));
        }
    }

    public void readList(String fileName) {
        rdfTripleList.clear();
        File f = new File(fileName);
        Scanner s = null;

        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String str = s.nextLine();

                String[] numbers = str.split(" ");
                Integer number1 = Integer.parseInt(numbers[0]);
                Integer number2 = Integer.parseInt(numbers[1]);
                Integer number3 = Integer.parseInt(numbers[2]);
                // fill the existing list with RDFTriple objects
                // of three numbers.
                rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(number1, number2, number3));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (s != null) {
                System.out.println("Closing Scanner");
                s.close();
            } else {
                System.out.println("Scanner not open");
            }
        }

    }

    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " +
                        rdfTripleList.get(i).getPred() + " "
                        + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + fileName);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ListOfNumbers listOfNumbers;
        // a
        listOfNumbers = new ListOfNumbers("outFile.txt");
        listOfNumbers.createList();
        listOfNumbers.writeList();
        ListOfNumbers.cat("outFile.txt");

        // b
        listOfNumbers = new ListOfNumbers("outFile.txt");
        listOfNumbers.readList("numberfile.txt");
        listOfNumbers.writeList();
        ListOfNumbers.cat("outFile.txt");
    }

}
