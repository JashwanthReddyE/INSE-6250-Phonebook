package Users;

import java.util.ArrayList;

public interface UserService {
    String createUser(String username, String password);
    boolean deleteUser(String username);
    boolean createContact(String username, User person);
    boolean deleteContact(String username, int id);
    boolean editContact(String username, int id, User contact);
    User getContact(String username, int id);
    ArrayList<User> viewContacts(String username);
    String signIn(String username, String pass);
    Boolean check(String username);
    Boolean check(String username, int id);
}
