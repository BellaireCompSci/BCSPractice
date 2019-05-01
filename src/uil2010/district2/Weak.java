package uil2010.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Weak {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2010/weak.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			String password = in.nextLine();
			password = password.toLowerCase();
			if (Pattern.compile("\\d").matcher(password).find() &&
		        Pattern.compile("[aeiou]").matcher(password).find() &&
		        Pattern.compile("[b-df-hj-np-tv-z]").matcher(password).find() &&
		       !Pattern.compile("[aeiou]{3}").matcher(password).find() && 
		        password.length() >= 8) {
			    System.out.println("VALID");
			} else {
			    System.out.println("WEAK");
			}
		}
		in.close();
	}
}
