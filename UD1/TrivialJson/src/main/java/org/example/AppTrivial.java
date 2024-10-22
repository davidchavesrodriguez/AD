package org.example;

import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
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

        // Register the TypeAdapter here before creating the Gson object
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();

        // TypeAdapter to serialize QuestionType in lowercase
        gsonBuilder.registerTypeAdapter(QuestionType.class, (JsonSerializer<QuestionType>)
                (questionType, type, jsonSerializationContext) -> {
                    return new JsonPrimitive(questionType.name().toLowerCase());
                });

        // TypeAdapter to serialize QuestionType to lowecase except the first letter
        gsonBuilder.registerTypeAdapter(QuestionType.class, (JsonSerializer<QuestionType>)
                        (questionType, type, jsonSerializationContext) -> {
                            String questionTypeCapitalized = questionType.name().substring(0, 1).toUpperCase() +
                                    questionType.name().substring(1).toLowerCase();
                            return new JsonPrimitive(questionTypeCapitalized);
                        });

                // Create the Gson object after registering the TypeAdapter
                Gson gson = gsonBuilder.create();

        // Serialize the Question object into JSON
        String json = gson.toJson(question1);

        // Write the JSON to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/question.json"))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saved in src/main/resources/question.json");

        // Read the JSON file and print it to the console
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/question.json"))) {
            System.out.println("**SERIALIZED JSON**");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Read the JSON object and deserialize it into a Question object
//        Question readQuestion = gson.fromJson(json, Question.class);
//        System.out.println("**DESERIALIZED JSON**");
//        System.out.println(readQuestion);
    }
}
