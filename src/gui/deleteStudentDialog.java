package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.userDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteStudentDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	String sno = null;


	//Delete student
	public boolean deleteStudent(String sno) throws Exception {
		if(sno.length()<1 ) {
			JOptionPane.showMessageDialog(this,"error！");
			return false;
		}
		userDAO user = new userDAO();
		if(user.delete(sno)) {
			JOptionPane.showMessageDialog(this,"Student deleted successfully！");
			return true;
		}
		else
			JOptionPane.showMessageDialog(this,"Failed to delete student, please check if the student ID is correct!");
		return false;
	}

	//构造函数
	public deleteStudentDialog(mainFrame mainFrame) {
		setTitle("Delete student");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(850, 400, 327, 194);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(89, 48, 173, 30);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Student ID：");
		lblNewLabel.setBounds(10, 55, 75, 15);

		//delete按钮
		JButton btnNewButton = new JButton("delete");
		btnNewButton.setBounds(75, 114, 80, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				try {
					if( deleteStudent(sno) ) {
						dispose();
						mainFrame.setVisible(false);
						new mainFrame().setVisible(true);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		//return按钮
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.setBounds(193, 114, 69, 23);
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
	}
}
