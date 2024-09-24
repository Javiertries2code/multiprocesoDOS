package multiprocesoDOS;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer2 {
	
	public String  runFromCMD(String command) {
		
	ProcessBuilder pb = new ProcessBuilder("CMD", "/C", command);
	String Fulltext = "";
	try {
		Process p = pb.start();
		InputStream iS = p.getErrorStream();
		System.out.println();
	
		int c;
		while((c = iS.read()) != -1)
			System.out.print((char) c);
	
		iS.close();
		
	InputStream er = p.getInputStream();
	BufferedReader brer = new BufferedReader(new InputStreamReader(er));
	String line = null;
	
	while ((line = brer.readLine()) != null)
				Fulltext+=line;
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return Fulltext;
}
}
