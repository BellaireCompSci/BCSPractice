package uil2012district1.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FastMile {
    // CHANGE FILE NAME FOR EACH PROBLEM!
    private static final String inputFileName = "fastmile.dat";
    private static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        // Set up scanner to get input from file
        in = new Scanner(new File(inputFileName));
        // Read the number of test cases from first line
        int numCases = in.nextInt();
        // Read any other input variables at top of input file here

        // Move to next line for test cases
        in.nextLine();
        // Loop through each test case
        for(int caseNum=0; caseNum<numCases; caseNum++) {
            String name = in.next();
            String[] current = in.nextLine().split(" ");
            Arrays.sort(current);
            System.out.println(name + " " + current[1]);
        }
        in.close();
    }
}
