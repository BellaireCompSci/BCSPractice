package uil2012.district2.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cell {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/cell.dat"));
		int aTotal = 0, bTotal = 0, m, s;
		while (in.hasNext()) {
		    String[] numStrs = in.nextLine().split("\\.");
		    m = Integer.valueOf(numStrs[0]);
		    s = Integer.valueOf(numStrs[1]);
		    aTotal += m;
		    bTotal += m;
		    if (s > 0) bTotal++;
		}

		System.out.println("PLAN A: " + aTotal);
	    System.out.println("PLAN B: " + bTotal);
		
		in.close();
	}
}
