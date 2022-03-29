
 public class AssignmentMarks {
                        
                        
                        
	private String courseName;   // Example: "Mathematics"
	private int assignment1;     // Example: 98
	private int assignment2; 	// Example: 93
	private int assignment3; 	// Example: 88
	
	// Constructor
	public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
		this.courseName = name;
		this.assignment1 = mark1;
		this.assignment2 = mark2;
		this.assignment3 = mark3;
	}
	
	public void setMark(int assignmentNumber, int mark) {
		
		// Used to set the value of the assignments.	
	}
	
	public int getMarkAssignment1() {
		
		// Returns the mark for assignment 1
		return assignment1;
	}
	
	public int getMarkAssignment2() {
		
		// Returns the mark for assignment 2
		return assignment2;
	}
	
		public int getMarkAssignment3() {
	
			// Returns the mark for assignment 3
		return assignment3;
	}

	
	public int getAverageMark() {

		//Returns the average mark for the course.		
		int averageMark = (Math.round(assignment1 + assignment2 + assignment3) / 3);
		
		return averageMark;
	}
	
	
	public String getGradeAssignment1() {
		
		//Returns the grade (such as A, B, C) for the assignment.
		String grade = markToGrade(assignment1);
				
		return grade;
	}
	
	public String getGradeAssignment2() {
		
		//Returns the grade (such as A, B, C) for the assignment.
		String grade = markToGrade(assignment2);
						
		return grade;
	}
	
	public String getGradeAssignment3() {
	
		//Returns the grade (such as A, B, C) for the assignment.
		String grade = markToGrade(assignment3);
					
		return grade;
	}

	
	public String getAverageGrade() {
		
		// Returns the average grade for the course.
		int averageMark = getAverageMark();
		String averageGrade = markToGrade(averageMark);
		
		return averageGrade;
	}
	
	public static String markToGrade(int mark) {
		
		//Returns the grade (A, B, C, and so on) based on the mark given.	 
		String grade = null;
		
		if(mark > 94 && mark < 101)
			grade = "A+";
		else if(mark > 89 && mark < 95)
			grade = "A";
		else if(mark > 84 && mark < 90)
			grade = "A-";
		else if(mark > 79  && mark < 85)
			grade = "B+";
		else if(mark > 74 && mark < 80)
			grade = "B";
		else if(mark > 69 && mark < 75)
			grade = "B-";
		else if(mark > 59 && mark < 70)
			grade = "C+";
		else if(mark > 49 && mark < 60)
			grade = "C";
		else if(mark > 40 && mark < 50)
			grade = "C-";
		else
			grade = "D";
			
		return grade;
	}
	
	
	public String setCourseName(String name) {
		
		// Set the value of courseName
		courseName = name;
		return courseName;
	}
	
	public String getCourseName() {
		
		//Return the value of courseName
		return courseName;
	}

}
