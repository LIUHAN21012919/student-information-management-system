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
import java.awt.event.ActionEvent;

public class deleteScoreDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	String sno = null;
	String cno = null;
	private JTextField textField_1;

	//Delete studentscore
	public boolean deleteScore(String sno, String cno) throws Exception {
		if(cno.length()<1 || sno.length()<1) {
			JOptionPane.showMessageDialog(this,"error！");
			return false;
		}
		scoreDAO score = new scoreDAO();
		if(score.delete(sno,cno)) {
			JOptionPane.showMessageDialog(this,"success！");
			return true;
		}
		else
			JOptionPane.showMessageDialog(this,"Grade deletion failed, please check if the student ID and course ID are correct");
		return false;
	}

	public deleteScoreDialog() {
		setTitle("Delete grades");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(850, 400, 327, 241);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(89, 48, 173, 30);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Student ID：");
		lblNewLabel.setBounds(8, 55, 72, 15);

		//delete按钮
		JButton btnNewButton = new JButton("delete");
		btnNewButton.setBounds(89, 150, 85, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				cno = textField_1.getText();
				try {
					if( deleteScore(sno,cno) ) {
						dispose();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		//return按钮
		JButton btnNewButton_1 = new JButton("return");

		btnNewButton_1.setBounds(193, 150, 69, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(89, 96, 173, 30);
		contentPane.add(textField_1);

		JLabel label = new JLabel("Course No：");
		label.setBounds(8, 103, 90, 15);
		contentPane.add(label);
	}
}
