package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Message {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/message.dat"));
		int N = in.nextInt();
		in.nextLine();

		int m;
        for(int n=0; n<N; n++) {
            m = in.nextInt();
            in.nextLine();
            String text = in.nextLine();
            for (String word : text.split("\\W+")) {
                if (word.length() == m) {
                    System.out.print(word + " ");
                }
            }
            System.out.println();
        }

		in.close();
	}
}
