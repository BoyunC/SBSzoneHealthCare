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
	
	
}
