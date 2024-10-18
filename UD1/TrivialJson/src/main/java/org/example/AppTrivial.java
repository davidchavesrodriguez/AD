package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class AppTrivial {
    public static void main(String[] args) throws FileNotFoundException {
        Question question1 = new Question()
                .setQuestion("Is Julio passing his exams?")
                .setQuestionType(QuestionType.MULTIANSWER)
                .setDifficulty(Difficulty.EASY)
                .setCategory(new Category("Data Access"))
                .setRightAnswer("Yes, he will")
                .setWrongAnswers(List.of("No", "Yes, in 2027"));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();

        Gson gson = gsonBuilder.create();

        String json = gson.toJson(question1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/question.json"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saved in src/main/resources/question.json");

        // read json file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/question.json"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read json object
        Question readQuestion= gson.fromJson(json, Question.class);
        System.out.println(readQuestion);
    }
}
