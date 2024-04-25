package Users;

import java.util.ArrayList;

public class UserServiceImplementation implements UserService {
    private final UserRepository user;

    public UserServiceImplementation(UserRepository user) {
        this.user = user;
    }

    @Override
    public String createUser(String username, String password) {
        return user.createUser(username,password);
    }

    @Override
    public boolean deleteUser(String username) {
        return user.deleteUser(username);
    }

    @Override
    public boolean createContact(String username, User person) {
        return user.createContact(username, person);
    }

    @Override
    public boolean deleteContact(String username, int id) {
        return user.deleteContact(username, id);
    }

    @Override
    public boolean editContact(String username, int id, User contact) {
        return user.editContact(username,id,contact);
    }

    @Override
    public User getContact(String username, int id) {
        return user.getContact(username,id);
    }

    @Override
    public ArrayList<User> viewContacts(String username) {
        return user.viewContacts(username);
    }

    @Override
    public String signIn(String username, String pass) {
        return user.signIn(username,pass);
    }

    @Override
    public Boolean check(String username) {
        return user.check(username);
    }

    @Override
    public Boolean check(String username, int id) {
        return user.check(username, id);
    }
}
