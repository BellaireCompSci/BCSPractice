package uil2012.district2.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashCodes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/hashcodes.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			System.out.println(nCollisions(in.nextInt(), in.nextInt()));
		}

		in.close();
	}
	
	private static int nCollisions(int w, int h) {
	    int count = 0;
	    if (w==2) {
        	    for (int a=1; a<=26; a++) {
        	        for (int b=a+1; b<=26; b++) {
        	            if (a+b == h) count++;
        	        }
        	    }
	    } else if (w==3) {
            for (int a=1; a<=26; a++) {
                for (int b=a+1; b<=26; b++) {
                    for (int c=b+1; c<=26; c++) {
                        if (a+b+c == h) count++;
                    }
                }
            }
	    } else if (w==4) {
            for (int a=1; a<=26; a++) {
                for (int b=a+1; b<=26; b++) {
                    for (int c=b+1; c<=26; c++) {
                        for (int d=c+1; d<=26; d++) {
                            if (a+b+c+d == h) count++;
                        }
                    }
                }
            }
	    } else if (w==5) {
            for (int a=1; a<=26; a++) {
                for (int b=a+1; b<=26; b++) {
                    for (int c=b+1; c<=26; c++) {
                        for (int d=c+1; d<=26; d++) {
                            for (int e=d+1; e<=26; e++) {
                                if (a+b+c+d+e == h) count++;
                            }
                        }
                    }
                }
            }
	    }
	    return count;
	}
}
