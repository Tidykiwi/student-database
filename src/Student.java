
public class Student {
	
	public int id;							// Example: 30291
	public  String firstName;				// Example: "Frank"	
	public  String lastName;				// Example: "West"	
	public AssignmentMarks mathMarks;		// {Object}
	public AssignmentMarks englishMarks;	// {Object}
	
	// Constructor 
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Returns the full name of the student (first name and last name with a space in between).
	public String getFullName() {
	
		String fullName = (firstName + " " + lastName);
		
		return fullName;
	}	
}
