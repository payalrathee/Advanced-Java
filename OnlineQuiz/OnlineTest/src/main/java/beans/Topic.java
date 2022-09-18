package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy="topic")
	private List<Question> questions=new ArrayList<Question>();
	
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	public Topic(int id, String name,List<Question> ques) {
		this.id = id;
		this.name = name;
		this.questions=ques;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	

}
