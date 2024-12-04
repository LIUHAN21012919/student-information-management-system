package gui;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.courseDAO;
import bean.course;

import javax.swing.JTable;
import javax.swing.JScrollPane;


public class selectCourseDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_course;
	JTable tableCourse;
	JScrollPane courseMessage;
	String[] strCourse = {"Serial Number", "Course No", "Course name", "credit", "class hour"};  //表格标题
	String[][] courseList;

	public void gengxin(String[][] courseList) throws Exception {
		tm_course = new TableModel();
		tm_course.setColumnNames(strCourse);

        contentPane.setLayout(new BorderLayout(0, 0));
        tableCourse = new JTable(tm_course);
        courseMessage = new JScrollPane(tableCourse);
        contentPane.add(courseMessage);
		try {
			tm_course.setMessages(courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String[][] getCourseList() throws Exception {
		courseDAO user = new courseDAO();
        List<course> list = user.courseRes();
        String[][] courses = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
        	courses[i][0] = list.get(i).getCnum();
        	courses[i][1] = list.get(i).getCno();
        	courses[i][2] = list.get(i).getCname();
        	courses[i][3] = list.get(i).getCcredit();
        	courses[i][4] = list.get(i).getCtime();
        }
        return courses;
    }

	public selectCourseDialog() throws Exception {
		setTitle("student information management system");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 350, 480, 320);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		courseList = getCourseList();
		gengxin(courseList);

     }

}
