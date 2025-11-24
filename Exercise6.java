package lab04;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercise6 {
	
	public static void main(String[] args) throws IOException{
		
		File file = new File("D:\\School work\\PDI_Lab04\\CandidatePerformanceTest.csv");
		
		FileReader fr = new FileReader(file);	
		Scanner scan = new Scanner(file);
		
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
		
		String data;
		int counter = 0;
		int male = 0, female = 0;
		String array[];
		int Avg = 0, MAvg = 0;
		int Score = 0;
		int MA = 0, MB = 0, MC = 0, MD = 0, ME = 0;
		int A = 0, B = 0, C = 0, D = 0, E = 0;
		
		while (scan.hasNext()) {
			data = scan.nextLine();
			array = data.split(",");
			
			//System.out.println(array[1]);
			if (array[1].equalsIgnoreCase("male") || array[1].equalsIgnoreCase("M")) {
				//System.out.println(array[1]);
				male++;
				if(array[2].equalsIgnoreCase("group A")) {
			          MA++;
			        }
			        if(array[2].equalsIgnoreCase("group B")) {
			          MB++;
			        }
			        if(array[2].equalsIgnoreCase("group C")) {
			          MC++;
			        }
			        if(array[2].equalsIgnoreCase("group D")) {
			          MD++;
			        }
			        if(array[2].equalsIgnoreCase("group E")) {
			          ME++;
			        }
			}
			if (array[1].equalsIgnoreCase("female") || array[1].equalsIgnoreCase("F")) {
				//System.out.println(array[1]);
				female++; 
			}
			counter ++;	
			if(array[2].equalsIgnoreCase("group A")) {
				A++;
	        }
		    if(array[2].equalsIgnoreCase("group B")) {
		    	B++;
	        }
	        if(array[2].equalsIgnoreCase("group C")) {
	        	C++;
	        }
	        if(array[2].equalsIgnoreCase("group D")) {
	        	D++;
	        }
	        if(array[2].equalsIgnoreCase("group E")) {
	        	E++;
	        }
			
			if (Double.parseDouble(array[9]) >= 90) {
				Avg++;
				if(array[1].equalsIgnoreCase("male")||array[1].equalsIgnoreCase("M")) { 
					 MAvg++;
				 }
			}
			if(Double.parseDouble(array[5]) >= 85||Double.parseDouble(array[6]) >= 85||Double.parseDouble(array[7]) >= 85) { 
				 Score++;
			}
		}	
		
		//Type casting
		double Pmale = ((double) male/counter ) * 100; double Pfmale = ((double) female/counter) * 100;
		double MpAvg = ((double) MAvg/Avg) * 100; double FpAvg = 100 - MpAvg;
		double MAavg = (float) (MA*100) / A; double FAavg = 100-MAavg;
		double MBavg = (float) (MB*100) / B; double FBavg = 100-MBavg;
		double MCavg = (float) (MC*100) / C; double FCavg = 100-MCavg;
		double MDavg = (float) (MD*100) / D; double FDavg = 100-MDavg;
		double MEavg = (float) (ME*100) / E; double FEavg = 100-MEavg;
		
		
		
		
		System.out.println("----------------------------------------");
		System.out.println("Total Student: " + counter);
		System.out.printf("\nMale: " + male + "\nPercentage of male Student: %.2f %c \n", Pmale, 37);
		System.out.printf("\nFemale: " + female + "\nPercentage of female Student: %.2f %c \n", Pfmale, 37);
		
		System.out.println("----------------------------------------");
		System.out.println("Student with an average score of 90 and above: "+ Avg + "Students");
		System.out.printf("Male: %.2f %c \n" , MpAvg ,37);
		System.out.printf("\nFemale: %.2f %c \n", FpAvg, 37);
		
		System.out.println("----------------------------------------");
		System.out.println("Student with an average score of 85 and above: "+ Score);
		
		System.out.printf("\nGroup A have: "+ A + " Students");
		System.out.printf("\nMale = %.2f %c \n", MAavg ,37);
		System.out.printf("Female = %.2f %c \n", FAavg ,37);
		
		System.out.printf("\nGroup B have: "+ B + " Students");
		System.out.printf("\nMale = %.2f %c \n", MBavg ,37);
		System.out.printf("Female = %.2f %c \n", FBavg ,37);
		
		System.out.printf("\nGroup C have: "+ C + " Students");
		System.out.printf("\nMale = %.2f %c \n", MCavg ,37);
		System.out.printf("Female = %.2f %c \n", FCavg ,37);
		
		System.out.printf("\nGroup D have: "+ D + " Students");
		System.out.printf("\nMale = %.2f %c \n", MDavg ,37);
		System.out.printf("Female = %.2f %c \n", FDavg ,37);
		
		System.out.printf("\nGroup E have: "+ E + " Students");
		System.out.printf("\nMale = %.2f %c \n", MEavg ,37);
		System.out.printf("Female = %.2f %c \n", FEavg ,37);
		
		scan.close(); 
	}
}	

