package multiprocesoDOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textExec;
	private JTextField textCMD;
	private JTextField textFiveExec;
	private final JLabel lblPPID = new JLabel("PPID");

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
		btnExec.setBounds(48, 66, 89, 23);
		contentPane.add(btnExec);
		
		JButton btnCMD = new JButton("Start");
		btnCMD.setBounds(181, 66, 89, 23);
		contentPane.add(btnCMD);
		
		JButton btnFiveExec = new JButton("Start");
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
		
		JTextArea textAreaCMD = new JTextArea();
		textAreaCMD.setBounds(107, 153, 127, 82);
		contentPane.add(textAreaCMD);
		
		JTextArea textAreaFiveExec = new JTextArea();
		textAreaFiveExec.setBounds(282, 153, 127, 82);
		contentPane.add(textAreaFiveExec);
		
		JLabel lblResultado = new JLabel("Resultadp");
		lblResultado.setBounds(10, 158, 67, 14);
		contentPane.add(lblResultado);
		
		JLabel lblPid = new JLabel("PID");
		lblPid.setBounds(10, 106, 46, 14);
		contentPane.add(lblPid);
		lblPPID.setBounds(5, 131, 51, 16);
		contentPane.add(lblPPID);
		
		JLabel lblPidExec = new JLabel();
		lblPidExec.setBounds(66, 100, 46, 14);
		contentPane.add(lblPidExec);
		
		JLabel lblPPidCmd = new JLabel();
		lblPPidCmd.setBounds(188, 132, 46, 14);
		contentPane.add(lblPPidCmd);
		
		JLabel lblPidCmd = new JLabel();
		lblPidCmd.setBounds(191, 100, 46, 14);
		contentPane.add(lblPidCmd);
		
		JLabel lblPPidExec = new JLabel("");
		lblPPidExec.setBounds(66, 132, 46, 14);
		contentPane.add(lblPPidExec);
		
		JLabel lblPidFiveExec = new JLabel();
		lblPidFiveExec.setBounds(318, 100, 46, 14);
		contentPane.add(lblPidFiveExec);
		
		JLabel lblPPidFiveExec = new JLabel();
		lblPPidFiveExec.setBounds(318, 132, 46, 14);
		contentPane.add(lblPPidFiveExec);
	}
}
