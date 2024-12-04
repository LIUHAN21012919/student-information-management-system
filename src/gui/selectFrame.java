package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class selectFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_student;
	JTable tablestudent; 
	JScrollPane stuentmessage; 
	String[] strstudent = {"Student ID", "full name", "sex", "age", "class","major", "department"};  //表格标题

	public selectFrame(String[][] studentList) throws Exception {
		setTitle("student information management system");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(730, 310, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		tm_student = new TableModel();  
	    tm_student.setColumnNames(strstudent);
        contentPane.setLayout(new BorderLayout(0, 0));
        tablestudent = new JTable(tm_student);  
        stuentmessage = new JScrollPane(tablestudent);  
        contentPane.add(stuentmessage);
		try {
			tm_student.setMessages(studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
		
}
