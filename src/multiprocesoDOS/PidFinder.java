package multiprocesoDOS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PidFinder {

	private int getPid(String processName) {
		
	
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "tasklist");
		String pid = null;

		try {
			Process p = pb.start();

		InputStream er = p.getInputStream();
		BufferedReader brer = new BufferedReader(new InputStreamReader(er));
		
		String line = null;
		
		int pos = 29 - processName.length();
		
		while ((line = brer.readLine()) != null)
		{
					if(line.contains(processName.toLowerCase()))
					{String pidFinder[] = line.split(" ");
					pid = pidFinder[pos].toString();
		
					  
					}
		}	
		
		InputStream iS = p.getErrorStream();
		System.out.println();

		int c;
		while((c = iS.read()) != -1)
			System.out.print((char) c);

		iS.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return 0;
	}
	
	
}
