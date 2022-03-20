import javax.persistence.NoResultException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Users user = new Users("Ethan", 25);
        Users user2 = new Users("William", 10);
        Users user3 = new Users("Jack", 35);
        Users user4 = new Users("Robert", 17);
        Users user5 = new Users("Alexander", 40);
        UserService.addUser(user);
        UserService.addUser(user2);
        UserService.addUser(user3);
        UserService.addUser(user4);
        UserService.addUser(user5);

        Users user6 = new Users("Noah", 19);
        UserService.editUser(10, user6);

        UserService.deleteUserByName("Alexander");

        try {
            Users userByName = UserService.findUserByName("Alexander");
            System.out.println(userByName);
        } catch (NoResultException nre) {
            System.out.println("No user with entered name.");
        }

        try {
            Users userByName = UserService.findUserByName("Jack");
            System.out.println(userByName);
        } catch (NoResultException nre) {
            System.out.println("No user with entered name.");
        }


        List<Users> list = UserService.findUsersByAgeFrom10To34();
        for (Users showUser: list) {
            System.out.println(showUser);
        }

        UserService.clearUsersTable();
    }
}
