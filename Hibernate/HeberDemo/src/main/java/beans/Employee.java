package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	@ManyToMany(mappedBy="emp")
	private List<Project> projects=new ArrayList<Project>();
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
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
