import java.util.*;
import java.io.IOException;

public class StudentMarksManagementSystem{
	
	static String[] stIdArray = new String[0];
	static String[] stNameArray = new String[0];
	static int[] dbmsMarksArray = new int[0];
	static int[] plfMarksArray = new int[0];

//Add Student
	public static void addStudent(){
		
		
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						ADD NEW STUDENT                                                     |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		String[] tempStIdArray = new String[stIdArray.length+1];
		String[] tempStNameArray = new String[stNameArray.length+1];
		int[] tempDbmsMarksArray = new int[dbmsMarksArray.length+1];
		int[] tempPlfMarksArray = new int[plfMarksArray.length+1];
		
		for(int i = 0; i < stIdArray.length; i++){
			tempStIdArray[i] = stIdArray[i];
			tempStNameArray[i] = stNameArray[i];
			tempDbmsMarksArray[i] = dbmsMarksArray[i];
			tempPlfMarksArray[i] = plfMarksArray[i];
		}
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input Student Id : ");
		String stId = input.nextLine();
	
		if(searchStudentId(stId)!= -1){
			
			System.out.println(stId +" is exist...");	
		}
		else{
			int indexOfLast = tempStIdArray.length-1; //index of last element (to be added)
			tempStIdArray[indexOfLast] = stId;
			System.out.print("Input Student Name : ");
			tempStNameArray[indexOfLast] = input.nextLine();
			
			tempDbmsMarksArray[indexOfLast] = -1;
			tempPlfMarksArray[indexOfLast] = -1;
			
			stIdArray = tempStIdArray;
			stNameArray = tempStNameArray;
			dbmsMarksArray = tempDbmsMarksArray;
			plfMarksArray = tempPlfMarksArray;
			
		}
		
		System.out.println();
		System.out.print("Student has been added successfully. Do you want to add a new student? (Y/n) ");
		String op = input.nextLine();
		System.out.println();
		switch(op){
											 
			case "Y" :
			case "y" :addStudent();
			break;
											
			default : clearConsole(); break;				
		}
		System.out.println();	
	}
	

//Add Student with Marks
	public static void addStudentWithMarks(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						ADD STUDENT WITH MARKS                                              |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		String[] tempStIdArray = new String[stIdArray.length+1];
		String[] tempStNameArray = new String[stNameArray.length+1];
		int[] tempDbmsMarksArray = new int[dbmsMarksArray.length+1];
		int[] tempPlfMarksArray = new int[plfMarksArray.length+1];
		
		for(int i = 0; i < stIdArray.length; i++){
			
			tempStIdArray[i] = stIdArray[i];
			tempStNameArray[i] = stNameArray[i];
			tempDbmsMarksArray[i] = dbmsMarksArray[i];
			tempPlfMarksArray[i] = plfMarksArray[i];
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("Input Student Id : ");
		String stId = input.nextLine();
	
		if(searchStudentId(stId)!= -1){
			
			System.out.println(stId+" is exist...");
		}
		else{
			int indexOfLast = tempStIdArray.length-1; //index of last element (to be added)
			tempStIdArray[indexOfLast] = stId;
			
			System.out.print("Input Student Name : ");
			tempStNameArray[indexOfLast] = input.nextLine();
			
			System.out.print("Input marks Database Management Systems : ");
			tempDbmsMarksArray[indexOfLast] = input.nextInt();
			
			//If Database Management Systems marks is Invalid
			
			while(tempDbmsMarksArray[indexOfLast] > 100 || tempDbmsMarksArray[indexOfLast] < 0){
				
				System.out.println("Invalid marks, please enter correct marks.");
					
				System.out.print("Input Marks for Database Management Systems : ");
				tempDbmsMarksArray[indexOfLast] = input.nextInt();	
			}
				System.out.print("Input marks for Programming Fundamentals  : ");
				tempPlfMarksArray[indexOfLast] = input.nextInt();
			
			//If Programming Fundamentals marks is Invalid
			
			while(tempPlfMarksArray[indexOfLast] > 100 || tempPlfMarksArray[indexOfLast] < 0){
				
				System.out.println("Invalid marks, please enter correct marks.");
					
				System.out.print("Input Marks for Programming Fundamentals : ");
				tempPlfMarksArray[indexOfLast] = input.nextInt();	
			}
			
			stIdArray = tempStIdArray;
			stNameArray = tempStNameArray;
			dbmsMarksArray = tempDbmsMarksArray;
			plfMarksArray = tempPlfMarksArray;
			
			String op = input.nextLine();
				
		}
		
		System.out.println();
		System.out.print("Student has been added successfully. Do you want to add a new student? (Y/n) ");
		String op = input.nextLine();
		System.out.println();
		switch(op){
											 
			case "Y" :
			case "y" : addStudentWithMarks();
			break;
											
			default : clearConsole(); break;				
		}	
	}


//Add Marks

	public static void addMarks(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						ADD MARKS                                                           |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Student Id : ");
		String stId = input.nextLine();
		
		int index = searchStudentId(stId);
		
		if(index == -1){
			System.out.println(stId+" is not exist..");	
		}
		else if(dbmsMarksArray[index] == -1){
			
			//Input marks for Database Management Systems
		
			System.out.print("Input marks for Database Management Systems : ");
			dbmsMarksArray[index] = input.nextInt();
			
			while(dbmsMarksArray[index] > 100 || dbmsMarksArray[index] < 0){
				
				System.out.println("Invalid marks, please enter correct marks.");
					
				System.out.print("Input Marks for Database Management Systems : ");
				dbmsMarksArray[index] = input.nextInt();
			}
			
			//Input marks for Programming Fundamentals
			
			System.out.print("Input marks for Programming Fundamentals : ");
			plfMarksArray[index] = input.nextInt();
			
			while(plfMarksArray[index] > 100 || plfMarksArray[index] < 0){
				
				System.out.println("Invalid marks, please enter correct marks.");
					
				System.out.print("Input Marks for Programming Fundamentals : ");
				plfMarksArray[index] = input.nextInt();
			}
			
			String op = input.nextLine();			
			
		}
		else{
			System.out.println("Aleready added marks...");
		}
		
		System.out.println();
		
		System.out.println();
		System.out.print("Marks has been added. Do you want to add marks for another student? (Y/n) ");
		String op = input.nextLine();
		switch(op){
			case "y" :addMarks();break;
			case "Y": addMarks();break;
			default : clearConsole(); break;
		}
		System.out.println();
	}
	
	
//Update Student details

	public static void updateStudentDetails(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						UPDATE STUDENT DETAILS                                              |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input student ID : ");
		String stId=input.nextLine();
		int index = -1;
		
		for(int i=0; i<stIdArray.length; i++){
			if(stId.equalsIgnoreCase(stIdArray[i])){
				index = i;
				break;
			}
		}
		if(index >= 0){
			System.out.print("Input new name : ");
			String name = input.nextLine();
			stNameArray[index] = name;
		}else{
			System.out.println(stId+" is not exists..");
		}
		
		System.out.println();
		
		System.out.println("Student details has been updated successfully.");
		System.out.print("Do you want to update another student details? (Y/n) ");
		String op = input.nextLine();
		switch(op){
			case "y" :updateStudentDetails();break;
			case "Y": updateStudentDetails();break;
			default : clearConsole(); break;
		}
		System.out.println();				
	}
	
	
//Update Marks

	public static void updateStudentMarks(){
		
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						UPDATE MARKS                                                        |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input student ID : ");
		String stId = input.nextLine();
		int index = -1;
		
		for(int i=0; i < stIdArray.length; i++){
			if(stId.equalsIgnoreCase(stIdArray[i])){
				index = i;
				break;
			}
		}
		if(index >= 0){
			
			System.out.print("Input marks for Database Management Systems : ");
				dbmsMarksArray[index] = input.nextInt();
				
				while ((dbmsMarksArray[index]) < 0 ||(dbmsMarksArray[index]) > 100){
					System.out.println("Invalid marks,Please enter correct marks");
					System.out.print("Input Marks For Database Management Systems : ");
					dbmsMarksArray[index] = input.nextInt();
				}
				System.out.print("Input marks for Programming Fundamentals : ");
				plfMarksArray[index] = input.nextInt();
				
				while((plfMarksArray[index] > 100) || (plfMarksArray[index] < 0)){
					System.out.println("Invalid marks,Please enter correct marks");
					System.out.print("Input Marks for Programming Fundamentals : ");
					plfMarksArray[index] = input.nextInt();
					
					String op = input.nextLine();
				}
		}
		else{
			System.out.println(stId+" is not exists..");
		}
		
		System.out.println();
		
		System.out.println("Marks has been updated successfully.\n");
		System.out.print("Do you want to update marks for another student? (Y/n) ");
		String op = input.nextLine();
		switch(op){
			case "y" :updateStudentDetails();break;
			case "Y": updateStudentDetails();break;
			default : clearConsole(); break;
		}
		System.out.println();
	} 
	
	
//Delete Student Id

	public static void deleteStudentId(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|							DELETE STUDENT                                              |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		Scanner input = new Scanner(System.in);
		String op;
			
		System.out.print("Input Students id : ");		
		String stId = input.nextLine();
		
		System.out.print("Do you want to delete student (" +stId+ ") (Y/n): ");
		op = input.nextLine();
		switch(op){
											 
			case "Y" :
			case "y" :
			
			int index = searchStudentId(stId);
		
			if(index == -1){
				System.out.println(stId + " is not exist...");
			
			}
			else{
				for(int i = index; i < stIdArray.length-1; i++){
					
				stIdArray[i] = stIdArray[i+1];
			}
			
			String[] tempStIdArray = new String[stIdArray.length-1];
					
			System.out.println("Student Has been deleted successfully\n");
					
				for (int i = 0; i < tempStIdArray.length; i++){
						
					tempStIdArray[i] = stIdArray[i];
				}
				stIdArray = tempStIdArray;
			}
			
			break;
											
			default : break;
		}
		System.out.print("Do you want to delete another student (Y/n): ");
		op = input.nextLine();
		switch(op){
										 
			case "Y" :
			case "y" :deleteStudentId();
			break;
										
			default : clearConsole(); break;	
		}
		System.out.println();
		
	}

	
//Search Student

	public static int searchStudentId(String stId){
		
		for (int i = 0; i < stIdArray.length; i++){
			if(stId.equalsIgnoreCase(stIdArray[i])){
				return i;
			}
		}
		return -1;
	}
	
	

//Print Student Details

	public static void printStudentDetails(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						PRINT STUDENT DETAILS                                               |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
		String[] tempStIdArray = new String[stIdArray.length+1];
			
		for(int i = 0; i < stIdArray.length; i++){
			
			tempStIdArray[i] = stIdArray[i];
		}
		
		Scanner input = new Scanner(System.in);
			
		System.out.print("Input Students id : ");		
		String stId = input.nextLine();
		tempStIdArray[tempStIdArray.length-1] = stId;
		
		System.out.println("Student ID\tStudent Name\tDatabase Marks\tProgramming Marks");
		
		for (int i = 0; i < stIdArray.length; i++){
			if(stId.equalsIgnoreCase(stIdArray[i])){
			System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ dbmsMarksArray[i] +"\t\t"+ plfMarksArray[i]);}
		}
		System.out.println();
		
		System.out.println();
		System.out.print("Do you want to search another Student details(y/n): ");
		String op = input.nextLine();
		switch(op){
			case "y" :printStudentDetails();break;
			case "Y": printStudentDetails();break;
			default : clearConsole(); break;
		}
	}
		
//Print Student Rank

	public static void studentRank(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						PRINT STUDENT RANK                                                  |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
		
			System.out.println("Student ID\tStudent Name\tDatabase Marks\tProgramming Marks");
			
			for (int i = 0; i < stIdArray.length - 1; i++){
			
				if(dbmsMarksArray[i] + plfMarksArray[i] > dbmsMarksArray[i+1] + plfMarksArray[i+1]){
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ dbmsMarksArray[i] +"\t\t"+ plfMarksArray[i]);
				}
				else{
					System.out.println(stIdArray[i+1] +"\t\t"+ stNameArray[i+1] +"\t\t"+ dbmsMarksArray[i+1] +"\t\t"+ plfMarksArray[i+1]);
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ dbmsMarksArray[i] +"\t\t"+ plfMarksArray[i]);
				}
			}
		
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Do you want to go back to main menu?(y/n): ");
		String op = input.nextLine();
		switch(op){
			case "y":
			case "Y": 
			default : clearConsole(); break;	
		}
		System.out.println();
	}
		
//Best in programming fundermentals

	public static void bestInPlf(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						BEST IN PROGRAMMING FUNDERMENTALS                                   |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
			
			System.out.println("Student ID\tStudent Name\tDatabase Marks\tProgramming Marks");
			
			for (int i = 0; i < stIdArray.length-1; i++){
				
				if(plfMarksArray[i] > plfMarksArray[i+1]){
						
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ plfMarksArray[i] +"\t\t"+ dbmsMarksArray[i]);
				}
				else{
					System.out.println(stIdArray[i+1] +"\t\t"+ stNameArray[i+1] +"\t\t"+ plfMarksArray[i+1] +"\t\t"+ dbmsMarksArray[i+1]);
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ plfMarksArray[i] +"\t\t"+ dbmsMarksArray[i]);
				}
			}
		
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Do you want to go back to main menu?(y/n): ");
		String op = input.nextLine();
		switch(op){
			case "y":
			case "Y": 
			default : clearConsole(); break;	
		}
		System.out.println();
	}
			
//Best in database manegment system

	public static void bestInDbms(){
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						BEST IN DATABASE MANEGMENT SYSTEM                                   |");
		System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		
			
			System.out.println("Student ID\tStudent Name\tDatabase Marks\tProgramming Marks");
			
			for (int i = 0; i < stIdArray.length-1; i++){
				if(dbmsMarksArray[i] > dbmsMarksArray[i+1]){
						
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ dbmsMarksArray[i] +"\t\t"+ plfMarksArray[i]);
				}
				else{
					System.out.println(stIdArray[i+1] +"\t\t"+ stNameArray[i+1] +"\t\t"+ dbmsMarksArray[i+1] +"\t\t"+ plfMarksArray[i+1]);
					System.out.println(stIdArray[i] +"\t\t"+ stNameArray[i] +"\t\t"+ dbmsMarksArray[i] +"\t\t"+ plfMarksArray[i]);
				}
			}
		
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Do you want to go back to main menu?(y/n): ");
		String op = input.nextLine();
		switch(op){
			case "y":
			case "Y": 
			default : clearConsole(); break;
		}
		System.out.println();
	}
	
	
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}
		catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	

	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);		
		String op;
		
		do{
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.println("|				WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                                             |");
			System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
			
			System.out.print("[1] Add New Student");
			System.out.println("			[2]  Add New Student With Marks");
			System.out.print("[3] Add Marks ");
			System.out.println("				[4]  Update Student Details");
			System.out.print("[5] Update Marks");
			System.out.println("			[6]  Delete Student ");
			System.out.print("[7] Print Student Details");
			System.out.println("		[8]  Print Student Ranks");
			System.out.print("[9] Best in Programming Fundamentals");
			
			System.out.println("	[10] Best in Database Management System");
			System.out.println("");
			System.out.print("Enter an option to continue > ");
			
			op = input.nextLine();
			
			switch(op){
				case "1" : clearConsole(); addStudent(); break;
				case "2" : clearConsole(); addStudentWithMarks(); break;
				case "3" : clearConsole(); addMarks(); break;
				case "4" : clearConsole(); updateStudentDetails(); break;
				case "5" : clearConsole(); updateStudentMarks(); break;
				case "6" : clearConsole(); deleteStudentId(); break;
				case "7" : clearConsole(); printStudentDetails(); break;
				case "8" : clearConsole(); studentRank(); break;
				case "9" : clearConsole(); bestInPlf(); break;
				case "10": clearConsole(); bestInDbms(); break;
				
				default : System.exit(0);
			}
		}while(true);
	}
}

