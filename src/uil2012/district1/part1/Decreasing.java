package uil2012.district1.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decreasing {
    // CHANGE FILE NAME FOR EACH PROBLEM!
    private static final String inputFileName = "data/uil2012/decreasing.dat";
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
            // Replace this with test case handling
            int origNum = in.nextInt();
            int num = origNum*2;
            while (!isDec(num)) {
                num += origNum;
            }
            System.out.println(num);
        }
        in.close();
        
       
    }
    private static boolean isDec(int num) {
        int lastDigit = num%10;
        num/=10;
        while(num>0)
        {
            if(num%10<lastDigit) {
                return false;
            }
            lastDigit = num%10;
            num/=10;
        }
        return true;
    }
}
