package beans;

import javax.persistence.*;

@Entity
public class Trainee {
	@Id
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="trainerId")
	private Trainer trainer;
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
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	

}
