package gson.trivial.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MultipleChoice extends Question implements Predicate<Integer> {
    private List<Option> options;


    public MultipleChoice() {
        this.options = new ArrayList<>();
    }

    public MultipleChoice(String questionText) {
        super(questionText);
        this.options = new ArrayList<>();
    }

    public MultipleChoice addOption(Option option) {
        if (option != null) {
            this.options.add(option);
        }
        return this;
    }

    public MultipleChoice addOptions(List<Option> options) {
        if (options != null) {
            this.options.addAll(options);
        }
        return this;
    }

    public int getNumCorrectAnswers() {
        int count = 0;
        for (Option option : options) {
            if (option.isRightAnswer()) {
                count++;
            }
        }
        return count;
    }

    public int getPoints(List<Integer> selectedOptions) {
        if (selectedOptions == null || selectedOptions.isEmpty()) {
            return 0;
        }

        int correct = 0;
        int incorrect = 0;

        for (int index : selectedOptions) {
            if (index >= 0 && index < options.size()) {
                Option option = options.get(index);
                if (option.isRightAnswer()) {
                    correct++;
                } else {
                    incorrect++;
                }
            }
        }
        int totalCorrect = getNumCorrectAnswers();
        if (totalCorrect == 0) {
            return 0;
        }
        return (correct - incorrect) / totalCorrect;
    }

    @Override
    public boolean test(Integer selectedIndex) {
        if (selectedIndex == null || selectedIndex < 0 || selectedIndex >= options.size()) {
            return false;
        }
        Option option = options.get(selectedIndex);
        return option.isRightAnswer();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");

        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1)).append(". ").append(options.get(i)).append("\n");
        }

        return sb.toString();
    }
}
