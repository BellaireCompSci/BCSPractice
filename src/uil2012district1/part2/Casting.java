package uil2012district1.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Casting {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/casting.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			String numStr = in.nextLine();
			for (int i=0; i<numStr.length(); i++) {
			}
			int count = 0;
			while (numStr.length() > 1) {
			    numStr = castOut(numStr);
			    count++;
			}
			System.out.println(count);
		}

		in.close();
	}
	
	private static String castOut(String numStr) {
	    int total = 0;
	    for (int i=0; i<numStr.length(); i++) {
	        total += Integer.valueOf("" + numStr.charAt(i));
        }
	    return "" + total;
	}
}
