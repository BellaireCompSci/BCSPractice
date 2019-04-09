package uil2011.district2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class XML {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2011/xml.dat"));
		int N = Integer.parseInt(in.nextLine());
		
		for(int n=0; n<N; n++) {
			Stack<String> tags = new Stack<>();
			int M = Integer.parseInt(in.nextLine());			
			
			for (int m=0; m<M; m++) {
			    String str = in.nextLine();
			    if(str.startsWith("</")) {
			        if(!tags.pop().equals(str.replace("/",""))) {
			            System.out.println("invalid");
			            
			            break;
			            
			        }
			    }
			    else if (str.startsWith("<")) {
			        if(str.startsWith("<")) {
			            tags.push(str);
			        }
			       
			    }
			    if(m==M-1)System.out.println("valid");
			}
			
		}

		in.close();
	}
}
