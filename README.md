# Student Management System

## Overview
The **Student Management System** allows you to manage student records. It enables users to:
- Add new students to the system.
- View reports based on marks or grades.
- Remove students from the system.

### Features:
- Import student data from a file (`studentdata.txt`).
- View student reports by marks or grades.
- Add new students with details such as ID, name, and marks.
- Remove students based on their unique ID.

## Requirements
- Java 8 or higher
- Text file (`studentdata.txt`) formatted with student data.

## File Structure
- **Main.java**: The main class containing the program logic.
- **Student.java**: Contains the `Student` class with methods to handle student data.
- **AssignmentMarks.java**: Contains the `AssignmentMarks` class to manage marks and grades for each student.

## How to Run
1. Make sure you have Java installed on your system.
2. Clone this repository or download the code.
3. Place the `studentdata.txt` file in the project directory (or modify the file path in the code).
4. Compile and run the program:
   ```bash
   javac Main.java
   java Main
