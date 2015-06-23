package university.dao.userDao;


import university.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void deleteUser(User user);
    List getAllUsers();
    User findUserByName(String name);

}
