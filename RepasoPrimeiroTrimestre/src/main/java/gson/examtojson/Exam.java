package gson.examtojson;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Exam {
    private String subject;
    private Date date;
    private List<String> students;



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(subject).append(" (").append(date).append(")")
                .append("\n").append("Students: ");

        for (String student : students) {
            stringBuilder.append(student).append(", ");
        }

        return stringBuilder.toString();
    }

//    public static void main(String[] args) {
//        Exam exam = new Exam();
//
//        exam.setSubject("Matemáticas");
//        exam.setDate(new Date());
//
//        List<String> students = Arrays.asList("Juan Pérez", "María Gómez", "Carlos López");
//
//        exam.setStudents(students);
//
//        System.out.println(exam);
//    }
}
