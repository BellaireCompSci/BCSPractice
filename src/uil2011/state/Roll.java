package uil2011.state;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Roll {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2011/roll.dat"));
		int N = in.nextInt();
        in.nextLine();

        for(int n=0; n<N; n++) {
            String str = in.nextLine();
            int gridSize = (int) Math.sqrt(str.length());
            char[][] grid = new char[gridSize][gridSize];
            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[i].length; j++) {
                    grid[i][j] = str.charAt(j+i*gridSize);
                }
            }
            for (int i=0; i<grid.length/2; i++) {
                shift(grid, i, i%2==0);
            }
            
            for (char[] row : grid) {
                for (char c : row) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
		in.close();
	}
	
	private static void shift(char[][] grid, int layer, boolean toLeft) {
	    if (!toLeft) {
	        int layerWidth = grid.length-layer*2;
	        for (int i=0; i<4*(layerWidth-2)+4-1; i++) {
	            shift(grid, layer, true);
	        }
	        return;
	    }
	    
	    // Rotate Left
	    char topLeft = grid[layer][layer];
	    // top
	    for (int i=layer; i<grid.length-layer-1; i++) {
	        grid[layer][i] = grid[layer][i+1];
	    }
	    // right
	    for (int i=layer; i<grid.length-layer-1; i++) {
            grid[i][grid.length-layer-1] = grid[i+1][grid.length-layer-1];
        }
	    // bottom
	    for (int i=grid.length-layer-1; i>layer; i--) {
            grid[grid.length-1-layer][i] = grid[grid.length-1-layer][i-1] ;
        }
	    // left
	    for (int i=grid.length-layer-1; i>layer; i--) {
	        grid[i][layer] = grid[i-1][layer];
	    }
	    grid[layer+1][layer] = topLeft;
	}
}
