package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.userDAO;
import bean.student;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class studentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_student;
	JTable tablestudent; 
	JScrollPane stuentmessage; 
	String[] strstudent = {"Student ID", "full name", "sex", "age", "class", "major", "department"};  
	String[][] studentList;
	String id = null;
	
	public void gengxin(String[][] studentList) throws Exception {
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
	
	public static String[][] getStudentList() throws Exception {
		userDAO user = new userDAO();
        List<student> list = user.res();
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
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public studentFrame(String id) throws Exception {
		setTitle("student information management system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 659, 513);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("search");
		menuBar.add(mnNewMenu);
		
		//searchscore
		JButton btnNewButton_2 = new JButton("search score");
		mnNewMenu.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectOwnScoreDialog selectScore;
				try {
					selectScore = new selectOwnScoreDialog(id);
					selectScore.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
			
		//search课程
		JButton button_2 = new JButton("search courses");
		mnNewMenu.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectCourseDialog selectCourse = null;
				try {
					selectCourse = new selectCourseDialog();
					selectCourse.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
			
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//初始化表格信息
		studentList = getStudentList();
		gengxin(studentList);	
			
        }
		



}
