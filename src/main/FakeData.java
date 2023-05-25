package main;

import medicine.Medicine;

// 임의 데이터 입력 
public class FakeData {

	public FakeData() {
		
		// 액터 (의사, 간호사, 환자)
		
		
		// 약 
		new Medicine("m_0001", "타이레놀", "두통, 해열, 진통", "m-a");
		new Medicine("m_0002", "타이레놀이알서방정", "두통, 해열, 극심한 진통", "m-a1");
		new Medicine("m_0003", "타이레놀콜드", "두통, 해열, 진통, 감기, 콧물", "m-a2");
		new Medicine("m_0004", "타이레놀우먼", "두통, 해열, 진통, 생리통", "m-a3");
		new Medicine("m_0005", "타이레놀키즈", "두통, 해열, 진통", "m-a4");
	}
	
	
}
