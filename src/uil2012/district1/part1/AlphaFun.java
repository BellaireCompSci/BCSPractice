package uil2012.district1.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AlphaFun {
	// CHANGE FILE NAME FOR EACH PROBLEM!
	private static final String inputFileName = "data/uil2012/alphafun.dat";
	private static Scanner in;

	public static void main(String[] args) throws FileNotFoundException {
		// Set up scanner to get input from file
		in = new Scanner(new File(inputFileName));
		ArrayList<String> words = new ArrayList<>();
		while (in.hasNext()) {
		    words.add(in.next());
		}
		words.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int firstCompare = o1.charAt(1) - o2.charAt(1);
                if (firstCompare != 0) return firstCompare;

                int secondCompare = (o1 + "  ").charAt(3) - (o2 + "  ").charAt(3);
                if (secondCompare != 0) return secondCompare;

                int thirdCompare = o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
                if (thirdCompare != 0) return thirdCompare;

                int fourthCompare = o1.charAt(0) - o2.charAt(0);
                if (fourthCompare != 0) return fourthCompare;
                
                return o1.compareTo(o2);
            }
		});
		for (String str : words) {
		    System.out.println(str);
		}
		in.close();
	}
}
