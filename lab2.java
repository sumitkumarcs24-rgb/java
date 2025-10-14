import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    String name;
    String usn;
    double SGPA;
    Subject[] subject;
    Scanner s;

    Student(int numSubjects) {
        subject = new Subject[numSubjects];
        s = new Scanner(System.in);
        for (int i = 0; i < numSubjects; i++) {
            subject[i] = new Subject();
        }
    }

    void getStudentDetails() {
        System.out.print("Enter student name: ");
        name = s.nextLine();
        System.out.print("Enter student USN: ");
        usn = s.nextLine();
    }

    void getMarks() {
        for (int i = 0; i < subject.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subject[i].subjectMarks = s.nextInt();
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            subject[i].credits = s.nextInt();
            subject[i].grade = (subject[i].subjectMarks / 10) + 1;
            if (subject[i].grade == 11) {
                subject[i].grade = 10;
            }
            if (subject[i].grade <= 4) {
                subject[i].grade = 0;
            }
        }
    }

    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;
        for (int i = 0; i < subject.length; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        SGPA = (double) effectiveScore / totalCredits;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student USN: " + usn);
        System.out.println("SGPA: " + SGPA);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSubjects = 8;
        Student[] students = new Student[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("\nEntering details for student " + (i + 1));
            students[i] = new Student(numSubjects);
            students[i].getStudentDetails();
            students[i].getMarks();
            students[i].computeSGPA();
        }

        for (int i = 0; i < 2; i++) {
            students[i].displayDetails();
        }

        sc.close();
    }
}
