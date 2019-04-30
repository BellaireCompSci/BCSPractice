package uil2012.regionals.part1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Emergency {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/uil2012/emergency.dat"));
		int N = in.nextInt();
		in.nextLine();

		for(int n=0; n<N; n++) {
			int numEntries, targetWait;
			numEntries = in.nextInt();
			targetWait = in.nextInt(); // in minutes
			List<Patient> patients = new ArrayList<>();
			for (int i=0; i<numEntries; i++) {
			    patients.add(new Patient(in.next(), in.nextInt()));
			}
			int numDocs = 3;
			while (getAvgWait(patients, numDocs) > targetWait) {
			    numDocs++;
			}
			System.out.println(numDocs + " doctors");
		}

		in.close();
	}
	
	private static int getAvgWait(List<Patient> patients, int numDocs) {
        PriorityQueue<Patient> waitingRoom = new PriorityQueue<>();
        PriorityQueue<Doctor> doctors = new PriorityQueue<>();
        for (int i=0; i<numDocs; i++) {
            doctors.add(new Doctor());
        }
        int time=0, patNum = 0, totalWait=0;
        while (time < 60*24) {
            while (patNum < patients.size() && patients.get(patNum).arrivalTime == time) {
                waitingRoom.add(patients.get(patNum++));
            }
            
            while (doctors.peek().availableAt <= time) {
                if (waitingRoom.size() == 0) break;
                Patient nextPatient = waitingRoom.peek();
                if (nextPatient.severity >= 8 ||
                    nextPatient.arrivalTime + 5 <= time) {
                    Doctor doc = doctors.poll();
                    doc.availableAt += nextPatient.severity * 8;
                    doctors.add(doc);
                    waitingRoom.poll();
                } else {
                    break;
                }
            }

            totalWait += waitingRoom.size();
            time++;
        }
        return totalWait / patients.size();
	}

	private static class Patient implements Comparable<Patient>{
	    public int arrivalTime, severity;
	    
	    public Patient(String timeString, int severity) {
	        arrivalTime = timeToMins(timeString);
	        this.severity = severity;
	    }

	    public int compareTo(Patient p) {
	        if (severity != p.severity)
	            return -(severity - p.severity);
	        return arrivalTime - p.arrivalTime;
	    }
	}
	
	private static class Doctor implements Comparable <Doctor> {
	    public int availableAt;
	    
	    public int compareTo(Doctor d) {
            return availableAt-d.availableAt;
        }
	}
	
	private static int timeToMins(String timeString) {
        int result = 0;
        String[] numStrs = timeString.split(":"); //hh:mm
        result =  Integer.valueOf(numStrs[0]) * 60;
        result += Integer.valueOf(numStrs[1]);
        return result;
    }
}
