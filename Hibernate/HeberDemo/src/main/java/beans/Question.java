package beans;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	private int qid;
	private String ques;
	@OneToOne
	@JoinColumn(name="aid")
	private Answer ans;
	
	
	public Answer getAns() {
		return ans;
	}
	public void setAns(Answer ans) {
		this.ans = ans;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	

}
