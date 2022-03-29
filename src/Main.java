import java.util.Scanner;
import java.util.LinkedList; 
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	// Declare students list
	static LinkedList<Student> stuList = new LinkedList<Student>();
	
	public static void main(String[] args) {
		
		// Call readFile with file path
		readFile("C:/Temp/studentdata.txt");
		
		// While loop brings user back to the menu unless they select exit
		while (true) {
		
			// Display menu to the user
			displayMenu();
		
			// Store users menu selection
			int option = selectMenuOption();
			
			// Switch to process menu input
			switch(option) {
        		case 1: {
	       			displayReportByMarks();
	       			break;
	        	}
	        	case 2: {
	        		displayReportByGrades();
	        		break;
	       		}
	       		case 3: {
	        		addNewStudent();
	        		break;
	        	}
	        	case 4: {
	        		removeStudent();
	        		break;
	       		}
	       		case 5: {
	        		System.out.println("Goodbye");
	        		System.exit(0);
	       		}
			}
		}		

	}
		
	
	public static boolean readFile(String filename) {
		
		File file = new File(filename);
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String[] words = scanner.nextLine().split(",");
	
			addStudent(Integer.parseInt(words[0]), words[1],words[2],Integer.parseInt(words[3]),Integer.parseInt(words[4]),
						Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]));				
			}		
			scanner.close();
		} catch(FileNotFoundException e) {
			System.out.println("Failed to read file");
		}
		return true;
	}
	
	private static void addStudent(int id, String firstName, String lastName, int mathsMark1,
			int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3) {
		
		// Create Student object
		Student newStudent = new Student(id, firstName, lastName); 
		
		// Create AssignmentMarks object for Maths and assign MATHS object to STUDENT object
		AssignmentMarks mathMarks = new AssignmentMarks("Mathematics", mathsMark1, mathsMark2, mathsMark3);
		newStudent.mathMarks = mathMarks;
		
		mathMarks.setCourseName("Maths");
		
		// Create AssignmentMarks object for English and assign ENGLISH object to STUDENT object 
		AssignmentMarks englishMarks = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);	
		newStudent.englishMarks = englishMarks;
		
		englishMarks.setCourseName("English");
		
		// Add new student object to studentList
		stuList.add(newStudent);
		
	}

	private static void  displayMenu() {
		
		// Print out the menu display
		System.out.println("\nStudent Report System\n-------------------------\n"	 
				+ "1) Display student marks\n2) Display student grades\n"
				+ "3) Add new student\n4) Remove student\n5) Exit\n");
	}
	
	
	private static int selectMenuOption() {
		
		String option;
		int myInt = 0;	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// Prompt user for input and perform error checks
		do {
			System.out.println("Select an option between 1 and 5: ");
			option = scanner.next();
			// Check to see if user input is an integer
			if(TryParseInt(option) == null) {
				System.out.println("Invalid input.\n");
			} else {
				// If input is an integer check to see if it is in valid range (1-5)
				myInt = Integer.parseInt(option);
				if(myInt < 1 || myInt > 5) {
					System.out.println("Invalid input.\n");
				} if (myInt == 5) {
					System.out.println("You have chosen to exit the program");
				} else {
					// User choice is valid and can be returned
					System.out.println("You selected option " + myInt + "\n");
				}
			}
		} while(myInt < 1 || myInt > 5);		
		return myInt;
	}

	private static void displayReportByMarks( ) {
	
	// Displays a list of all the students and their marks.
		
		System.out.println("ID\tName\t\tMaths\tA1\tA2\tA3\tFinalMark\tEnglish\tA1\tA2\tA3\tFinalMark"
				+ "\n----------------------------------------------------------------------------------------------------------\n");
		
		// Loop through studentsList to access all the data
		for(Student stu : stuList) {							
			
			System.out.println(stu.id + "\t" + stu.getFullName() + "\t" + stu.mathMarks.getCourseName() + "\t" + stu.mathMarks.getMarkAssignment1() 
					+ "\t" + stu.mathMarks.getMarkAssignment2() + "\t" + stu.mathMarks.getMarkAssignment3() + "\t" + stu.mathMarks.getAverageMark() 
					+ "\t\t" + stu.englishMarks.getCourseName() + "\t" + stu.englishMarks.getMarkAssignment1() + "\t" + stu.englishMarks.getMarkAssignment2() 
					+ "\t" + stu.englishMarks.getMarkAssignment3() + "\t" + stu.englishMarks.getAverageMark());
		}
	}
	
	private static void displayReportByGrades( ) {
	
	// Display a list of all students with the student letter grades
		
		System.out.println("ID\tName\t\tMaths\tA1\tA2\tA3\tFinalGrade\tEnglish\tA1\tA2\tA3\tFinalGrade"
				+ "\n----------------------------------------------------------------------------------------------------------\n");
		
		// Loop through studentsList to access all the data
		for(int i = 0; i < stuList.size(); i++) {							
			
			System.out.println(stuList.get(i).id + "\t" + stuList.get(i).getFullName() + "\t" + stuList.get(i).mathMarks.getCourseName() + "\t" + stuList.get(i).mathMarks.getGradeAssignment1() 
					+ "\t" + stuList.get(i).mathMarks.getGradeAssignment2() + "\t" + stuList.get(i).mathMarks.getGradeAssignment3()
					+ "\t" + stuList.get(i).mathMarks.getAverageGrade() + "\t\t" + stuList.get(i).englishMarks.getCourseName() + "\t" + stuList.get(i).englishMarks.getGradeAssignment1() + "\t" 
					+ stuList.get(i).englishMarks.getGradeAssignment2() + "\t" + stuList.get(i).englishMarks.getGradeAssignment3() 
					+ "\t" + stuList.get(i).englishMarks.getAverageGrade());
		}
	}
		
	
	
	private static void addNewStudent() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean idExists = true;
		int newId = 0;
		String newFirstName, newLastName, newMathsMark1, newMathsMark2, newMathsMark3, newEnglishMark1, newEnglishMark2, newEnglishMark3;
		
		//Asks the user for the student information (ID, name, marks) and then
		// creates the appropriate objects and adds the student to the student list.
		
		System.out.println("You need to enter the details of the student that you wish to add.\n");
		
		// Prompt user for ID and perform error checks
		do {
			System.out.println("Please enter an ID.");
			String id = scanner.next();
			// Check to see if user input is an integer
			if(TryParseInt(id) == null) {
				System.out.println("Invalid input.\n");
			} else {
				// If input is an integer check to see if it is positive
				int myInt = Integer.parseInt(id);
				if(myInt < 1) {
					System.out.println("Invalid input.\n");
				} else {
					int counter = 0;
					// Loop through student list to find ID
					for(int  i = 0; i < stuList.size(); i++) {
						// For each student object that doesn't match ID counter increases by 1 
						if(stuList.get(i).id != myInt) {
							counter ++;
						}		
					}
					// If finished counter total is same as number of student objects then that ID is not in list
					if(counter == stuList.size()) {
						newId = myInt;
						idExists = false;;
					} else {
						// Selected student ID already exists
						System.out.println("That ID is being used already.");
					}	
				}
			}
		} while(idExists == true);	
		
		// Create new ID that is 1 higher than the ID of the last student in the list 
		//newId = (stuList.get(stuList.size() - 1).id) + 1;
		
		System.out.println("Please enter first name: ");
		newFirstName = scanner.next();
		System.out.println("Please enter last name: ");
		newLastName = scanner.next();
		
		// Ask user for marks then perform error checks using markCheck method
		System.out.println("Please enter mathsMark1: ");
		markCheck(newMathsMark1 = scanner.next());
		System.out.println("Please enter mathsMark2: ");
		markCheck(newMathsMark2 = scanner.next());
		System.out.println("Please enter mathsMark3: ");
		markCheck(newMathsMark3 = scanner.next());
		System.out.println("Please enter englishMark1: ");
		markCheck(newEnglishMark1 = scanner.next());
		System.out.println("Please enter englishMark2: ");
		markCheck(newEnglishMark2 = scanner.next());
		System.out.println("Please enter englishMark3: ");
		markCheck(newEnglishMark3 = scanner.next());
			
		// Create new student object 
		addStudent(newId, newFirstName, newLastName, Integer.parseInt(newMathsMark1),Integer.parseInt(newMathsMark2),
			Integer.parseInt(newMathsMark3),Integer.parseInt(newEnglishMark1),Integer.parseInt(newEnglishMark2),Integer.parseInt(newEnglishMark3));

	}
	
	
	private static void removeStudent() {
		
		String id;
		int myInt = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);	
		
		// Prompt user for input and perform error checks
		do {
			System.out.println("Please enter the ID of the student you wish to remove.");
			id = scanner.next();
			// Check to see if user input is an integer
			if(TryParseInt(id) == null) {
				System.out.println("Invalid input.\n");
			} else {
				// If input is an integer check to see if it is positive
				myInt = Integer.parseInt(id);
				if(myInt < 1) {
					System.out.println("Invalid input.\n");
				} else {
					int counter = 0;
					// Loop through student list to find ID
					for(int  i = 0; i < stuList.size(); i++) {
						// For each student object that doesn't match ID counter increases by 1 
						if(stuList.get(i).id != myInt) {
							counter ++;
							// If finished counter total is same as number of student objects then that ID is not in list
							if(counter == stuList.size()) {
							System.out.println("Sorry that student does not exist.");
							}
						} else {
							// Selected student is in the list and is deleted
							System.out.println("Student " + myInt + " " + stuList.get(i).getFullName() + " has been removed.");
							stuList.remove(i);
							break;								}
					}	
					break;				
				}
			}
		} while(true);	
	}
	
	// Method for error checking marks when manually adding a new student
	public static void markCheck(String input) {	
		int inPut = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		do {			
			// Check to see if user input is an integer
			if(TryParseInt(input) == null) {
				System.out.println("Invalid input.\nPlease enter a valid mark.");
				input = scanner.next();				
			} else {				
				// If input is an integer check to see if it is in valid range
				inPut = Integer.parseInt(input);
				if(inPut < 0 || inPut > 100) {
					System.out.println("Invalid input.\nPlease enter a valid mark.");
					input = scanner.next();
				} else {	
						// If mark is valid inform user and exit method
						System.out.println("mark saved = " + input);
						break;	
				}
			}
		} while(true);	
	}
	
	// Method TryParseInt found on GitHub posted by user "gidili" October/2014
	public static Integer TryParseInt(String someText) {
		   try {
		      return Integer.parseInt(someText);
		   } catch (NumberFormatException ex) {
		      return null;
		   }
		}
	
}

