package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MostLeast {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/mostleast.dat"));
		int N = in.nextInt();
		in.nextLine();
		HashMap<String, Integer> wordCounts;
        for(int n=0; n<N; n++) {
            wordCounts = new HashMap<String, Integer>();
            String text = in.nextLine();
            String[] words = text.split("\\W+");
            // Fill hashmap with counts
            for (String word : words) {
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word)+1);
                } else {
                    wordCounts.put(word, 1);
                }
                
            }
            
            // Find min and max frequency
            int most=0, least = wordCounts.size();
            ArrayList<String> leastStrs = new ArrayList<>();
            ArrayList<String> mostStrs = new ArrayList<>();
            for (String word : wordCounts.keySet()) {
                int count = wordCounts.get(word);
                if (count > most) {
                    most = count;
                    mostStrs = new ArrayList<>();
                } 
                if (count < least) {
                    least = count;
                    leastStrs = new ArrayList<>();
                }
                
                if (count == most) mostStrs.add(word);
                if (count == least) leastStrs.add(word);
            }
            
            Collections.sort(mostStrs);
            Collections.sort(leastStrs);
            
            // Most
            System.out.print(most + " ");
            for (String word : mostStrs) {
                System.out.print(word + " ");
            }
            System.out.println();
            // Least
            System.out.print(least + " ");
            for (String word : leastStrs) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

		in.close();
	}
}
