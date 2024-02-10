package View;

import Business.UserManager;
import Core.Helper;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminView extends Layout {
    private DefaultTableModel tmdl_user = new DefaultTableModel();
    private Object[] col_user;
    private User user;
    private UserManager userManager;
    private JPopupMenu user_menu;
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_users;
    private JScrollPane scrl_users;
    private JTable tbl_users;
    private JPanel pnl_user_add;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JTextField fld_password;
    private JLabel lbl_password;
    private JLabel lbl_role;
    private JButton btn_save_new_user;
    private JComboBox cmb_user_role;
    private JPanel pnl_search;
    private JComboBox cmb_search_role;
    private JButton btn_search;


    public AdminView(User user) {
        userManager = new UserManager();

        this.user = user;
        add(container);
        guiInitialize(750, 750);
        loadUserTable(null);
        LoadUserComponent();

    }


    public void loadUserTable(ArrayList<Object[]> userList) {
        this.col_user = new Object[]{"ID", "USERNAME", "PASSWORD", "ROLE"};
        if (userList == null) {
            userList = this.userManager.getForTable(this.col_user.length, this.userManager.findAll());
        }
        createTable(this.tmdl_user, this.tbl_users, col_user, userList);
    }

    private void LoadUserComponent() {
        tableRowSelect(this.tbl_users);
        btn_save_new_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] fieldList = {fld_username, fld_password};
                if (Helper.isFieldListEmpty(fieldList)) {
                    Helper.showMsg("fill");
                } else {
                    boolean result;
                    User newUser = new User();
                    newUser.setUsername(fld_username.getText());
                    newUser.setPassword(fld_password.getText());
                    newUser.setRole((String) cmb_user_role.getSelectedItem());
                    result = userManager.save(newUser);

                    if (result) {
                        Helper.showMsg("done");
                    } else {
                        Helper.showMsg("error");
                    }
                }
                loadUserTable(null);
            }
        });
        user_menu = new JPopupMenu();
        this.user_menu.add("Delete").addActionListener(e -> {
            int selectedUserId = this.getTableSelectedRow(tbl_users, 0);
            if (this.userManager.delete(selectedUserId)) {
                Helper.showMsg("done");
                loadUserTable(null);
            } else{
                    Helper.showMsg("error");
                }
            });
        this.tbl_users.setComponentPopupMenu(user_menu);

        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userSearchRole = (String)cmb_search_role.getSelectedItem();
                ArrayList <User> searchedUserList = userManager.findByRole(userSearchRole);
                ArrayList<Object[]> searchedUserRowList = userManager.getForTable(col_user.length, searchedUserList);
                loadUserTable(searchedUserRowList);
            }
        });
        }

    }


