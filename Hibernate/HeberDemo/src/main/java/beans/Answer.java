package beans;

import javax.persistence.*;

@Entity
public class Answer {
	@Id
	private int aid;
	private String ans;
	@OneToOne(mappedBy="ans")
	@JoinColumn(name="qid")
	private Question ques;
	
	public Question getQues() {
		return ques;
	}
	public void setQues(Question ques) {
		this.ques = ques;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	

}
