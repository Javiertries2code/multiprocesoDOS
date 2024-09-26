package multiprocesoDOS;

import java.io.IOException;

public class Ejer1 {

	
	public int runProcess(String processName) {
		// TODO Auto-generated method stub
	int pid = 0;
		ProcessBuilder processBuilder = new  ProcessBuilder(processName);
		
		
		try {
			Process proceso = processBuilder.start();
			pid = (int) proceso.pid();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return pid;
	}

}

