package gson.examtojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//public class ExamToJsonHandler {
//    private static final String FILE_NAME= "examToJson.json";
//    private static final GsonBuilder gsonBuilder= new GsonBuilder()
//            .setPrettyPrinting()
//            .registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
//                private final SimpleDateFormat
//            })
//
//
//
//    public static void main(String[] args) {
//        Exam exam= new Exam();
//        exam.setSubject("Acceso a Datos");
//        exam.setDate(new Date());
//        exam.setStudents(Arrays.asList("Julito", "David", "Alicia"));
//    }
//}
