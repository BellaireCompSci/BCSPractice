package uil2010.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Room {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2010/room.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			int R=in.nextInt(), C=in.nextInt();
			char[][] house = new char[R][C];
			for (int r=0; r<R; r++) {
			    String row = in.next();
			    for (int c=0; c<C; c++) {
			        house[r][c] = row.charAt(c);
			    }
			}
			for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    if (house[r][c] == '@') {
                        house[r][c] = '.';
                        int count = floodFillCount(house, '.', '#', r, c);
                        System.out.printf("$%d\n", count);
                    }
                }
			}
		}
		in.close();
	}

	private static int floodFillCount(char[][] mat, char toReplace, char newVal, int r, int c) {
	    if (r<0 || r>=mat.length || c<0 || c>=mat[0].length) return 0;
	    if (mat[r][c] != toReplace) return 0;

	    mat[r][c] = newVal;
	    return 1 + floodFillCount(mat, toReplace, newVal, r + 1, c)
	             + floodFillCount(mat, toReplace, newVal, r - 1, c)
	             + floodFillCount(mat, toReplace, newVal, r, c + 1)
	             + floodFillCount(mat, toReplace, newVal, r, c - 1);
	  }

}
