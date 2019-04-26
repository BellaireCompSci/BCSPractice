package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Unique {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("FILENAME.in"));
		int N = in.nextInt();
		in.nextLine();

		ArrayList<Integer> primes = new ArrayList<>();
		for (int i=2000; i<3000; i++) {
		    if (isPrime(i)) primes.add(i);
		}
		for(int n=0; n<N; n++) {
			
		}

		in.close();
	}
	
	private static boolean isPrime(int n) {
	    for (int i=2; i<=Math.ceil(Math.sqrt(n)); i++) {
	        if (n%i == 0) return false;
	    }
	    return false;
	}
}
