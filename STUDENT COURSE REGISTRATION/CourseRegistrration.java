package Task;

import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Course
class Course {
    private String courseName;
    private String courseCode;
    private int maxStudents;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName, String courseCode, int maxStudents) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.maxStudents = maxStudents;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false; // Course is full
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled students in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName() + " (" + student.getStudentId() + ")");
        }
    }
}

// Class representing a Student
class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}

// Main class for managing course registration
public class CourseRegistrration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some courses
        Course javaCourse = new Course("Java Programming", "CS101", 2);
        Course pythonCourse = new Course("Python Programming", "CS102", 3);

        // Create a list of courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(javaCourse);
        courses.add(pythonCourse);

        // Register students
        System.out.println("Welcome to the Course Registration System!");
        
        while (true) {
            System.out.println("\nEnter student name (or type 'exit' to finish): ");
            String studentName = scanner.nextLine();
            if (studentName.equalsIgnoreCase("exit")) break;

            System.out.println("Enter student ID: ");
            String studentId = scanner.nextLine();

            Student student = new Student(studentName, studentId);

            System.out.println("Available Courses:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i).getCourseName() + " (" + courses.get(i).getCourseCode() + ")");
            }

            System.out.println("Enter course number to enroll in: ");
            int courseChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (courseChoice > 0 && courseChoice <= courses.size()) {
                Course selectedCourse = courses.get(courseChoice - 1);
                if (selectedCourse.enrollStudent(student)) {
                    System.out.println(studentName + " successfully enrolled in " + selectedCourse.getCourseName());
                } else {
                    System.out.println("Sorry, the course is full!");
                }
            } else {
                System.out.println("Invalid course selection.");
            }
        }

        // Display enrolled students in each course
        for (Course course : courses) {
            course.displayEnrolledStudents();
        }

        scanner.close();
    }
}
