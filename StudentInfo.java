public class StudentInfo 
{
   private String studentName;
   private int studentID;
   private double studentGPA;
  
   public StudentInfo (String Name, int ID, double GPA) 
   {
       studentName = Name;
       studentID = ID;
       studentGPA = GPA;
   }

   public String getName() 
   {
      return studentName;
   }

   public void setName(String Name) 
   {
      studentName = Name;
   }

   public int getID() 
   {
      return studentID;
   }

   public void setID(int ID) 
   {
      studentID = ID;
   }

   public double getGPA() 
   {
       return studentGPA;
   }

   public void setGPA(double GPA)
   {
       studentGPA = GPA;
   }

   public String toString() 
   {
      System.out.println();
       return "Student: " + studentName + ", ID Number: " + studentID + ", GPA: " + studentGPA;
   } 
}
