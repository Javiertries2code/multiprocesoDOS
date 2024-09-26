package multiprocesoDOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textExec;
	private JTextField textCMD;
	private JTextField textFiveExec;
	private  JLabel lblPPID = new JLabel("PPID");
	private JTextArea textAreaFiveExec = null;
	private JTextArea textAreaCMD = null;
	private JLabel lblPidExec = null;
	private JLabel lblPPidExec = null;
	private JLabel lblPidFiveExec = null;
	private JLabel lblPPidFiveExec = null;
	private JLabel lblPPidCmd = null;
	private JLabel lblPidCmd = null;

	






	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExec = new JButton("Start");
		//it gets the command name from the textfiled, and call runprocess, that bringsback the pid
		btnExec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = textExec.getText();
				execGetInfo(command);
				
			}
		});
		btnExec.setBounds(48, 66, 89, 23);
		contentPane.add(btnExec);
		
		JButton btnCMD = new JButton("Start");
		btnCMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = textCMD.getText();
				execCMD(command);
				
			}
		});
		btnCMD.setBounds(181, 66, 89, 23);
		contentPane.add(btnCMD);
		
		JButton btnFiveExec = new JButton("Start");
		btnFiveExec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = textFiveExec.getText();
				execGetInfoFive(command);
			}
		});
		btnFiveExec.setBounds(318, 66, 89, 23);
		contentPane.add(btnFiveExec);
		
		textExec = new JTextField();
		textExec.setBounds(48, 32, 86, 20);
		contentPane.add(textExec);
		textExec.setColumns(10);
		
		textCMD = new JTextField();
		textCMD.setBounds(181, 32, 86, 20);
		contentPane.add(textCMD);
		textCMD.setColumns(10);
		
		textFiveExec = new JTextField();
		textFiveExec.setBounds(318, 35, 86, 20);
		contentPane.add(textFiveExec);
		textFiveExec.setColumns(10);
		
		 textAreaCMD = new JTextArea("");
		textAreaCMD.setBounds(107, 166, 127, 69);
		contentPane.add(textAreaCMD);
		
		 textAreaFiveExec = new JTextArea("");
		textAreaFiveExec.setBounds(282, 166, 127, 69);
		contentPane.add(textAreaFiveExec);
		
		JLabel lblResultado = new JLabel("Resultadp");
		lblResultado.setBounds(10, 171, 67, 14);
		contentPane.add(lblResultado);
		
		JLabel lblPid = new JLabel("PID");
		lblPid.setBounds(10, 106, 46, 14);
		contentPane.add(lblPid);
		lblPPID.setBounds(5, 131, 51, 16);
		contentPane.add(lblPPID);
		
		 lblPidExec = new JLabel();
		lblPidExec.setBounds(66, 100, 68, 14);
		contentPane.add(lblPidExec);
		
		 lblPPidCmd = new JLabel("");
		lblPPidCmd.setBounds(188, 132, 67, 14);
		contentPane.add(lblPPidCmd);
		
		 lblPidCmd = new JLabel("");
		lblPidCmd.setBounds(191, 100, 76, 14);
		contentPane.add(lblPidCmd);
		
		 lblPPidExec = new JLabel("");
		lblPPidExec.setBounds(66, 132, 71, 14);
		contentPane.add(lblPPidExec);
		
		 lblPidFiveExec = new JLabel("");
		lblPidFiveExec.setBounds(297, 100, 127, 47);
		contentPane.add(lblPidFiveExec);
		
		 lblPPidFiveExec = new JLabel("");
		lblPPidFiveExec.setBounds(318, 151, 89, 14);
		contentPane.add(lblPPidFiveExec);
	}
	/**
	 * It runs the process, get pid and ppid, and sets labels
	 * @param command
	 * @param messenger
	 */
	private void execGetInfo(String command) {
		int pid = new Ejer1().runProcess(command);
		int ppid = new PPIDFinder().findPPidNumber(pid);
		System.out.println(pid +"     " +ppid);
		lblPidExec.setText(String.valueOf(pid));
		lblPPidExec.setText(String.valueOf(ppid));

	}
	
	//private void execGetInfoFive(String command, JLabel lblPidFiveExec, JLabel lblPPidFiveExec, JTextArea textAreaFiveExec  ) {
		private void execGetInfoFive(String command ) {

		new Ejer1().runFiveProcess(command, lblPidFiveExec, lblPPidFiveExec, textAreaFiveExec );
		

	}
	
	private void execCMD(String command) {
		int pid;
		int ppid;
	String textArea = new Ejer2().runFromCMD(command);
	pid = new PPIDFinder().findPidName(command);
	ppid = new PPIDFinder().findPPidNumber(pid);
	System.out.println(pid +" xxxx "+ ppid);
	textAreaCMD.setText(textArea);
	lblPidCmd.setText(String.valueOf(pid));
	lblPPidCmd.setText(String.valueOf(ppid));

	}
	
}
