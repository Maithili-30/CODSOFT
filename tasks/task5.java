import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int studentID;
    String name;
    List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

class University {
    List<Course> courses;
    List<Student> students;

    public University() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourseListing() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Code: " + course.code + ", Title: " + course.title +
                    ", Capacity: " + course.capacity + ", Schedule: " + course.schedule);
        }
    }

    public void registerStudentForCourse(Student student, Course course) {
        if (course.capacity > 0) {
            student.registeredCourses.add(course.code);
            course.capacity--;
            System.out.println(student.name + " registered for " + course.title);
        } else {
            System.out.println("Sorry, " + course.title + " is full.");
        }
    }

    public void removeStudentFromCourse(Student student, Course course) {
        if (student.registeredCourses.contains(course.code)) {
            student.registeredCourses.remove(course.code);
            course.capacity++;
            System.out.println(student.name + " dropped " + course.title);
        } else {
            System.out.println(student.name + " is not registered for " + course.title);
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);

        Course course1 = new Course("CS101", "Introduction to Programming", "Learn the basics of programming", 30, "Mon-Wed-Fri");
        Course course2 = new Course("Math201", "Calculus I", "Study fundamental calculus concepts", 25, "Tue-Thu");
        university.addCourse(course1);
        university.addCourse(course2);

        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");
        university.addStudent(student1);
        university.addStudent(student2);

        while (true) {
            System.out.println("1. Display Course Listing");
            System.out.println("2. Register Student for Course");
            System.out.println("3. Remove Student from Course");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    university.displayCourseListing();
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    int studentID = scanner.nextInt();
                    System.out.println("Enter course code:");
                    String courseCode = scanner.next();
                    Student student = university.students.stream().filter(s -> s.studentID == studentID).findFirst().orElse(null);
                    Course course = university.courses.stream().filter(c -> c.code.equals(courseCode)).findFirst().orElse(null);
                    if (student != null && course != null) {
                        university.registerStudentForCourse(student, course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID:");
                    studentID = scanner.nextInt();
                    System.out.println("Enter course code:");
                    courseCode = scanner.next();
                    student = university.students.stream().filter(s -> s.studentID == studentID).findFirst().orElse(null);
                    course = university.courses.stream().filter(c -> c.code.equals(courseCode)).findFirst().orElse(null);
                    if (student != null && course != null) {
                        university.removeStudentFromCourse(student, course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
