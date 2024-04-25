package Users;

import java.util.ArrayList;

public interface    UserRepository {
    String createUser(String username, String password);
    boolean deleteUser(String username);
    boolean createContact(String username, User person);
    boolean deleteContact(String username, int id);
    boolean editContact(String username, int id, User contact);
    Boolean editName(String username, int id, String fname, String lname);
    ArrayList<User> viewContacts(String username);

    Boolean editCompany(String username, int id, String companyName);

    Boolean editPhone(String username, int id, String phone);
    Boolean editEmail(String username, int id, String email);
    Boolean editWebsite(String username, int id, String Website);
    Boolean editAddress(String username,int id,String newAddUnit,String newAddCivic,String newAddStreet,String newAddCity,String newAddProvince,String newAddPostalCode);

    User getContact(String username, int id);
    String signIn(String username, String pass);
    Boolean check(String username);
    Boolean check(String username, int id);

}
