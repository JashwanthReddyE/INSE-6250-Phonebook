package Users;


import Utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryImplementation implements UserRepository {
    private static final String insert_user = "INSERT into users" + "(username,password) VALUES" + " (?,?);";
    private static final String delete_user = "DELETE FROM users where username = \"%s\";";
    private static final String check_user = "Select username from users where username=\"%s\";";
    private static final String signing_user = "Select password from users where username=\"%s\";";
    private static final String insert_contact = "INSERT into contacts(firstname, lastname, companyname, username, phone, email, website, addunit, addcivic, addstreet, addcity, addprovince, addpostal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String delete_contact = "DELETE FROM contacts where username = \"%s\" and id = \"%s\";";
    private static final String view_contacts = "SELECT id, firstname, lastname, companyname, phone, email, website, addunit, addcivic, addstreet, addcity, addprovince, addpostal FROM contacts where username = \"%s\";";
    private static final String get_contact = "SELECT id, firstname, lastname, companyname, phone, email, website, addunit, addcivic, addstreet, addcity, addprovince, addpostal FROM contacts where username = \"%s\" and id = \"%s\";";
    private static final String check_contact = "SELECT id from contacts where username = \"%s\" and id = \"%s\";";
    private static final String update_contact = "UPDATE contacts SET firstname = ?, lastname = ?, companyname = ?, phone = ?, email = ?, website = ?, addunit = ?, addcivic = ?, addstreet = ?, addcity = ?, addprovince = ?, addpostal = ? where username = ? and id = ?;";
    private static final Connection connection = DatabaseUtils.getConnection();

    public UserRepositoryImplementation() throws SQLException {
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS users(username text, password text, created DATETIME DEFAULT CURRENT_TIMESTAMP)");
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS contacts(id INTEGER PRIMARY KEY AUTOINCREMENT,firstname text,lastname TEXT, companyname text, username text NOT NULL,phone TEXT," +
                "email text,created DATETIME DEFAULT CURRENT_TIMESTAMP,website TEXT,addunit INTEGER,addcivic INTEGER,addstreet TEXT,addcity TEXT,addprovince TEXT,addpostal TEXT);");
    }

    @Override
    public String createUser(String username, String password) {
        try (PreparedStatement pst = connection.prepareStatement(insert_user)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();
            return username;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteUser(String username) {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(String.format(delete_user, username));
            return true;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean createContact(String username, User person) {
        try (PreparedStatement pst = connection.prepareStatement(insert_contact)) {
            pst.setString(1, person.getFirstName());
            pst.setString(2, person.getLastName());
            pst.setString(3, person.getCompanyName());
            pst.setString(4, username);
            pst.setString(5, person.getPhoneNumber());
            pst.setString(6, person.getEmail());
            pst.setString(7, person.getWebsite());
            pst.setInt(8, person.getAddressUnit());
            pst.setInt(9, person.getAddressCivic());
            pst.setString(10, person.getAddressStreet());
            pst.setString(11, person.getAddressCity());
            pst.setString(12, person.getAddressProvince());
            pst.setString(13, person.getAddressPostal());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteContact(String username, int id) {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(String.format(delete_contact, username, id));
            return true;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editContact(String username, int id, User person) {
        try (PreparedStatement pst = connection.prepareStatement(update_contact)) {
            pst.setString(1, person.getFirstName());
            pst.setString(2, person.getLastName());
            pst.setString(3, person.getCompanyName());
            pst.setString(4, person.getPhoneNumber());
            pst.setString(5, person.getEmail());
            pst.setString(6, person.getWebsite());
            pst.setInt(7, person.getAddressUnit());
            pst.setInt(8, person.getAddressCivic());
            pst.setString(9, person.getAddressStreet());
            pst.setString(10, person.getAddressCity());
            pst.setString(11, person.getAddressProvince());
            pst.setString(12, person.getAddressPostal());
            pst.setString(13, username);
            pst.setInt(14, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return false;
    }
    @Override
    public User getContact(String username, int id){
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(String.format(get_contact, username, id));
            User a = new User(username);
            if(rs.next()){
                //id, firstname, lastname, phone, email, website, addunit, addcivic, addstreet, addcity, addprovince, addpostal
                a.setId(rs.getInt("id"));
                a.setFirstName(rs.getString("firstname"));
                a.setLastName(rs.getString("lastname"));
                a.setCompanyName(rs.getString("companyname"));
                a.setPhoneNumber(rs.getString("phone"));
                a.setEmail(rs.getString("email"));
                a.setWebsite(rs.getString("website"));
                a.setAddressUnit(rs.getInt("addunit"));
                a.setAddressCivic(rs.getInt("addcivic"));
                a.setAddressStreet(rs.getString("addstreet"));
                a.setAddressCity(rs.getString("addcity"));
                a.setAddressProvince(rs.getString("addprovince"));
                a.setAddressPostal(rs.getString("addpostal"));
            }
            return a;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<User> viewContacts(String username) {
        ArrayList<User> contacts = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(String.format(view_contacts, username));
            while(rs.next()){
                User a = new User(username);
                a.setId(rs.getInt("id"));
                a.setFirstName(rs.getString("firstname"));
                a.setLastName(rs.getString("lastname"));
                a.setCompanyName(rs.getString("companyname"));
                a.setPhoneNumber(rs.getString("phone"));
                a.setEmail(rs.getString("email"));
                a.setWebsite(rs.getString("website"));
                a.setAddressUnit(rs.getInt("addunit"));
                a.setAddressCivic(rs.getInt("addcivic"));
                a.setAddressStreet(rs.getString("addstreet"));
                a.setAddressCity(rs.getString("addcity"));
                a.setAddressProvince(rs.getString("addprovince"));
                a.setAddressPostal(rs.getString("addpostal"));
                contacts.add(a);
            }
            return contacts;
        } catch (SQLException e) {
            System.out.print("\n3 " + e.getMessage());
        }
        return null;
    }
    @Override
    public String signIn(String username, String pass) {
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(String.format(signing_user, username));
            if (rs.next()) {
                if (rs.getString("password").equals(pass)) {
                    return username;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.print("\n4 " + e.getMessage());
        }
        return null;
    }
    @Override
    public Boolean check(String username) {
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(String.format(check_user, username));
            if (rs.next() && rs.getString("username").equals(username)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.print("\n6 " + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean check(String username, int id) {
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(String.format(check_contact, username, id));
            if (rs.next() && (rs.getInt("id")==id)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.print("\n6 " + e.getMessage());
        }
        return false;
    }
}
