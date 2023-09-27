import java.util.*;
import java.util.Arrays;
import java.io.*;

public class Main
{

public static StudentInfo students[] = new StudentInfo[100];

static int getUserInput(Scanner in)
{

  System.out.println();
  System.out.println("Project 1");
  System.out.println("TWU - Data Structures");
  System.out.println("--------------------");
  System.out.println();
  System.out.println("Please Make a Selection");
  System.out.println();
  System.out.println("1 = Insert New Student");
  System.out.println("2 = Fetch Student Info");
  System.out.println("3 = Delete Student Info");
  System.out.println("4 = Update Student Info");
  System.out.println("5 = Output All Student Info");
  System.out.println("6 = Exit The Program");
  System.out.println();

int UserSelection;
while (true)
{

UserSelection = Integer.parseInt (in.nextLine());
if(UserSelection < 1 || UserSelection > 6)
{

System.out.println(); 
System.out.println("Not a Selectable Option. Please Choose Another Option");
System.out.println();
}

else
{

break;
}
}

return UserSelection;
}

public static void studentSort()
{

StudentInfo temp;
int stop = 0;

for(int i = 0; i < students.length; i ++)
{

if(students[i] == null)
{

stop = i;
  break;
  }
}

for(int i = 1; i < stop; i ++)
{

if(students[i].getID() < students[i-1].getID())
{

  temp = students[i-1];
  students[i-1] = students[i];
  students[i] = temp;
  studentSort();
    }
  }
}

public static void addNewStudent(String nm,int ident, double gp)
{

for(int i = 0; i < students.length; i ++)
{

if(students[i] == null)
{

  students[i] = new StudentInfo(nm, ident, gp);
break;
  }
}

if(students[1] != null)
{

  studentSort();
  }
}

public static void removeStudent(int I)
{

StudentInfo temp;
students[I] = null;

for(int i = I + 1; i < students.length; i ++)
{

students[i-1] = students[i];
}
}

public static void main (String[] args)
{

Scanner cin = new Scanner (System.in);
  int UserSelection;
  int ID;
  double GPA;
  String Name;

boolean found = false;

Scanner in = new Scanner(System.in);
boolean programIsRunning = true;
  while(programIsRunning)
  {

    UserSelection = getUserInput(in);
      switch(UserSelection)
{

case 1:
  System.out.println();
  System.out.print("Enter Student Name: ");
  Name = in.nextLine();
  System.out.print("Enter Student ID: ");
  ID = Integer.parseInt(in.nextLine());
  System.out.print("Enter GPA: ");
  GPA = Double.parseDouble(in.nextLine());
  addNewStudent(Name, ID, GPA);
  System.out.println("Student Info Stored!");
break;

case 2:
  System.out.println();
  System.out.print("Enter ID Number of the Student: ");
  ID = Integer.parseInt(in.nextLine());
  found = false;
  for(int i = 0; i < students.length; i ++)
  {

  if(students[i].getID() == ID)
  {

    System.out.println("Student: " + students[i].getName());
    System.out.println("GPA: " + students[i].getGPA());
    found = true;
break;
  }
}

  if(!found)
    System.out.println("Student: " + ID + " can not be found!");
break;

case 3:
  System.out.println();
  System.out.print("Enter ID Number of the Student: ");
  ID = Integer.parseInt(in.nextLine());
  found = false;
  for(int i =0; i < students.length; i ++)
{

if(students[i].getID() == ID)
{

  found = true;
  removeStudent(i);
  System.out.println("Student Deleted!");
break;

  }
}

  if(!found)
    System.out.println("Student: " + ID + " can not be found!");
break;

case 4:
  System.out.println();
  System.out.print("Enter ID Number of the student: ");
  ID = Integer.parseInt(in.nextLine());
  found = false;
  for(int i = 0; i < students.length; i ++)
{

  if(students[i].getID() == ID)
{

  found = true;
  System.out.print("Enter Student's Name: ");
  Name = in.nextLine();
  System.out.print("Enter Student's GPA: ");
  GPA = Double.parseDouble(in.nextLine());
  students[i].setName(Name);
  students[i].setGPA(GPA);
  System.out.println("The Student's Info Has Been Changed.");
break;
  }
}

if(!found)
{

  System.out.println("Student with ID Number: " + ID + " can not be found!");
}
break;

case 5:
  System.out.println();
  if(students[0] == null)
{
  
  System.out.println("There are no students currently listed!");
break;
}

else
{

  int stop = 0;
for(int i = 0; i < students.length; i ++)
{

if(students[i] == null)
{

  stop = i;
break;
  }
}

for(int i = 0; i < stop; i ++)
{

  System.out.println("ID: " + students[i].getID());
  System.out.println("Student: " + students[i].getName());
  System.out.println("GPA: " + students[i].getGPA());
  System.out.println("");
}

break;
}

case 6:
  System.out.println();
  programIsRunning = false;
  cin.close();
  System.out.println("Program is Exiting!");
break;

default:
  System.out.println("Invalid Selection try again");
break;
}

    System.out.println();
    }
  }
}