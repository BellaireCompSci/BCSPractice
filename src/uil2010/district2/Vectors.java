package uil2010.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vectors {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2010/vectors.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			Scanner numScan = new Scanner(in.nextLine());
			numScan.useDelimiter("[(,) ]+");
			int xTotal = 0;
			int yTotal = 0;
			do {
			    xTotal += numScan.nextInt();
			    yTotal += numScan.nextInt();
			} while (numScan.hasNextInt());
			System.out.printf("(%d,%d)\n", xTotal, yTotal);
		}

		in.close();
	}
}
