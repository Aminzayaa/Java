package Assessment;
import java.util.ArrayList;

public class Assessment {
	private int id;
	private String title;
	private String description;
	private ArrayList<String> question;
	private ArrayList<Question> questions;
	
	public Assessment (int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = new ArrayList<Question>();
	}
	public int getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Question> getQuestion(){
		return this.questions;
	}
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	public void removeQuestion(String question) {
		this.questions.remove(question);
	}
	
}
