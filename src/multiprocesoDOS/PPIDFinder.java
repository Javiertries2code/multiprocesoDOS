package multiprocesoDOS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PPIDFinder {

	public int findPidName(String ProcessName) {
		int p_pid = 0;
		
		String	command = "ProcessId";
		
		
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
			// TO-DO it is possible to run the line using is digit or smthg
			while ((line = brer.readLine()) != null && count++ < 6) {

				if (count == 4)
					p_pid = Integer.parseInt(line.trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p_pid;
	}

	public int findPPidName(String ProcessName) {
		int p_pid = 0;

		String command = "ParentProcessId";

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
			// TO-DO it is possible to run the line using is digit or smthg
			while ((line = brer.readLine()) != null && count++ < 6) {

				if (count == 4)
					p_pid = Integer.parseInt(line.trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p_pid;
	}

	public int findPPidNumber(int pid) {
		int p_pid = 0;

		String command = "ParentProcessId";

		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "wmic process where ProcessId=" + pid + " get " + command);

		
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
			// TO-DO it is possible to run the line using is digit or smthg
			while ((line = brer.readLine()) != null && count++ < 8) {
				line = line.trim();
				
				if (!line.isEmpty() && Character.isDigit(line.charAt(0)))
					{
					p_pid = Integer.parseInt(line);
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p_pid;
	}
}
