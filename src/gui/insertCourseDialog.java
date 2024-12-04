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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class insertCourseDialog extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_4;
	private JButton button;
	private JButton button_1;
	private JLabel label_5;
	String cno = null;
	String cname = null;
	String ccredit = null;
	String ctime = null;

	//增加课程信息
	public boolean insertCourse(String cno, String cname, String ccredit, String ctime) throws SQLException {
		if(cno.length()<1 || cname.length()<1 || ccredit.length()<1 || ctime.length()<1 ) {
			JOptionPane.showMessageDialog(this,"error！");
			return false;
		}
		courseDAO courseDAO = new courseDAO();
		boolean istrue = courseDAO.insert(cno, cname, ccredit, ctime);
		if(istrue) {
			JOptionPane.showMessageDialog(this,"success！");
			return true;
		}else
			JOptionPane.showMessageDialog(this,"error！");
		return false;
	}

	//构造函数
	public insertCourseDialog() {
		setTitle("Add courses");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(800, 350, 431, 332);
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

		textField_4 = new JTextField();
		textField_4.setBounds(115, 186, 206, 32);
		textField_4.setColumns(10);
		JLabel label = new JLabel("Course No：");
		label.setBounds(10, 45, 100, 15);

		JLabel label_1 = new JLabel("Course name");
		label_1.setBounds(10, 94, 100, 15);

		JLabel label_2 = new JLabel("class hour:");
		label_2.setBounds(10, 145, 100, 15);

		label_5 = new JLabel("course credits");
		label_5.setBounds(10, 196, 100, 15);

		button = new JButton("add");
		button.setBounds(80, 250, 100, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cno = textField.getText();
				cname = textField_1.getText();
				ccredit = textField_5.getText();
				ctime = textField_4.getText();
				try {
					if( insertCourse(cno, cname,  ccredit, ctime) ) {
						dispose();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		button_1 = new JButton("return");
		button_1.setBounds(234, 250, 73, 23);
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
		contentPane.add(textField_4);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(label_5);
	}

}
