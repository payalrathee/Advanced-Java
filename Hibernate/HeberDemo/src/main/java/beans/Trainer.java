package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trainer {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="trainer")
	
	private List<Trainee> trainees=new ArrayList<Trainee>();
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
	public List<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	

}
