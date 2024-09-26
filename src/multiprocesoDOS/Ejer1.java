package multiprocesoDOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Ejer1 {
	private static final String CLASS_PATH = "C:\\Users\\Javier\\eclipse-workspace\\MultiprocesoDOS\\bin";
	private static final String CLASS_NAME = "multiprocesoDOS/";
	private static final String  FLAG = "-cp";
	
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

	public void runFiveProcess(String command, JLabel lblPidFiveExec, JLabel lblPPidFiveExec, JTextArea textAreaFiveExec  ){
		for (int i = 1; i < 6; i++)
		{
			int pid = executeOurProgram(command, textAreaFiveExec);
			int ppip = new PPIDFinder().findPPidNumber(pid);
			String pidList = lblPidFiveExec.getText();
			lblPPidFiveExec.setText(String.valueOf(pid));
			lblPidFiveExec.setText( pidList + " "+String.valueOf(pid));
		}
		
		
	}

	
public int executeOurProgram(String Command,  JTextArea textAreaFiveExec) {
			
		String className = CLASS_NAME + Command;
		int pid = 0;	
		String alreadyTextArea = textAreaFiveExec.getText();
		
	        ProcessBuilder pB= new ProcessBuilder("java", FLAG, CLASS_PATH, className, "EXECUTING THIS PROGRAM 5 TIMES");

	        String Fulltext = "";
	    	try {
	    		Process p = pB.start();
	    		InputStream iS = p.getErrorStream();
	    		pid = (int) p.pid();
	    		System.out.println();
	    	
	    		int c;
	    		boolean user_fail = false;
	    		while((c = iS.read()) != -1)
	    			{System.out.print((char) c);
	    			user_fail = true;}
	    		if (user_fail)
					System.out.println(
							"SI TIRA FALLO PUEDE SER PORQUE EL USUARIO DE LA MAQUINA DONDE SE EJECUTA EL PROGRAMA, NO COINCIDE CON EL PROPORCIAONADO EN PROCESSBUILDER ");

	    		
	    		iS.close();
	    		
	    	InputStream er = p.getInputStream();
	    	BufferedReader brer = new BufferedReader(new InputStreamReader(er));
	    	String line = null;
	    	
	    	while ((line = brer.readLine()) != null)
	    				Fulltext+=line;
	    		
	    	} catch (Exception e) {
	    		
	    	}
	    	textAreaFiveExec.setText( alreadyTextArea+ "\n"+ Fulltext);
	    	return pid;
	    }
		
	}



