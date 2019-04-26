package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emergency {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/emergency.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			
		}

		in.close();
	}
}
