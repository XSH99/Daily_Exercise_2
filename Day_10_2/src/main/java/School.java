import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class School {

    private ArrayList<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentById(int studentId) {
        students.removeIf(student -> student.compareById(studentId));
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public Student findStudentById(int studentId) {
        int low = 0;
        int high = students.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Student student = students.get(mid);

            if (student.getStudentId() < studentId) {
                low = mid + 1;
            } else if (student.getStudentId() > studentId) {
                high = mid - 1;
            } else {
                return student;
            }
        }

        return null;
    }

    public void writeStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                String name = details[0].split(": ")[1];
                int age = Integer.parseInt(details[1].split(": ")[1]);
                String address = details[2].split(": ")[1];
                int studentId = Integer.parseInt(details[3].split(": ")[1]);
                String course = details[4].split(": ")[1];
                students.add(new Student(name, age, address, studentId, course));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
