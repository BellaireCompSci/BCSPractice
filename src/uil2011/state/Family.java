package uil2011.state;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Family {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2011/family.dat"));
		ArrayList<ArrayList<String>> generations = new ArrayList<>();
        String source, relationship, destination;
		while (in.hasNextLine()) {
		    String[] data = in.nextLine().split(" ");
		    source = data[0];
		    relationship = data[1];
		    destination = data[2];
		    
		    int sourceGen = getGeneration(generations, source);
		    int destGen = getGeneration(generations, destination);
		    if (sourceGen == -1 && destGen == -1) {
		        addPerson(source, 0, generations);
		        sourceGen = 0;
		    }
		    if (sourceGen == -1) {
		        if ("MOTHER FATHER".contains(relationship)) {
	                addPerson(source, destGen-1, generations);
	            } else if ("DAUGHTER SON".contains(relationship)) {
	                addPerson(source, destGen+1, generations);
	            } else if ("SISTER BROTHER WIFE HUSBAND".contains(relationship)) {
	                addPerson(source, destGen, generations);
	            }
		    } else if (destGen == -1) {
		       if ("MOTHER FATHER".contains(relationship)) {
                    addPerson(destination, sourceGen+1, generations);
               } else if ("DAUGHTER SON".contains(relationship)) {
                   addPerson(destination, sourceGen-1, generations);
               } else if ("SISTER BROTHER WIFE HUSBAND".contains(relationship)) {
                   addPerson(destination, sourceGen, generations);
               }
		    }
		    
		}
		// Output results
		for (int i=0; i<generations.size(); i++) {
            System.out.print(i+1);
            if (i==0) System.out.print("st");
            else if (i==1) System.out.print("nd");
            else if (i==2) System.out.print("rd");
            else System.out.print("th");
            System.out.print(" Generation:");
            
            Collections.sort(generations.get(i));
            for (int j=0; j<generations.get(i).size(); j++) {
                System.out.print(" " + generations.get(i).get(j));
            }
            System.out.println();
        }
		in.close();
	}
	
	private static int getGeneration(ArrayList<ArrayList<String>> generations, String name) {
	    for (int i=0; i<generations.size(); i++)
	        if (generations.get(i).contains(name)) return i;
	    return -1;
	}
	
	private static void addPerson(String name, int genNum, ArrayList<ArrayList<String>> generations) {
	    if (genNum == -1) {
	        generations.add(++genNum, new ArrayList<String>());
	    } else if (genNum >= generations.size()) {
	        generations.add(new ArrayList<String>());
	    }
	    
	    generations.get(genNum).add(name);
	}
}
