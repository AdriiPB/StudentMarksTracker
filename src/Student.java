
public class Student {
	
	//Attributes
	
	public int id;
	public String firstName;
	public String lastName;
	public AssignmentMarks mathMarks;
	public AssignmentMarks englishMarks;
	
	//methods
	
	//constructor
	
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//full name first name + last name
	
	public String getFullName() {
		return (firstName + " " + lastName);
	}

}
