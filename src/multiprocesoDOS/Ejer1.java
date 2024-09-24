package multiprocesoDOS;

import java.io.IOException;

public class Ejer1 {

	
	public void runProcess(String processName) {
		// TODO Auto-generated method stub
	
		ProcessBuilder processBuilder = new  ProcessBuilder(processName);
		
		
		try {
			Process proceso = processBuilder.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

