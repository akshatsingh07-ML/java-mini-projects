//Attendance Calculator
package attendance_manager;
import java.util.*;

class StudentData {
    int rollNo;
    String name;
    int totalClasses;
    int attendedClasses;

    StudentData(int rollNo, String name, int totalClasses, int attendedClasses) {
        this.rollNo = rollNo;
        this.name = name;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    double getAttendance() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    void display() {
        System.out.println("Roll No          : " + rollNo);
        System.out.println("Name             : " + name);
        System.out.println("Total Classes    : " + totalClasses);
        System.out.println("Classes Attended : " + attendedClasses);
        System.out.printf("Attendance        : %.2f", getAttendance());
        System.out.println("%");

        if (getAttendance() >= 75) System.out.println("Status   : Eligible");
        else System.out.println("Status   : Not Eligible");
        System.out.println("-----------------------------");
    }
}
public class StudentAttendanceManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, StudentData> studentMap = new HashMap<>();
        while (true) {
            System.out.println("\n===== ATTENDANCE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Total Classes: ");
                    int total = sc.nextInt();
                    System.out.print("Enter Classes Attended: ");
                    int attended = sc.nextInt();
                    if (attended > total) {
                        System.out.println("Invalid attendance!");
                        break;
                    }
                    StudentData s = new StudentData(roll, name, total, attended);
                    studentMap.put(roll, s);
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Roll No to Search: ");
                    roll = sc.nextInt();
                    if (studentMap.containsKey(roll)) {
                        studentMap.get(roll).display();
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    if (studentMap.isEmpty()) {
                        System.out.println("No Students in the database.");
                    } else {
                        for (StudentData ss : studentMap.values()) {
                            ss.display();
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    roll = sc.nextInt();
                    if (studentMap.containsKey(roll)) {
                        studentMap.remove(roll);
                        System.out.println("Student Deleted!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice! Choose again.");
            }
        }
    }
}
