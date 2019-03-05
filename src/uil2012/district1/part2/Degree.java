package uil2012.district1.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Degree {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/degree.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
		    String[] numStrs = in.nextLine().split(" ");
		    int[] nums = new int[numStrs.length];
		    for (int i=0; i<nums.length; i++) {
		        nums[i] = Integer.parseInt(numStrs[i]);
		    }
		    int degree = 0;
		    for (int i=0; i<nums.length; i++) {
		        for (int j=i+1; j<nums.length; j++) {
		            if (nums[j] < nums[i]) degree++;
		        }
		    }
		    System.out.println(degree);
		}

		in.close();
	}
}
