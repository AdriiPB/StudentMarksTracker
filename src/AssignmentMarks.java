
//create AssignmentMarks class
public class AssignmentMarks {
		
		//Attributes 
		private String courseName;
		private int assignment1;
		private int assignment2;
		private int assignment3;	
		
		//methods
		
		//Create the constructor that uses all the fields above
		public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
			this.courseName = name;
			this.assignment1 = mark1;
			this.assignment2 = mark2;
			this.assignment3 = mark3;
			
		}
		//set the marks for assignment 1,2 or 3	
		public void setMark(int assignmentNumber, int mark) {
			
			//first I check the mark is between 0 and 100	
			if (mark < 0 || mark >100) {
				System.out.println("invalid mark");
				return;
			}
			
			//check the assignment number
			if (assignmentNumber == 1) {
				this.assignment1 = mark;
			}
			else if (assignmentNumber == 2) {
				this.assignment2 = mark;
			}
			else if (assignmentNumber == 3) {
				this.assignment3 = mark;
			}
			else {
				System.out.println("please enter a correct assignment number (1,2 or 3)");
			}
		}
		//return the marks for the assignment 		
		public int getMark(int assignmentNumber) {
			if (assignmentNumber == 1) {
				return this.assignment1;
			}
			else if (assignmentNumber == 2) {
				return this.assignment2;
			}
			else if (assignmentNumber == 3) {
				return this.assignment3;
			}
			else {
				System.out.println("please enter a correct assignment number (1,2 or 3)");
				return -1; //return -1 for invalid assignment number
			}
		}
		//get the average mark between the 3 assignments	
		public int getAverageMark() {
			return ((this.assignment1 + this.assignment2 + this.assignment3)/3); // as requested, full number grades
		}
		//get the grade in letter	
		public String getGrade(int assignmentNumber) {
			
			//I can use the getMark method to get the mark			
			int mark = getMark(assignmentNumber);
			
			if (mark >= 95) {
				return "A+";
			}
			else if(mark >= 90) {
				return "A";
			}
			else if(mark >= 85) {
				return "A-";
			}
			else if(mark >= 80) {
				return "B+";
			}
			else if(mark >= 75) {
				return "B";
			}
			else if(mark >= 70) {
				return "B-";
			}
			else if(mark >= 60) {
				return "C+";
			}
			else if(mark >= 50) {
				return "C";
			}
			else if(mark >= 41) {
				return "C-";
			}
			else {
				return "D";
			}		
			
		}
		//return the average grade for the course in letter	
		public String getAverageGrade() {
			
			//I use the getAverageMark() to get the average mark		
			int mark = getAverageMark();
			
			if (mark >= 95) {
				return "A+";
			}
			else if(mark >= 90) {
				return "A";
			}
			else if(mark >= 85) {
				return "A-";
			}
			else if(mark >= 80) {
				return "B+";
			}
			else if(mark >= 75) {
				return "B";
			}
			else if(mark >= 70) {
				return "B-";
			}
			else if(mark >= 60) {
				return "C+";
			}
			else if(mark >= 50) {
				return "C";
			}
			else if(mark >= 41) {
				return "C-";
			}
			else {
				return "D";
			}	
			
			
		}
		public String markToGrade(int mark) {
			
			//I need to convert any given mark to a grade	
		    if (mark >= 95) {
		        return "A+";
		    } else if (mark >= 90) {
		        return "A";
		    } else if (mark >= 85) {
		        return "A-";
		    } else if (mark >= 80) {
		        return "B+";
		    } else if (mark >= 75) {
		        return "B";
		    } else if (mark >= 70) {
		        return "B-";
		    } else if (mark >= 60) {
		        return "C+";
		    } else if (mark >= 50) {
		        return "C";
		    } else if (mark >= 41) {
		        return "C-";
		    } else {
		        return "D";
		    }
			
		}
		
		//set the value of course name	
		public String setCourseName(String name) {
			this.courseName = name;
			return this.courseName;
			
		}
		public String getCourseName() {
			return this.courseName;
			
		}
		
}
