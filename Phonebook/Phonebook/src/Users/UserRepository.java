package Users;

import java.util.ArrayList;

public interface    UserRepository {
    String createUser(String username, String password);
    boolean deleteUser(String username);
    boolean createContact(String username, User person);
    boolean deleteContact(String username, int id);
    boolean editContact(String username, int id, User contact);
    ArrayList<User> viewContacts(String username);
    User getContact(String username, int id);
    String signIn(String username, String pass);
    Boolean check(String username);
    Boolean check(String username, int id);

}
