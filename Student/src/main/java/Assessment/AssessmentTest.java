package Assessment;
import java.util.ArrayList;

public class AssessmentTest {

    public static void main(String[] args) {

        Question q1 = new Question(1, "What is color the sky?", 1);
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("red");
        options1.add("blue");
        options1.add("yellow");
        options1.add("green");
        q1.setOptions(options1);

        Question q2 = new Question(2, "Which month comes after December?", 1);
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("january");
        options2.add("march");
        options2.add("july");
        options2.add("april");
        q2.setOptions(options2);

        Assessment assessment = new Assessment(1, "", "");
        assessment.addQuestion(q1);
        assessment.addQuestion(q2);

        System.out.println("Assessment :");
        ArrayList<Question> questions = assessment.getQuestion();
        for (Question question : questions) {
            System.out.println("\nQuestion ID: " + question.getId());
            System.out.println("Question Text: " + question.getText());
            System.out.println("Options:");
            ArrayList<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println("Zow hariu: Option " + question.getCorrectAnswer());
        }
    }
}