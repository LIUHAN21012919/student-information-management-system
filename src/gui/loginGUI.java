package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.studentDAO;
import DAO.userDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class loginGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private String id = null;
    private String password = null;
    JComboBox<Object> comboBox = new JComboBox<Object>();
    String identify = "administrator";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginGUI frame = new loginGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //检查输入信息是否为空
    public boolean checkNull(String id, String pwd) {
        if (id.length() < 1 || pwd.length() < 1) {
            JOptionPane.showMessageDialog(null, "error！");
            return false;
        }
        return true;
    }

    //登录
    public void login(String id, String password) throws Exception {
        boolean istrue = false;
        userDAO log = new userDAO();
        try {
            istrue = log.LoginCheck(id, password);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if (istrue) {
            mainFrame mainFrame = new mainFrame();
            mainFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "fail！", "fail", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void studentlogin(String username, String password) throws Exception {
        boolean istrue = false;
        studentDAO log = new studentDAO();
        try {
            istrue = log.LoginCheck(username, password); // 调用LoginCheck方法时传递的是用户名
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if (istrue) {
            studentFrame studentFrame = new studentFrame(username); // 传递用户名到学生主界面
            studentFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "fail！", "fail", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Create the frame.
     */
    public loginGUI() {
        setTitle("student information management system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(650, 350, 576, 377);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //登录按钮
        JButton btnNewButton = new JButton("login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                identify = (String) comboBox.getSelectedItem();
                id = textField.getText();
                password = String.valueOf(passwordField.getPassword());
                switch (identify) {
                    case "administrator":
                        if (checkNull(id, password))
                            try {
                                login(id, password);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        break;

                    case "student":
                        if (checkNull(id, password))
                            try {
                                studentlogin(id, password);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        break;
                }
            }
        });
        btnNewButton.setBounds(176, 247, 93, 35);
        contentPane.add(btnNewButton);

        //注册按钮
        JButton button = new JButton("register");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//				int iden = 0;
//				if (identify.equals("?????")) {
//					iden = 1;
//				}
                registerGUI register = new registerGUI();
                register.setVisible(true);
            }
        });
        button.setBounds(306, 247, 93, 35);
        contentPane.add(button);

        textField = new JTextField();
        textField.setFont(new Font("????", Font.PLAIN, 16));
        textField.setBounds(176, 129, 223, 35);
        contentPane.add(textField);
        textField.setColumns(10);


        comboBox.setMaximumRowCount(4);
        comboBox.setModel(new DefaultComboBoxModel<Object>(new String[]{"administrator", "student"}));
        comboBox.setSelectedIndex(0);
        comboBox.setToolTipText("");
        comboBox.setBounds(176, 91, 223, 28);
        contentPane.add(comboBox);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("????", Font.PLAIN, 16));
        passwordField.setBounds(176, 182, 223, 35);
        contentPane.add(passwordField);

        JLabel lblQeqew = new JLabel("student information management system");
        lblQeqew.setHorizontalAlignment(SwingConstants.CENTER);
        lblQeqew.setFont(new Font("????", Font.PLAIN, 20));
        lblQeqew.setBounds(101, 27, 373, 46);
        contentPane.add(lblQeqew);

        JLabel lblNewLabel = new JLabel("user name：");
        lblNewLabel.setBounds(100, 140, 100, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("password：");
        lblNewLabel_1.setBounds(100, 190, 100, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("identity：");
        lblNewLabel_2.setBounds(100, 98, 100, 15);
        contentPane.add(lblNewLabel_2);
    }
}
