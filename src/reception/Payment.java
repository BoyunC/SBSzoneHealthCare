package reception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment {
	private int total;
	private Date date;
	private String method;
	
	public static List<Payment> paymentList = new ArrayList<Payment>();
	
	//Constructor
	public Payment() {}

	public Payment(int total, Date date, String method) {
		super();
		this.total = total;
		this.date = date;
		this.method = method;
	}

	
	// getter setter
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public static List<Payment> getPaymentList() {
		return paymentList;
	}

	public static void setPaymentList(List<Payment> paymentList) {
		Payment.paymentList = paymentList;
	}
	
	
}
