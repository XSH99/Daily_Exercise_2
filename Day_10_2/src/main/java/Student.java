/*
* 1- Create a subclass Student that extends Person
* 2- adds attributes studentId and course.
* 3- Override the toString method to display all details of a Student.
* 4- Ensure that studentId in the Student class is a positive integer.
* 5- Modify Person and Student to extend PersonRecord and implement getDetails
* to return a string with the person's details.
* 6- Implement ComparableById in Student class. The method should return true if the studentId matches the given id.
*/


// 1
public class Student extends Person implements ComparableById{

    // 2
    private int studentId;
    private String course;

    // the constractor befor modify.
//    public Student(String name,int age, String address,int studentId, String course ){
//        super(name,age,address);
//        this.studentId = studentId;
//        this.course = course;
//    }

    // Constructor after modify.
    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        setStudentId(studentId);
        this.course = course;
    }


    // the getter for both 2 attributes
    public int getStudentId () {
        return studentId;
    }

    public String getCourse () {
        return course;
    }

    // the  Seter for both 2 attributes
    // befor modify
   //    public void setStudentId (int studentId){
    //        this.studentId = studentId;
   //    }


   // seter after modify.
   // 4
    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID have to be positive integer:");
        }
        this.studentId = studentId;
    }

    public void setCourse (String course){
        this.course = course;
    }

    //6
    @Override
    public boolean compareById(int id ){
        return this.studentId == id;
    }

    // 5
    @Override
    public String getDetails(){
        return toString();
    }

    // 3
    @Override
    public String toString (){
        return super.toString() + "students ID:"+ studentId + "Course:" + course;
    }
}
