package usaco2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Convention2 {
    public static void main(String args[]) throws IOException {
        BufferedReader sc = new BufferedReader(new FileReader("data/usaco2018/convention2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));

        int n = Integer.parseInt(sc.readLine());
        ArrayList<cow> cows = new ArrayList<cow>();
        for (int i = 0; i < n; i++) { // intake
            String[] x = sc.readLine().split(" ");
            cows.add(new cow(i, Integer.parseInt(x[0]), Integer.parseInt(x[1])));
        }
        int ff = 0; // ff is my total time
        int r = findshort(cows); // first cow to step up to the plate
        int maxqt = -1; // the most amunt of time that a cow how to wait
        while (!cows.isEmpty()) { // iterate until its over
            if (maxqt < ff - cows.get(r).start) // if a cow is arrived but theres already something
                                                // in its way
                maxqt = ff - cows.get(r).start;
            if (ff > cows.get(r).start) // if theres a cow when a cow arrives then you can just add
                                        // the time to the time that the first cow will finish
                ff += cows.get(r).time;
            else {
                ff = cows.get(r).start + cows.get(r).time; // if the field is open when the cow
                                                           // arrives, then the time is just when
                                                           // the cow finishes normally
            }
            cows.remove(r); // make the linear search shorter
            r = findnextq(cows, ff); // find the next cow with the highest priority
        }

        out.println(maxqt);
        out.close();
    }

    private static int findshort(List<cow> a) { // just finds the cow with the first start, class
                                                // name is misnomer
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).start < min) {
                min = a.get(i).start;
                ind = i;
            }
        }
        return ind;
    }

    private static int findnextq(List<cow> a, int time) { // performs a linear search. I have a
                                                          // feeling they wanted us to use
                                                          // comparator to
        int min = Integer.MAX_VALUE; // sort by priority and starting time but I didn't figure that
                                     // part out
        int ind = -1; // Writing that, I realized I could sort it by time and then set the current
                      // time
        for (int i = 0; i < a.size(); i++) { // as a threshold so any element before that time would
                                             // be selected, and out of
            if (a.get(i).start < time) { // those selected, I could choose the one with highest
                                         // priority. whatever
                return i;
            } else if (a.get(i).start < min) {
                ind = i;
                min = a.get(i).start;
            }
        }
        return ind;
    }
}


class cow { // make an object that stores 3 integers, pr ended up being useless
    int pr = 0, start = 0, time = 0;

    cow(int a, int b, int c) {
        pr = a;
        start = b;
        time = c;
    }
}
