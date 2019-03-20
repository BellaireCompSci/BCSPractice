package uil2012.district2.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Interlocked {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/interlocked.dat"));
		int N = in.nextInt();
		in.nextLine();
		String w1, w2, w3;
		for(int n=0; n<N; n++) {
			w1 = in.next();
			w2 = in.next();
			w3 = in.next();
			
			if (areInterlocked(w1, w2, w3)) {
			    System.out.println("YES");
			} else {
			    System.out.println("NO");
			}
		}

		in.close();
	}
	
	private static boolean areInterlocked(String str1, String str2, String str3) {
	    if (!isConsecutive(str1, str3) || !isConsecutive(str2, str3)) {
	        return false;
	    }
	    
	    HashSet<Character> multiChars = moreThanOnce(str1);
	    multiChars.addAll(moreThanOnce(str2));
	    return moreThanOnce(str3).containsAll(multiChars);
	}
	
	private static HashSet<Character> moreThanOnce(String str) {
	    HashSet<Character> result = new HashSet<>();
	    char c;
	    for (int i=0; i<str.length(); i++) {
	        c = str.charAt(i);
	        if (str.indexOf(c) != str.lastIndexOf(c)) {
	            result.add(c);
	        }
	    }
	    return result;
	}
	
	private static boolean isConsecutive(String str1, String str2) {
        int index;
	    while(str1.length() > 0) {
	        index = str2.indexOf(str1.charAt(0));
            if (index == -1) {
                return false;
            }
            str1 = str1.substring(1);
            str2 = str2.substring(index);
        }
	    return true;
	}
}
