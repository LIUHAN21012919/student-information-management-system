package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class mainFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableModel tm_student;
	JTable tablestudent;
	JScrollPane stuentmessage;
	String[] strstudent = {"Student ID", "full name", "sex", "age", "class", "major", "department"};  //表格标题
	String[][] studentList;

	public void gengxin(String[][] studentList) throws Exception {
		tm_student = new TableModel();  //新建表格模型
	    tm_student.setColumnNames(strstudent);//加入表格标题

        contentPane.setLayout(new BorderLayout(0, 0));

        tablestudent = new JTable(tm_student);  //将表格模型加入表格
        stuentmessage = new JScrollPane(tablestudent);  //将表格加入scrollpanel
        contentPane.add(stuentmessage);
		try {
			tm_student.setMessages(studentList); //将search出来的数据放入表格
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取存放学生对象的列表
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
	public mainFrame() throws Exception {
		setTitle("student information management system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 659, 513);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mainFrame mainFrame = this; //���˴��ڶ�����Ϊ����


		JMenu mnNewMenu = new JMenu("search");
		menuBar.add(mnNewMenu);

		JButton btnNewButton = new JButton("search student");
		mnNewMenu.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectStudentDialog selectStudentDialog = new selectStudentDialog();
				selectStudentDialog.setVisible(true);
			}
		});

		//searchscore
		JButton btnNewButton_2 = new JButton("search grades");
		mnNewMenu.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectScoreDialog selectScore;
				try {
					selectScore = new selectScoreDialog();
					selectScore.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		//search课
		JButton button_2 = new JButton("Course Inquire");
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


		//插入
		JMenu menu_1 = new JMenu("add");
		menuBar.add(menu_1);
		//录入学生
		JButton btnNewButton_1 = new JButton("add student");
		menu_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertStudentDialog insertStudentDialog = new insertStudentDialog(mainFrame);
				insertStudentDialog.setVisible(true);
			}
		});

		//录入score
		JButton button_7 = new JButton("add score");
		menu_1.add(button_7);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertScoreDialog insertScoreDialog = new insertScoreDialog();
				insertScoreDialog.setVisible(true);
			}
		});

		//录入课程信息
		JButton button_8 = new JButton("add course");
		menu_1.add(button_8);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertCourseDialog insertCourseDialog = new insertCourseDialog();
				insertCourseDialog.setVisible(true);
			}
		});


		//更新
		JMenu mnNewMenu_1 = new JMenu("update");
		menuBar.add(mnNewMenu_1);
		//更新学生
		JButton button_1 = new JButton("update student");
		mnNewMenu_1.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudentDialog updateStudentDialog = new updateStudentDialog(mainFrame);
				updateStudentDialog.setVisible(true);
			}
		});

		//更新score
		JButton button_3 = new JButton("update grades");
		mnNewMenu_1.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateScoreDialog updateScoreDialog = new updateScoreDialog();
				updateScoreDialog.setVisible(true);
			}
		});

		//更新课程
		JButton button_4 = new JButton("update course");
		mnNewMenu_1.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCourseDialog updateCourseDialog = new updateCourseDialog();
				updateCourseDialog.setVisible(true);
			}
		});

		//delete
		JMenu menu = new JMenu("delete");
		menuBar.add(menu);
		//Delete student
		JButton button = new JButton("delete student");
		menu.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudentDialog deleteStudentDialog = new deleteStudentDialog(mainFrame);
				deleteStudentDialog.setVisible(true);
			}
		});

		//deletescore
		JButton button_5 = new JButton("delete grade");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteScoreDialog deleteScoreDialog = new deleteScoreDialog();
				deleteScoreDialog.setVisible(true);
			}
		});
		menu.add(button_5);

		//delete course
		JButton button_6 = new JButton("delete course");
		menu.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCourseDialog deleteCourseDialog = new deleteCourseDialog();
				deleteCourseDialog.setVisible(true);
			}
		});

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//初始化表格
		studentList = getStudentList();
		gengxin(studentList);



        }




}
