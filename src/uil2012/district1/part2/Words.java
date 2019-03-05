package uil2012.district1.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/uil2012/words.dat"));
        int N = in.nextInt();
        in.nextLine();
        for(int n=0; n<N; n++) {
            String[] name = in.nextLine().split(" ");
            for (int i=0; i<name.length; i++) {
                if (i==0) System.out.print(name[i]);
                else System.out.print(" " + name[i].charAt(0));
            }
            System.out.println();
        }

        in.close();
    }
}
