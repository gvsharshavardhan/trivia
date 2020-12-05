package triviaGame;

public class Question {
	
	String text;
	String answer;
	
	public Question() {
		
	}
	@Override
	public String toString() {
		return  this.text ;
	}
	public Question(String text, String answer) {
		super();
		this.text = text;
		this.answer = answer;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
