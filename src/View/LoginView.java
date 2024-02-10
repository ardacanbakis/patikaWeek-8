package View;

import Business.UserManager;
import Core.Helper;
import Entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JButton btn_login;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private UserManager userManager;




    public LoginView() {
        this.userManager = new UserManager();
        this.add(container);
        guiInitialize(400,400);

        loginButton();
//  JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//  JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);



    }
            public void loginButton(){
                btn_login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField[] fieldList = {fld_username, fld_password};

                        if (Helper.isFieldListEmpty(fieldList)) {
                            Helper.showMsg("fill");
                        } else {
                            User loginUser = userManager.findByLogin(fld_username.getText(), fld_password.getText());
                            if (loginUser == null) {
                                Helper.showMsg("notFound");
                            } else if (loginUser.getRole().equals("ADMIN")) {
                                AdminView adminView = new AdminView(loginUser);
                                dispose();
                            } else if (loginUser.getRole().equals("STAFF")) {
                                StaffView staffView = new StaffView(loginUser);
                                dispose();
                            }
                        }
                    }
                });

            }
    }
