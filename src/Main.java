
//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

//create Main class with main method
public class Main {
	
	//Attributes
	public static LinkedList<Student> students; // declare the students list
	
	
	//Main method
	public static void main(String[] args) {
		
		//calling all the methods from here
		
		students = new LinkedList<Student>();
		
		//read a file source.txt file and it should return true or false
		if(readFile("studentdata.txt")) {
		
			//do rest of the program
			while(true){
				displayMenu();
				System.out.println();
				int option = selectMenuOption(); //store the number selected by the user
				
				//depending the chosen option the program will perform an action
				if(option == 1) {
					displayReportByMarks();
					returnToMainMenu();

				}
				else if(option == 2) {
					displayReportByGrades();
					returnToMainMenu();
				}
				else if(option == 3) {
					addNewStudent();
					returnToMainMenu();
				}
				else if(option == 4) {
					removeStudent();
					returnToMainMenu();
				}
				else{
					Scanner scanner = new Scanner(System.in);
				
					System.out.println("do you really want to exit the program? press enter to exit or press any other key to stay"); // get input from the user, only exits if user presses enter or stays if the user presses any other key
					String selection = scanner.nextLine();
					
					if(selection.equals("")) {
						System.out.println("You have exited the program succesfully");
						break;
					}
					else { // if the user presses a different key, return to the loop
						returnToMainMenu();
					}
					
				}
			}

		}
		else {
			//Display error reading message
			System.out.println("Error reading the file.");
		}

		}
	
	//more methods
	public static boolean readFile(String fileName) {
		File file = new File(fileName);
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String[] words = scanner.nextLine().split(",");
				
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String lastName = words[2];
				int mathMark1 = Integer.parseInt(words[3]);
				int mathMark2 = Integer.parseInt(words[4]);
				int mathMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				
				addStudent( id,  firstName,  lastName,  mathMark1,  mathMark2,  mathMark3,  englishMark1,  englishMark2,  englishMark3);
			}
			scanner.close();
		}catch (FileNotFoundException e) { //if there is not a file we get an error message
			System.out.println("Failed to read file");
			return false;
		}
		return true;
		
	}
	
	private static void addStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
		//method to add students to the LinkedList
		Student aStudent = new Student(id, firstName, lastName);
		
		//Initialize two objects assignment marks
		AssignmentMarks mathSubject = new AssignmentMarks("Maths", mathMark1, mathMark2, mathMark3);
		AssignmentMarks englishSubject = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		
		aStudent.mathMarks = mathSubject;
		aStudent.englishMarks = englishSubject;
		
		//write a statement (a single line) that will take the student object (i.e., aStudent) and push the content inside the linked list
		students.add(aStudent);
		
	}
	
	private static void displayReportByMarks() {
		
		//displays the report by marks (numbers)
		for (Student s : students) {
			System.out.println(s.id + "\t" + s.firstName + "\t" + s.lastName + "\t" + s.mathMarks.getCourseName() + "\t" + s.mathMarks.getMark(1) + "\t" + s.mathMarks.getMark(2)+ "\t" + s.mathMarks.getMark(3) + "\t"+ "Maths Average" + "\t"+ s.mathMarks.getAverageMark() + "\t" + s.englishMarks.getCourseName() + "\t" + s.englishMarks.getMark(1) + "\t" + s.englishMarks.getMark(2)+ "\t" + s.englishMarks.getMark(3) + "\t"+ "English Average" + "\t"+ s.englishMarks.getAverageMark() + "\t");
			
		}
		
	}
	
	private static void displayReportByGrades() {
		
		//displays the report by grades (letters)
		for (Student s : students) {
			System.out.println(s.id + "\t" + s.firstName + "\t" + s.lastName + "\t" + s.mathMarks.getCourseName() + "\t" + s.mathMarks.getGrade(1) + "\t" + s.mathMarks.getGrade(2)+ "\t" + s.mathMarks.getGrade(3) + "\t"+ "Maths Average" + "\t"+ s.mathMarks.getAverageGrade() + "\t" + s.englishMarks.getCourseName() + "\t" + s.englishMarks.getGrade(1) + "\t" + s.englishMarks.getGrade(2)+ "\t" + s.englishMarks.getGrade(3)+ "\t"+ "English Average" + "\t"+ s.englishMarks.getAverageGrade() + "\t");
			
		}
		
	}
	
	//add average report by marks and by grades math and English 
	
	private static void displayMenu() {
		
		//print the menu on screen
		System.out.println("1. Press 1 to display the report by Marks");
		System.out.println("2. Press 2 to display the report by Grades");
		System.out.println("3.Press 3 to add a student");
		System.out.println("4.Press 4 to remove a student");
		System.out.println("5. Press 5 to exit the Menu");
		
	}
	//the user gives input to select the option entering a number
	private static int selectMenuOption() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			
			try {
				System.out.println("Please enter a number to select a menu option");
				int option = scanner.nextInt();
				// check if the input is valid
				if (option > 0 && option <6) {
					return option;
				}
				else {
					System.out.println("Please select a valid option 1-5"); // if the number selected is not in the menu gets a message and ask again
				}
			// in case the user enters an invalid option and gives error
			}catch (Exception e) {
				System.out.println("Please select a valid option 1-5");
				scanner.next();
			}

		}

		
		
	}
	
	private static void addNewStudent() {

	    // Add a new student to the list
	    Scanner scanner = new Scanner(System.in); // Uses scanner to ask for students' details (id, name...)
	    int id;

	    while (true) {
	        try {
	            System.out.println("Please enter the ID:");
	            id = scanner.nextInt();

	            // Loop through the students to see if the entered id already exists
	            boolean repeatedId = false;

	            for (Student s : students) {
	                if (s.id == id) {
	                    repeatedId = true;
	                    break;
	                }
	            }

	            // If the ID is found, print an error message
	            if (repeatedId) {
	                System.out.println("This id already exists, please enter a new id.");
	            } else {
	                scanner.nextLine();
	                break; // Valid ID, exit the loop
	            }

	        } catch (Exception e) {
	            // If the user enters a non-integer input, print an error message
	            System.out.println("Invalid input, please enter a valid numeric ID.");
	            scanner.nextLine();
	        }
	    }

	    String firstName = "";
	    while (true) {
	        System.out.println("Enter your First name");
	        firstName = scanner.nextLine(); // Reads the first name input

	        if (firstName.isEmpty()) { //input checking to make sure the user doesn't leave it blank
	            System.out.println("First name cannot be empty. Please enter a valid name.");
	        } else if (!firstName.matches("[a-zA-Z]+")) {//make sure the input is not a number to check that is a valid last name
	            System.out.println("First name can only contain letters. Please enter a valid name.");
	        } else {
	            break; // if the input is valid, the loop is broken
	        }
	    }

	    String lastName = "";
	    while (true) {
	        System.out.println("Enter your last name");
	        lastName = scanner.nextLine(); // Reads the last name input

	        if (lastName.isEmpty()) {
	            System.out.println("Last name cannot be empty. Please enter a valid last name.");
	        } else if (!lastName.matches("[a-zA-Z]+")) {
	            System.out.println("Last name can only contain letters. Please enter a valid last name.");
	        } else {
	            break; // if the input is valid, the loop is broken
	        }
	    }

	    
	    //for all the marks checks if are between 0 and 100, if not asks the user to enter a value between 0 and 100
	    //if the user enter an integer catch the error and ask to enter a valid value.
	    int mathMark1;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 1 for Maths");
	            mathMark1 = scanner.nextInt(); // Reads the first Maths mark

	            if (mathMark1 < 0 || mathMark1 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break; // if the input is valid, the loop is broken
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    int mathMark2;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 2 for Maths");
	            mathMark2 = scanner.nextInt(); // Reads the second Maths mark

	            if (mathMark2 < 0 || mathMark2 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    int mathMark3;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 3 for Maths");
	            mathMark3 = scanner.nextInt(); // Reads the third Maths mark

	            if (mathMark3 < 0 || mathMark3 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    int englishMark1;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 1 for English");
	            englishMark1 = scanner.nextInt(); // Reads the first English mark

	            if (englishMark1 < 0 || englishMark1 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    int englishMark2;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 2 for English");
	            englishMark2 = scanner.nextInt(); // Reads the second English mark

	            if (englishMark2 < 0 || englishMark2 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    int englishMark3;
	    while (true) {
	        try {
	            System.out.println("Enter your mark number 3 for English");
	            englishMark3 = scanner.nextInt(); // Reads the third English mark

	            if (englishMark3 < 0 || englishMark3 > 100) {
	                System.out.println("Please enter a valid mark between 0 and 100");
	            } else {
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input, please enter a valid numeric value.");
	            scanner.nextLine();
	        }
	    }

	    // Using the addStudent method, the new student gets added
	    addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
	    //gives the user a message the new student has been added successfully
	    System.out.println();
	    System.out.println("Student added succesfully");
	}
	
	private static void removeStudent() {
	    // removes student from the list
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        try {
	            System.out.println("Please enter the ID of the student you want to remove:");
	            int id = scanner.nextInt();

	            // Loop through the students list to find the student with the entered ID
	            
	            boolean studentFound = false;
	            
	            for (Student s : students) {
	                if (s.id == id) {
	                    students.remove(s); // Remove the student from the list
	                    System.out.println("Student removed successfully!");
	                    studentFound = true;
	                    break; // Exit the loop once the student is removed
	                }
	            }

	            //if the student is not found prints an error message
	            if (!studentFound) {
	                System.out.println("No student found with this ID. Please enter a valid one.");
	            }
	            else {
	            	break; //if the student is found breaks the loop
	            }

	        } catch (Exception e) {
	            //if the user enters a not integer input gets an error message
	            System.out.println("Invalid input, please enter a valid numeric ID.");
	            scanner.nextLine(); 
	        }
	    }
	}
	//after the selection clears the screen printing 20 white lines
	private static void returnToMainMenu() { 
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please press any key to continue");
		scanner.nextLine();
		for(int i= 1; i<20; i++) {
			System.out.println();
		}
	}

}
