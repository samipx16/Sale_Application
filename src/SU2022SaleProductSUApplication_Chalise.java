// File SU2022SaleProductSUApplication_Chalise.java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class SU2022SaleProductSUApplication_Chalise {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		int i = 99;  
		// Declaring the int array to store different cup sizes!
		
		float arrayPrice[] = {11.29f,12.79f,13.59f};
		int transactionNum =0;
		while(i != 0) {
			System.out.println(" File: SU2022SaleProductSU_Application_Chalise.java\r\n"
					+ " PRODUCT SU SHOP MAIN MENU – SAMIP CHALISE \r\n"
					+ " Current Date: 06/02/2022\r\n"
					+ " -----------------------------------------------\r\n"
					+ " 1.	Sale Product SU\r\n"
					+ " 2.	Ending Day Sale Report\r\n"
					+ " 3.	Compare Sale In Two Days Report\r\n"
					+ " 0.	Exit\r\n"
					+ " Enter a number from 1 to 3 to select a task:\r\n"
					+ "");
			
			int option = keyboard.nextInt();
			// Declaring variables used in  option 1 of the menu.
			int sum1 =0; // units of small cups!
			int sum2 =0; // units of medium cups!
			int sum3 =0; // units of large cups!
			
			// Declaring the intial units for cups.
			int smallCup=0;
			int mediumCup =0;
			int bigCup = 0;
			int counter1 =0;
			int counter2 =0;
			int counter3 =0;
			// Declaring array to contain the number of cups choose during the loop!!
			int numSmallCup[] = new int [20];
			int numMediumCup[] = new int [20];
			int numBigCup[] = new int [20];
			transactionNum++;
			// Sale Product SU!!
			if(option ==1) {
				
				
				int sizeloop = 99;
				while(sizeloop != 0) {
					
					// Printing the menu of cup sizes
					System.out.println("\n\nSU2022SaleProductSU_Application_Chalise.java\r\n"
							+ "PRODUCT SU MENU - SAMIP CHALISE\r\n"
							+ "Today: 06/02/2022\r\n"
							+ "-----------------------------\r\n"
							+ "1.SMALL  - $11.29\r\n"
							+ "2.MEDIUM - $12.79\r\n"
							+ "3.LARGE  - $13.59\r\n"
							+ "0.Exit\r\n"
							+ "Enter a number from 1 to 3 to select product size: \r\n"
							+ "");
					int productSize = keyboard.nextInt();
					
					
					
					if (productSize == 1) {
						System.out.println("Enter the number of units you want: ");
						smallCup = keyboard.nextInt();
					
						numSmallCup[counter1]=smallCup;
						counter1++; 
						  // increasing the counter to increase the field.
						
				
					}
					else if (productSize == 2) {
						System.out.println("Enter the number of units you want: ");
						mediumCup = keyboard.nextInt();
						numMediumCup[counter2]=mediumCup;
						counter2++;
						
						
					}
					else if (productSize == 3) {
						System.out.println("Enter the number of units you want: ");
						bigCup = keyboard.nextInt();
						numBigCup[counter3]=bigCup;
						counter3++;
						
					}
					else if(productSize == 0) {
						break; // Exit the cup menu
					}
					else {
						System.out.println("Invalid Option!!");
					}
				} // While loop end brace
				
				
				
				for(int i1= 0;i1 < counter1;i1++) {
					sum1 = sum1+ numSmallCup[i1];
				}
				
				
				for(int i2= 0; i2 < counter2;i2++) {
					sum2 = sum2+ numMediumCup[i2];
				}
				
				
				for(int i3= 0; i3 < counter3;i3++) {
					sum3 = sum3+ numBigCup[i3];
				}
							
				int arrayUnit []= {sum1,sum2,sum3};
				
				// Creating an object of data type class!
				SU2022ProductSU_Chalise reporting = new SU2022ProductSU_Chalise(arrayUnit, arrayPrice);
				// Asking user for amount to be paid!
				
				
				reporting.getTotal();
				System.out.println("Enter the amount you want to pay: ");
				float amount = keyboard.nextFloat();
				System.out.println(reporting.getReceipt(amount,transactionNum));
				reporting.toFile(transactionNum);
				// Upto this point result print successful!
				
			}// if option 1 loop end brace
			
			
			// Getting the day Report!!
			else if(option ==2) {
				// Write code here
				System.out.println("Enter the name of the file: ");
			
				String fileName = keyboard.next();
				String[] parts = fileName.split("_");
				String part1 = parts[0];
				String part2 = parts[1];
				
				String[] dater =part2.split(".txt");
				String actualDate = dater[0];  // Date acquired out of file name!!
				String month = actualDate.substring(0,2);
				String day = actualDate.substring(2,4);
				String year = actualDate.substring(4,8);
				String finalDate = month+"/"+day+"/"+year;
				
				// Creating an array to store the data
				int sumSmall =0;
				int sumMedium =0;
				int sumLarge =0;
				int[] arrayTotalUnits = new int[3];
				File file = new File(fileName);
				// creating a loop to read file
				if (file.exists()) {
					FileInputStream file1 = new FileInputStream(fileName);
					BufferedReader each = new BufferedReader(new InputStreamReader(file1));	
					String strLine;					
					while ((strLine = each.readLine()) != null)   {						
						  String[] cups = strLine.split(" ");
						  int smallCups = Integer.parseInt(cups[1]);
						  int mediumCups = Integer.parseInt(cups[2]);
						  int largeCups = Integer.parseInt(cups[3]);
						  sumSmall = sumSmall+ smallCups;
						  sumMedium = sumMedium + mediumCups;
						  sumLarge = sumLarge + largeCups;
						  
						}
					//Storing the total units in arrayUnitTotal!!
					arrayTotalUnits[0]= sumSmall;
					arrayTotalUnits[1]= sumMedium;
					arrayTotalUnits[2]= sumLarge;
					
				    
				    file1.close();
				 
				  SU2022ProductSU_Chalise reporting = new SU2022ProductSU_Chalise(arrayTotalUnits, arrayPrice);
				  System.out.println(reporting.printReport(finalDate));
					}
					
				}
				
			// Comparing the reports!!
			else if(option ==3) {
				// File1
				System.out.println("Enter the name of the first file: ");
				String fileName1 = keyboard.next();
				String[] parts = fileName1.split("_");
				String part1 = parts[0];
				String part2 = parts[1];
				
				String[] dater1 =part2.split(".txt");
				String actualDate1 = dater1[0];  // Date acquired out of file name!!
				String month = actualDate1.substring(0,2);
				String day = actualDate1.substring(2,4);
				String year = actualDate1.substring(4,8);
				String finalDate1 = month+"/"+day+"/"+year;
				
				// File2
				System.out.println("Enter the name of the Second file: ");
				String fileName2 = keyboard.next();
				String[] slip = fileName2.split("_");
				String slip1 = slip[0];
				String slip2 = slip[1];
				
				String[] dater2 =slip2.split(".txt");
				String actualDate2 = dater2[0];  // Date acquired out of file name!!
				String month2 = actualDate2.substring(0,2);
				String day2 = actualDate2.substring(2,4);
				String year2 = actualDate2.substring(4,8);
				String finalDate2 = month2+"/"+day2+"/"+year2;
				
				
				// Date format for two different files acquired from above steps!!
				
				
				
				int[] arrayTotalUnits1 = new int[3];
				File file = new File(fileName1);
				// creating a loop to read file
				if (file.exists()) {
					int sumSmall1 =0;
					int sumMedium1 =0;
					int sumLarge1 =0;
					
					FileInputStream file1 = new FileInputStream(fileName1);
					BufferedReader each = new BufferedReader(new InputStreamReader(file1));	
					String strLine;					
					while ((strLine = each.readLine()) != null)   {						
						  String[] cups = strLine.split(" ");
						  int smallCups = Integer.parseInt(cups[1]);
						  int mediumCups = Integer.parseInt(cups[2]);
						  int largeCups = Integer.parseInt(cups[3]);
						  sumSmall1 = sumSmall1+ smallCups;
						  sumMedium1 = sumMedium1+ mediumCups;
						  sumLarge1 = sumLarge1 + largeCups;
						  
						}
					//Storing the total units in arrayUnitTotal!!
					arrayTotalUnits1[0]= sumSmall1;
					arrayTotalUnits1[1]= sumMedium1;
					arrayTotalUnits1[2]= sumLarge1;
					
				    
				    file1.close();
					}
				
				SU2022ProductSU_Chalise reporting1 = new SU2022ProductSU_Chalise(arrayTotalUnits1, arrayPrice);
				reporting1.printReport(finalDate1);
				int[] arrayTotalUnits2 = new int[3];
				File file2 = new File(fileName2);
				// creating a loop to read file
				if (file2.exists()) {
					int sumSmall2 =0;
					int sumMedium2 =0;
					int sumLarge2 =0;
					
					FileInputStream file3 = new FileInputStream(fileName2);
					BufferedReader each = new BufferedReader(new InputStreamReader(file3));	
					String strLine;					
					while ((strLine = each.readLine()) != null)   {						
						  String[] cups = strLine.split(" ");
						  int smallCups = Integer.parseInt(cups[1]);
						  int mediumCups = Integer.parseInt(cups[2]);
						  int largeCups = Integer.parseInt(cups[3]);
						  sumSmall2 = sumSmall2+ smallCups;
						  sumMedium2 = sumMedium2 + mediumCups;
						  sumLarge2 = sumLarge2 + largeCups;
						  
						}
					//Storing the total units in arrayUnitTotal!!
					arrayTotalUnits2[0]= sumSmall2;
					arrayTotalUnits2[1]= sumMedium2;
					arrayTotalUnits2[2]= sumLarge2;
					
				    
				    file3.close();
				  
					}
				
				
				SU2022ProductSU_Chalise reporting2 = new SU2022ProductSU_Chalise(arrayTotalUnits2, arrayPrice);
				// Printing the comparing reports!!
				System.out.print(reporting2.compareReport(arrayTotalUnits1,arrayTotalUnits2,arrayPrice,finalDate1,finalDate2));
							
			}
				
			//Exit the program
			else if(option ==0) {
				System.out.print("You've Exited the Program!!");
				break;
			}
			
			
		}
	}

	
}

	




