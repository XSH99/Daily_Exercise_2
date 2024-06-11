//Write a main method to create and display details of two Person objects.
public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("ahmad",23,"alwaleed bin abdulmalek 3/2 st");
        Person p2 = new Person("Razan",25,"mohamed ali 3/3 st");

        System.out.println(p1);
        System.out.println(p2);

        Student s1 = new Student("Ali",15,"Aben Kldoon 1/3 st",1110,"COCS110");
        Student s2 = new Student("Noor",18,"Manee Almadedi 2/3 st",1111,"COIT110");

        System.out.println(s1);
        System.out.println(s2);


        School school = new School();
        school.addStudent(s1);
        school.addStudent(s2);
        school.displayAllStudents();
        school.writeStudentsToFile();
        school.readStudentsFromFile();
        school.displayAllStudents();

    }

}