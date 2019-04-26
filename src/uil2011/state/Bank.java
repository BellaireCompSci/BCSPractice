package uil2011.state;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/uil2011/bank.dat"));
        String date = in.next();
        int year, month, day;
        year = getYear(date);
        month = getMonth(date);
        day = getDay(date);
        Double balance = in.nextDouble();
        
        while (in.hasNext()) {
            String nextDate = in.next();
            while (year<getYear(nextDate) || month<getMonth(nextDate) || day<getDay(nextDate)) {
                // Increase one day
                day++;
                if (day > 31) {
                    month++;
                    day = 1;
                    balance *= 1.02;
                }
                if (month == 13) {
                    year++;
                    month = 1;
                }
            }
            balance += in.nextDouble();
        }
        
        System.out.printf("$%.2f\n", (double)((int) (balance*100))/100); // truncate to 2 places

        in.close();
    }
    
    private static int getYear(String date) {
        return Integer.parseInt(date.split("-")[0]);
    }
    
    private static int getMonth(String date) {
        return Integer.parseInt(date.split("-")[1]);
    }
    
    private static int getDay(String date) {
        return Integer.parseInt(date.split("-")[2]);
    }
}
