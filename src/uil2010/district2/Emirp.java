package uil2010.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emirp {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2010/emirp.dat"));
		do {
		    int a = in.nextInt();
		    int b = in.nextInt();
		    
		    boolean areAny = false;
		    for (int i=a; i<=b; i++) {
		        if (isEmirp(i)) {
		            System.out.print(i + " ");
		            areAny = true;
		        }
		    }
		    if (!areAny) System.out.print("NONE");
		    System.out.println();
		} while (in.hasNextInt());
		in.close();
	}
	
	private static boolean isEmirp(int num) {
	    if (!isPrime(num)) return false;

	    int forward = num;
	    int reverse = 0;
	    while (num > 0) {
	        reverse *= 10;
	        reverse += num%10;
	        num /= 10;
	    }
	    
	    if (forward == reverse) return false;
	    return isPrime(reverse);
	}
	
	private static boolean isPrime(int num) {
	    for (int div = 2; div<=(int)Math.sqrt(num); div++) {
	        if (num % div == 0) return false;
	    }
	    return true;
	}
}
