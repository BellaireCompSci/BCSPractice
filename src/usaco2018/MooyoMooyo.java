package usaco2018;

import java.util.*;
import java.io.*;

public class MooyoMooyo
{
    static String[][] arr; 
    public static void main (String args[]) throws IOException {
        Scanner sc = new Scanner(new File("src/usaco2018/mooyomooyo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo"
                + ".out")));
        int n=sc.nextInt();//intake
        int lim=sc.nextInt();
        arr= new String[n][10];
        sc.nextLine();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLine().split("");
        }
 
        gravity(); //me being paranoid
        boolean change = true; //check if the array changed when we iterate over it with floodfill
        while(change){
            change=false;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    if(!arr[i][j].equals("0")){
                        String [][] temparr = new String[arr.length][];//if we ended up floodfilling when we weren't supposed to, this is the original
                        for(int k = 0; k < arr.length; k++)
                            temparr[k] = arr[k].clone();
                        if(fillGrid(i,j,arr[i][j])>=lim){ //fill if the limit is not exceeded
                            change=true;
                            i=j=0;
                        }
                        else{
                            arr=temparr;
                        }
                    }
                }
            }
            
            gravity(); //numbers fall back down
        }
        for(String[] x : arr){//print this stuff
            for(String y:x){
                out.print(y);
            }
            out.println();
        }
        out.close();
    }
    private static int fillGrid(int r, int c,String z) //literally generic floodfill, replace with 0
    {
        if (r<arr.length&&r>=0&&c>=0&&c<arr[0].length&&
                arr[r][c].equals(z))
        {
            arr[r][c] = "0";
 
            return 1+ fillGrid( r + 1, c,z)
            +fillGrid( r - 1, c,z)
            +fillGrid( r, c + 1,z)
            +fillGrid( r, c - 1,z);
        }
        return 0;
    }
    private static void gravity(){ //basically will find all the nonzero elements and then put them at the end of an array, simulating gravity
        for(int i=0;i<arr[0].length;i++){
            boolean valst=false;
            int num0 = 0;
            for(int j=0;j<arr.length;j++){
                if(!arr[j][i].equals("0"))valst = true;
                else if(valst == true) num0++;
            }
            String[] x = new String[arr.length];
            Arrays.fill(x,"0");
            int ind = x.length-1;
            for(int j=arr.length-1;j>=0;j--){
                if(!arr[j][i].equals("0")){
                x[ind]=arr[j][i];
                ind--;
                }
            }
            for(int j=0;j<arr.length;j++){
                arr[j][i]=x[j];
            }
        }
    }
}