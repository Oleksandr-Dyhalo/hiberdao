import javax.persistence.*;
import java.util.*;

public class UserDAO {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("module7");

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(Users user) {

        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(user);
        entityTransaction.commit();
    } //добавить пользователя

    public void editUser(int id, Users user) {

        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Users newUser = entityManager.find(Users.class, id);
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());

        entityManager.persist(newUser);
        entityTransaction.commit();
    } //редактировать пользователя

    public Users findUserByName(String username) throws NoResultException {

        entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT i FROM Users i WHERE i.username = :username1";

        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class).setParameter("username1", username);
        Users userToFind = typedQuery.getSingleResult();

        return userToFind;
    } //поиск пользователя по имени

    public List<Users> findUsersByAgeFrom10To34() {

        entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT i FROM Users i WHERE i.age >= 10 AND i.age < 35";

        TypedQuery<Users> typedQuery = entityManager.createQuery(query, Users.class);
        List<Users> usersFrom10To34 = typedQuery.getResultList();

        return usersFrom10To34;
    } //поиск пользователей от 10 до 34 лет

    public void deleteUserByName(String username) {

        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "DELETE FROM Users i WHERE i.username = :username1";

        entityManager.createQuery(query).setParameter("username1", username).executeUpdate();
    } //удалить пользователя по имени

    public void clearUsersTable() {

        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String clear = "DELETE FROM Users users";

        entityManager.createQuery(clear).executeUpdate();
    } //очистить таблицу
}
