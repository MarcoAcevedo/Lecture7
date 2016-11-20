import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Parsers {//Lee data y genera un objeto que representa la data

	public static void main (String[] args) {
		ArrayList<Student> result = parseStudentsCSV("data/students.csv");
		System.out.println("\n\nStudents found in file: ");
		System.out.println("ID,Name,Email,GPA");
		saveStudentsCSV("data/output.csv",result);
	}

	public static void parseIntList(String filename) {
		File inputFile = new File(filename);
		try {
			Scanner inputScanner = new Scanner(inputFile);
			int count = 0;
			int sum = 0;
			while (inputScanner.hasNextInt()) {
				int nextNumber = inputScanner.nextInt();
				count++;
				sum += nextNumber;
				System.out.println("Next Number (" + count + "): " + nextNumber);
			}
			System.out.println("Sum =  " + sum);

		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: File not Found");
		}
	}

	public static ArrayList<Student> parseStudentsCSV(String filename) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		File inputFile = new File(filename);
		try {
			Scanner inputScanner = new Scanner(inputFile);
			String headerLine = inputScanner.nextLine();
			inputScanner.useDelimiter("[,\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				System.out.println("Next ID: " + ID);
				String name = inputScanner.next();
				System.out.println("Next name: "+ name);
				String email = inputScanner.next();
				System.out.println("Email: "+ email);
				String gpa = inputScanner.next();
				System.out.println("GPA: "+ gpa);
				double gpaDouble = Double.parseDouble(gpa);
				
				Student nextStudent = new Student(ID,name,email,gpaDouble);
				students.add(nextStudent);
				//String restOfLine = inputScanner.nextLine();
			}
			
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input File not Found");
		}
		return students;
	}
	
	static public void saveStudentsCSV(String filename, ArrayList<Student> students){
		File outputFile = new File(filename);
		try{
			PrintWriter outputWriter = new PrintWriter(outputFile);
			for(Student s : students){
				
				System.out.println(s.getID()+","+s.getName()+","+s.getEmail()+","+s.getGpa());
			}outputWriter.close();
		}catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output File not Found");
		}
		
	}
}
