package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ques;
	@OneToMany(mappedBy="ques")
	private List<Choice> choices=new ArrayList<Choice>();
	@OneToOne
	private Choice ans;
	@ManyToOne
	private Topic topic;
	
	
	public Question() {
		
	}
	public Question(int id, String ques, List<Choice> choices, Choice ans, Topic topic) {
		this.id = id;
		this.ques = ques;
		this.choices = choices;
		this.ans = ans;
		this.topic = topic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public List<Choice> getChoices() {
		return choices;
	}
	public void setOptions(List<Choice> choices) {
		this.choices = choices;
	}
	public Choice getAns() {
		return ans;
	}
	public void setAns(Choice ans) {
		this.ans = ans;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
	
}
