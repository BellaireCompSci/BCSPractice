package uil2012.district2.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Elite {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/uil2012/elite.dat"));
        int N = in.nextInt();
        in.nextLine();
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int n = 1; n < 1500; n += 2) {
            sequence.add(n);
        }

        int iteration = 2;
        while (sequence.get(iteration - 1) < sequence.size()) {
            int ithElement = sequence.get(iteration - 1);
            for (int i = sequence.size() - 1; i > 0; i--) {
                if ((i + 1) % ithElement == 0) {
                    sequence.remove(i);
                }
            }
            iteration++;
        }

        for (int n = 0; n < N; n++) {
            if (sequence.contains(in.nextInt())) {
                System.out.println("ELITE");
            } else {
                System.out.println("NOT ELITE");
            }
        }
        in.close();
    }
}
