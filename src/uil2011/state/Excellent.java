package uil2011.state;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Excellent {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2011/excellent.dat"));
		int p = in.nextInt();
		int q = in.nextInt();
		in.nextLine();
		
		ArrayList<String> sheet1 = new ArrayList<>();
		ArrayList<String> sheet2 = new ArrayList<>();
		
		for (int i=0; i<p; i++) {
		    sheet1.add(in.nextLine());
		}
		
		for (int i=0; i<q; i++) {
		    sheet2.add(in.nextLine());
		}
		
		Collections.sort(sheet1);
		Collections.sort(sheet2);
		
		System.out.println("NAMES IN SPREADSHEET 1 THAT ARE NOT IN SPREADSHEET 2");
		for (String s : sheet1) {
		    if (!sheet2.contains(s)) System.out.println(s);
		}
		
	    System.out.println("NAMES IN SPREADSHEET 2 THAT ARE NOT IN SPREADSHEET 1");
		for (String s : sheet2) {
            if (!sheet1.contains(s)) System.out.println(s);
        }
		in.close();
	}
}
