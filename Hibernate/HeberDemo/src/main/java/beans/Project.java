package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Project {
	@Id
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(
			name="ProEmp",
			joinColumns= {@JoinColumn(name="pid")},
			inverseJoinColumns={@JoinColumn(name="eid")}
			)
	private List<Employee> emp=new ArrayList<Employee>();
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
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	

}
