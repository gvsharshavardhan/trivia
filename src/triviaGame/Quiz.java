package triviaGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
	
	String name;
	List<Question> questions = new ArrayList<Question>();
	Random rand = new Random();

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public Quiz(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
	}
	
	public Question getRandomQuestion() {
		List<Question> tempq = questions;
		return tempq.remove(rand.nextInt(questions.size()));
	}

	@Override
	public String toString() {
		String output = "";
		output = name + "\n";
		for(Question s:questions) {
			output=output+"\n"+s.text;
		}	
		return  output ;
	}
	
	

}
