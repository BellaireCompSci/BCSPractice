package uil2012.district1.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Boggle {
    // CHANGE FILE NAME FOR EACH PROBLEM!
    private static final String inputFileName = "data/uil2012/boggle.dat";
    private static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        // Set up scanner to get input from file
        in = new Scanner(new File(inputFileName));
        // Read the number of test cases from first line
        int numCases = in.nextInt();
        in.nextLine();
        // Loop through each test case
        for(int caseNum=0; caseNum<numCases; caseNum++) {
            // Read letters
            char[][] letters = new char[4][4];

            for (int i=0; i<4; i++) {
                String row = in.nextLine();
                for (int j=0; j<4; j++) {
                    letters[i][j] = row.charAt(j);
                }
            }
            // Read found words
            int wordCount = in.nextInt();
            int score = 0;
            for (int i=0; i<wordCount; i++) {
                String word = in.next();
                if (isWordFound(letters, word)) {
                    System.out.println(word);
                    score += getScore(word);
                }
            }
            System.out.printf("PUZZLE #%d: %d\n", caseNum+1, score);
            in.nextLine();
        }
        in.close();
    }

    private static boolean isWordFound(char[][] letters, String word) {
        for (int i=0; i<letters.length; i++) {
            for (int j=0; j<letters[i].length; j++) {
                if (isWordAtLoc(letters, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isWordAtLoc(char[][] letters, String word, int r, int c) {
        if (r<0 || r>3 || c<0 || c>3) return false;
        if (letters[r][c] != word.charAt(0)) return false;
        if (word.length() == 1) return true;
        
        letters = makeCopy(letters);
        letters[r][c] = ' ';
        String newWord = word.substring(1);
        return isWordAtLoc(letters, newWord, r+1, c) ||
               isWordAtLoc(letters, newWord, r-1, c) ||
               isWordAtLoc(letters, newWord, r, c+1) ||
               isWordAtLoc(letters, newWord, r, c-1) ||
               isWordAtLoc(letters, newWord, r+1, c+1) ||
               isWordAtLoc(letters, newWord, r+1, c-1) ||
               isWordAtLoc(letters, newWord, r-1, c+1) ||
               isWordAtLoc(letters, newWord, r-1, c-1);
    }
    
    private static int getScore(String word) {
        int len = word.length();
        if (len < 3) return 0;
        if (len < 5) return 1;
        if (len < 6) return 2;
        if (len < 7) return 3;
        if (len < 8) return 5;
        return 11;
    }
    
    private static char[][] makeCopy(char[][] orig) {
        char[][] newArr = new char[orig.length][orig[0].length];
        for (int i=0; i<orig.length; i++) {
            for (int j=0; j<orig[i].length; j++) {
                newArr[i][j] = orig[i][j];
            }
        }
        return newArr;
    }
}
