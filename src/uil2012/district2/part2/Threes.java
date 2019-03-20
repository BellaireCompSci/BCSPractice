package uil2012.district2.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Threes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/threes.dat"));
		int N = in.nextInt();
		in.nextLine();
		
		int num=0, times=0;
		for(int n=0; n<N; n++) {
		    num = in.nextInt();
		    times = 1;
		    while (!onlyThreesAndZeroes(num*times))
                times++;
		    System.out.println(num*times);
		}

		in.close();
	}
	private static boolean onlyThreesAndZeroes(int num) {
	    while (num>0) {
	        if (!(num%10==0 || num%10==3)) return false;
	        num /= 10;
	    }
	    return true;
	}
}
