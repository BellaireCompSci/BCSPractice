package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Unique {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/unique.dat"));
		int N = in.nextInt();
		in.nextLine();

		// Generate list of primes
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		boolean isPrime;
		for (int i=2; i<=2099; i++) {
		    isPrime = true;
		    for (int prime: primes) {
		        if (i % prime == 0) {
		            isPrime = false;
	                break; 
		        }
		    }
		    if (isPrime) primes.add(i);
		}
		for(int n=0; n<N; n++) {
			int num = in.nextInt();
			System.out.print(num + " ");
			if (!primes.contains(num)) {
			    System.out.println("NOT A PRIME YEAR");
			    continue;
			}
			System.out.print("PRIME YEAR");
			int consecutives = 0;
			// Check consecutive primes
			for (int i=0; i<primes.size()-1; i++) {
			    int sum = primes.get(i) + primes.get(i+1);
			    int count = 2;
			    while (sum < num) {
			        sum += primes.get(i+count++);
			    }
			    if (sum == num) {
			        if (consecutives > 0) {
			            System.out.println(" AND THE SUM OF MORE THAN ONE SET OF CONSECUTIVE PRIMES");
			            consecutives = 0;
			            break;
			        } else {
			            consecutives = count;
			        }
			    }
			}
			if (consecutives > 0) {
			    System.out.println(" AND THE SUM OF " + consecutives + " CONSECUTIVE PRIMES");
			} else {
			    System.out.println();
			}
		}

		in.close();
	}
}
