package multiprocesoDOS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PPIDFinder {

	public int findPidCmd(String ProcessName, String command) {
		int p_pid = 0;
		if (command.equalsIgnoreCase("pid"))
			command = "ProcessId";
		else if (command.equalsIgnoreCase("pid"))
			command = "ParentProcessId";
		else
			return -1;
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C",
				"wmic process where name=\"" + ProcessName + "\" get " + command);

		try {
			Process p = pb.start();
			InputStream iS = p.getErrorStream();
			System.out.println();

			int c;
			while ((c = iS.read()) != -1)
				System.out.print((char) c);

			iS.close();

			InputStream er = p.getInputStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String line = null;
			int count = 1;
			while ((line = brer.readLine()) != null && count++ < 6) {
			
				if (count == 4)
					p_pid = Integer.parseInt(line.trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p_pid;
	}
}
