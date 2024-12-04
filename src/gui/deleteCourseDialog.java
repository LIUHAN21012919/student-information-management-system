package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.courseDAO;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteCourseDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	String cno = null;

	//delete course
	public boolean deleteCourse(String cno) throws Exception {
		if(cno.length()<1 ) {
			JOptionPane.showMessageDialog(this,"Course number cannot be empty！");
			return false;
		}
		courseDAO course = new courseDAO();
		if(course.delete(cno)) {
			JOptionPane.showMessageDialog(this,"Course deleted successfully！");
			return true;
		}
		else
			JOptionPane.showMessageDialog(this,"Course deletion failed, please check if the course number is correct!");
		return false;
	}

	public deleteCourseDialog() {
		setTitle("delete course");
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

		JLabel lblNewLabel = new JLabel("Course No：");
		lblNewLabel.setBounds(9, 55, 90, 15);

		//delete按钮
		JButton btnNewButton = new JButton("delete");
		btnNewButton.setBounds(75, 114, 85, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cno = textField.getText();
				try {
					if( deleteCourse(cno) ) {
						dispose();
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
