package Assessment;
import java.util.ArrayList;

public class Question {
	private int id;
	private String text;
	private ArrayList<String> options;
	private int correctAnswer;
	
	public Question(int id, String text, int correctAnswer) {
		this.id = id;
		this.text = text;
		this.options = new ArrayList<>();
		
	}
	public int getId() {
		return this.id;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<String> getOptions(){
		return this.options;
	}
	public void setOptions(ArrayList<String> setOptions) {
		this.options = setOptions;
	}
	public int getCorrectAnswer() {
		return this.correctAnswer;
	}
	public void setCorrectAnswer(int Answer) {
		this.correctAnswer = correctAnswer;
	}
}
