package uil2011.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clock {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2011/clock.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			String[] time = in.nextLine().split(":");
			int h = Integer.parseInt(time[0]);
			int m = Integer.parseInt(time[1]);
			
			if (h<12) {
			    h = 12 - h - 1;
			    if (m == 0) h++;
			}
			
			if (m>0) {
			    m = 60 - m;
			}
			
			System.out.printf("%d:%02d\n", h, m);
		}

		in.close();
	}
}
