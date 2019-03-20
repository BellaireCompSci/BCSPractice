package uil2012.district2.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Family {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/family.dat"));
		int N = in.nextInt();
		in.nextLine();

		char[][] pic = new char[18][12];
		for(int n=0; n<N; n++) {
			for (int r=0; r<18; r++) {
			    String row = in.nextLine();
			    for (int c=0; c<12; c++) {
			        pic[r][c] = row.charAt(c);
			    }
			}
			
			for (int c=0; c<12; c++) {
                for (int r=17; r>=0; r--) {
                    System.out.print(pic[r][c]);
                }
                System.out.println();
            }
		}

		in.close();
	}
}
