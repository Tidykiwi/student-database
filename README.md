# student-database
Simple console CRUD application that manages a student database. 
Completed as part of studying 'BIT504 - Programming 1' at The Open Polytechnic of New Zealand (BIT = Bachelor of Information Technology)

This application stores student information along with their 
assignment marks. The user will be shown a menu that allows them to add 
students, remove students, and display a report that shows the student grade 
equivalent to their mark.

The application will read a text file ‘studentdata.txt’ containing the data for several 
students. The data will be stored using classes and abstract data types.
The application will display a menu to the user. Based on the user’s input the 
application will perform these functions:<br>
  - display student marks<br>
  - display student grades<br>
  - add new student<br>
  - remove student<br>
  - exit<br>

The numerical marks are converted to a letter grade (such as 96 to 
an A+).

When the program is <b>executed</b> the following steps are completed before the 
user interacts with the program:
- Read in student data (from studentdata.txt) of the five (5) students (ID, 
name, and the marks for 3 assignments for 2 courses).<br>
- Data will be in the following format:<br>
• id,firstName,lastName,mathMark1,mathMark2,mathMark3,englishMark
1,englishMark2,englishMark3.<br>
- Create a Student object for each student data given. Create an 
AssignmentMarks object for each course the student has and set the 
name and marks appropriately.<br>
- Store the student objects using a Collection Framework (that implements 
an abstract class).<br>


When the program is <b>running</b> the user is displayed a menu with the following options:<br>
- Display student marks.<br>
• Display a table of all the student marks, including the marks for both courses as well as the average mark for each.<br>
- Display student grades.<br>
• Display a table of all the student grades, including the marks for both courses as well as the average grade for each.<br>
- Add new student.<br>
• Ask the user to enter the information for the student (including the course marks).<br>
- Remove student.<br>
• Ask the user for an ID. Removes the student from the LinkedList.
- Exit the program.<br>
  
After selecting an option (excluding exit) the code for the option executes, then the user is returned to the menu.
