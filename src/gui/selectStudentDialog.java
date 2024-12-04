package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.userDAO;
import bean.student;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class selectStudentDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String sno = null;
	String name = null;
	String[][] studentList;

	public String[][] selectStudent(String sno, String Sname) throws Exception {
		userDAO user = new userDAO();
		List<student> list = user.Select(sno, Sname);
		String[][] strings = new String[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            strings[i][0] = Integer.toString(list.get(i).getSno());
            strings[i][1] = list.get(i).getName();
            strings[i][2] = list.get(i).getGender();
            strings[i][3] = Integer.toString(list.get(i).getAge());
            strings[i][4] = list.get(i).getClas();
            strings[i][5] = list.get(i).getMajor();
            strings[i][6] = list.get(i).getDept();
        }
        return strings;
	}


	public void selectstu(String sno, String name) {
		try {
			if( sno.length()<1 )
				JOptionPane.showMessageDialog(this,"error！");
			else {
				studentList = selectStudent(sno, name);
				if (studentList.length < 1) {
					JOptionPane.showMessageDialog(this,"no！");
				}else {
					selectFrame selectFrame = new selectFrame(studentList);
					selectFrame.setVisible(true);
					dispose();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public selectStudentDialog() {

		setTitle("search student");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(850, 400, 369, 237);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(90, 40, 196, 30);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setBounds(10, 47, 80, 15);

		textField_1 = new JTextField();
		textField_1.setBounds(90, 98, 196, 30);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("name:");
		lblNewLabel_1.setBounds(10, 105, 80, 15);

		//search
		JButton btnNewButton = new JButton("search");
		btnNewButton.setBounds(90, 159, 70, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sno = textField.getText();
				name = textField_1.getText();
				try {
					selectstu(sno, name);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		//return按钮
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.setBounds(213, 159, 73, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(textField_1);
		contentPane.add(textField);
	}
}
