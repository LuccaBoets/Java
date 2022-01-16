package Labo9;

public class Main {
    public static void main(String[] args) {

        StudentAOD studentAOD = new StudentAOD();

        Student student = new Student(1,"Lucca","gmail.com");

        studentAOD.addStudent(student);

//        studentAOD.removeStudent(1);

        for (Student student1: studentAOD.getStudents()) {
            System.out.println(student1);
        }
    }
}
