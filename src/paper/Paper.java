package paper;

import java.util.Date;

public class Paper {
	private Date printDate;
	private Date examDate; 
	private int numOfPaper;
	//private Hospital hospital;
	//private Diagnosis diagnosis;
	
	
	//Constructor
	public Paper() {}
	
	public Paper(Date printDate, Date examDate, int numOfPaper) {
		super();
		this.printDate = printDate;
		this.examDate = examDate;
		this.numOfPaper = numOfPaper;
	}

	
	//Getter Setter
	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getNumOfPaper() {
		return numOfPaper;
	}

	public void setNumOfPaper(int numOfPaper) {
		this.numOfPaper = numOfPaper;
	}
	
	
}
