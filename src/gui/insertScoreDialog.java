package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.scoreDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class insertScoreDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JButton button;
	private JButton button_1;
	String sno = null;
	String cno = null;
	String sscore = null;

	//录入score
	public boolean insertScore(String sno, String cno, String sscore) throws SQLException {
		if(sno.length()<1 || cno.length()<1 || sscore.length()<1 ) {
			JOptionPane.showMessageDialog(this,"error！");
			return false;
		}
		scoreDAO scoreDAO = new scoreDAO();
		boolean istrue = scoreDAO.insert(sno, cno, sscore);
		if(istrue) {
			JOptionPane.showMessageDialog(this,"success！");
			return true;
		}else
			JOptionPane.showMessageDialog(this,"fail！");
		return false;
	}
	//构造函数
	public insertScoreDialog() {
		setTitle("Increase student grades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(800, 350, 431, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(115, 38, 206, 30);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(115, 86, 206, 32);
		textField_1.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(115, 136, 206, 32);
		textField_5.setColumns(10);
		JLabel label = new JLabel("Student ID：");
		label.setBounds(30, 45, 100, 15);

		JLabel label_1 = new JLabel("Course No：");
		label_1.setBounds(30, 94, 80, 15);

		JLabel label_2 = new JLabel("grade:");
		label_2.setBounds(30, 145, 60, 15);

		button = new JButton("add");
		button.setBounds(117, 191, 73, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				cno = textField_1.getText();
				sscore = textField_5.getText();

				try {
					if( insertScore(sno, cno, sscore) ) {
						dispose();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		button_1 = new JButton("return");
		button_1.setBounds(241, 191, 73, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_5);
		contentPane.add(button);
		contentPane.add(button_1);
	}

}
