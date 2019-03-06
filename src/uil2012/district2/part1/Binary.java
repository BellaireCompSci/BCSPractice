package uil2012.district2.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Binary {
    private static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File("data/uil2012/binary.dat"));
        int N = in.nextInt();
        in.nextLine();
        int[] time;
        for (int n = 0; n < N; n++) {
            time = new int[6];
            for (int r = 0; r < 4; r++) {
                String row = in.nextLine();
                for (int c = 0; c < row.length(); c++) {
                    if (row.charAt(c) == '*') {
                        time[c] += Math.pow(2, 3 - r);
                    }
                }
            }
            System.out.printf("%d%d:%d%d:%d%d\n", time[0], time[1], time[2], time[3], time[4],
                    time[5]);
        }
    }
}

