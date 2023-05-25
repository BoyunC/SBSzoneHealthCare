package reception;

import scanner.DataInput;

public class ReceptionMain {

	public static void main(String[] args) {
		ReceptionManager rm = new ReceptionManager();
		
		System.out.println("1.수납 2.출력");
		System.out.print("메뉴 선택: ");
		String menu = DataInput.sc.nextLine();


		while (true) {
			switch (menu) {
			case "1":
				rm.paymentFunction();
				break;
			case "2":
				rm.printPaper();
				break;
			} 
			break;
		}

	}

}
