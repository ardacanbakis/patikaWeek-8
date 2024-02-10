package Business;

import Core.Helper;
import Dao.UserDao;
import Entity.User;

import java.util.ArrayList;

public class UserManager {

    private UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public User findByLogin(String username, String password) {
        return this.userDao.findByLogin(username, password);
    }

    public ArrayList<User> findAll() {
        return userDao.findAll();
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<User> userList) {
        ArrayList<Object[]> userObjList = new ArrayList<>();
        for (User user : userList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = user.getUser_id();
            rowObject[i++] = user.getUsername();
            rowObject[i++] = user.getPassword();
            rowObject[i++] = user.getRole();
            userObjList.add(rowObject);
        }
        return userObjList;
    }

    public boolean save(User newUser) {
        if (newUser.getUser_id() != 0) {
            Helper.showMsg("error");
        }
        return this.userDao.save(newUser);
    }

    public boolean delete(int selectedUserId) {
//        if (this.getUser_id(selectedUserId) == null){
//            Helper.showMsg(selectedUserId+ "Couldn't be found.");
//            return false;
//        }
        return userDao.delete(selectedUserId);
    }

    public ArrayList<User> findByRole(String userSearchRole) {
        return userDao.findByRole(userSearchRole);
    }
}
