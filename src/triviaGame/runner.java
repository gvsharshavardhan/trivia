package triviaGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class runner {
	
	static Scanner sc;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		Quiz q1 = new Quiz("Harry Potter Trivia");
//		q1.addQuestion(new Question("capital of india?","delhi"));
//		q1.addQuestion(new Question("capital of andra pradesh?","hyderabad"));	
//		System.out.println(q1);
		
//		File file = 
//			      new File("C:\\Users\\Vguggilam\\Desktop\\trivia.txt"); 
//			    try {
//					sc = new Scanner(file);
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//			  
//			    int i = 1;
//			    while (sc.hasNextLine()) {
//			    	if(i%2==1) {
//			    		q1.addQuestion(new Question("capital of india?","delhi"));
//			    	}
//			      System.out.println(sc.nextLine()); }	
		
		List<String> questions = new ArrayList<String>();
		List<String> answers = new ArrayList<String>();
			    
			    File fileIn1 = new File("C:\\Users\\Vguggilam\\Desktop\\trivia.txt");
			    
		        try (BufferedReader bf = new BufferedReader(new FileReader(fileIn1))) {//SURROUND WITH try with resources FOR THE EXCEPTIONS		 
		            String readLine;
		            int line = 0;	 
		            while ((readLine = bf.readLine()) != null) {
		                if (line % 2 != 0) {//CHECKING WHETHER THE ROW IS ODD
//		                    System.out.println(readLine);
		                    answers.add(readLine);
		                }
		                else {
		                	questions.add(readLine);
		                }
		                line++;
		            }		 
		        }
		        
		        for(int i=0;i<questions.size();i++) {
		        	q1.addQuestion(new Question(questions.get(i),answers.get(i)));
		        }
		        System.out.println("let`s play " + q1.getName() + "! \n");
		        
		        int question_count = 1;
		        int wrong_ans_count_flag = 0;
		        int score = 0;
		        while(question_count < 4) {	        	
		        	Question qq = q1.getRandomQuestion();
		        	System.out.println(qq.getText());
		        	Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		        	System.out.print("Enter a answer: ");  
		        	String str= sc.nextLine();              //reads string   
		        	if(str.equalsIgnoreCase(qq.getAnswer())) {
		        		score = score + 1;
		        		System.out.println("Correct! [Score: "+score+"]");
		        	}else {
		        		wrong_ans_count_flag = wrong_ans_count_flag + 1;
		        		System.out.println("Incorrect. The correct answer is " 
		        		+ qq.getAnswer() + " [Strike "+wrong_ans_count_flag+"]");
		        	}		        	
		        	if(wrong_ans_count_flag==3) {
		        		System.out.println("you lose the game :(");
		        		break;
		        	}
		        	question_count+=1;
		        }
		        
		        System.out.println("Done with the quiz !!");
	}

}
