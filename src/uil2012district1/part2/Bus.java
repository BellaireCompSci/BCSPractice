package uil2012district1.part2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus {

    private static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File("data/uil2012/bus.dat"));
        int buses = in.nextInt();
        in.nextLine();
        for (int i = 0; i < buses; i++) {
            String[] bus = in.nextLine().split(" ");
            int[] busNums = new int[bus.length];
            for (int j = 0; j < bus.length; j++) {
                busNums[j] = Integer.parseInt(bus[j]);
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(busNums[0]);
            for (int k = 1; k < busNums.length-1; k += 2) {
                int sum = list.get(k/2) + busNums[k] + busNums[k + 1];
                list.add(sum);
            }
            int smol = list.get(0); // no 'a's allowed
            for(int x : list) {
                if(x < smol) {
                    smol = x;
                }
            }
            for(int c = 0; c < list.size(); c++) {
                if(list.get(c) == smol) {
                    char pos = (char)('A' + c);
                    System.out.print(pos);
                    System.out.print(" ");
                }
            }
            System.out.println(smol);
        }
    }

}
