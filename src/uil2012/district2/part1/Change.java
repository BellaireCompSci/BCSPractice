package uil2012.district2.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Change {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/change.dat"));
		int nCases = in.nextInt();
		in.nextLine();
		for(int caseNum=0; caseNum<nCases; caseNum++) {
			int m = in.nextInt();
			int nWays = 0;
			for (int n = 0; n*5 < m; n++)
			    for (int d = 0; n*5+d*10 < m; d++)
                    for (int q = 0; n*5+d*10+q*25 < m; q++)
                        for (int h = 0; n*5+d*10+q*25+h*50 < m; h++)
                            nWays++;
			System.out.println(nWays);
		}

		in.close();
	}
}
