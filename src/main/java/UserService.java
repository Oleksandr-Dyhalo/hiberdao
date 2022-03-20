import java.util.List;

public class UserService {

    private static final UserDAO userDAO = new UserDAO();

    public static void addUser(Users user) {
        userDAO.addUser(user);
    }

    public static void deleteUserByName(String username) {

        userDAO.deleteUserByName(username);
    }

    public static void editUser(int id, Users user) {

        userDAO.editUser(id, user);
    }

    public static Users findUserByName(String username) {

        return userDAO.findUserByName(username);
    }

    public static List<Users> findUsersByAgeFrom10To34() {

        return userDAO.findUsersByAgeFrom10To34();
    }

    public static void clearUsersTable() {

        userDAO.clearUsersTable();
    }
}
