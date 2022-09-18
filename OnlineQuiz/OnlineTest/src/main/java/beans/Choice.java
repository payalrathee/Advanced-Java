package beans;

import javax.persistence.*;

@Entity
public class Choice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String choice;
	@ManyToOne
	private Question ques;
	
	public Choice() {
		// TODO Auto-generated constructor stub
	}
	public Choice(String choice,Question ques) {
		this.choice = choice;
		this.ques=ques;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Question getQues() {
		return ques;
	}
	public void setQues(Question ques) {
		this.ques = ques;
	}
	
	
}
