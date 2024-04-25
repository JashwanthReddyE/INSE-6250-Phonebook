import Ui.AccountsUI;
import Users.User;
import Users.UserService;
import Utils.Callback;
import Utils.PrintUtil;
import Utils.Utility;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static final Scanner sc = new Scanner(System.in);


    private static final String[] homeMenu = new String[]{"Home Menu", "Contacts", "My Account", "SignOut",};
    private static final String[] contactMenu = new String[]{"Contact Menu", "View Contacts", "Add Contact", "Edit Contact", "Delete Contact", "Go Back"};
    private static final String[] startMenu = new String[]{"Start Menu", "SignIn", "Register", "Exit"};
    private static final String[] editMenu = new String[]{"Edit Menu","edit Name", "edit Company", "edit Phone", "edit Email", "edit Website", "edit Address", "go back to contact Menu"};

    private final UserService userService;
    private String currentUser = null;
    private final Callback callback = new Callback() {
        @Override
        public void exit() {
            showHomeMenu();
        }

        @Override
        public void removeCurrentUserExit() {
            currentUser = null;
            start();
        }
    };


    public App(UserService userService) {
        this.userService = userService;
    }

    private boolean isValidPass(String pass) {
        final Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher = p.matcher(pass);
        return matcher.matches();
    }

    public void showHomeMenu() {
        boolean loopVar = true;
        while (loopVar) {
            final int c = Utility.printMenuAndGetValidInput(homeMenu);//"Contacts", "My Account", "SignOut",};
            switch (c) {
                case 1 -> {//View COntact Menu
                    showContactMenu();
                }
                case 2 -> {
                    new AccountsUI(userService, currentUser, callback).showAccountMenu();
                    loopVar = false;
                }
                case 3 -> {PrintUtil.signedOut();loopVar = false;
                    callback.removeCurrentUserExit();
                    }
                case (-1) -> {System.exit(0);}
                default -> PrintUtil.invalidChoice();
            }
        }
    }
    public void showContactMenu() {
        boolean loopVar = true;
        while (loopVar) {
            final int c = Utility.printMenuAndGetValidInput(contactMenu);
            switch (c) {
                case 1 -> {viewContacts();}
                case 2 -> {addContact();}
                case 3 -> {showEditMenu();}
                case 4 -> {deleteContact();}
                case 5 -> {loopVar = false;}
                case (-1) -> {System.exit(0);}
                default -> PrintUtil.invalidChoice();
            }
        }
    }

    private void viewContacts() {
        ArrayList<User> a = userService.viewContacts(currentUser);
        Utility.printContacts(a);
    }

    public void showEditMenu() {
        ArrayList<User> c = new ArrayList<>();
        PrintUtil.askId();
        int id = Integer.parseInt(sc.nextLine());
        while(userService.check(currentUser,id)){
            c.add(userService.getContact(currentUser,id));
            Utility.printContacts(c);
            final int d = Utility.printMenuAndGetValidInput(editMenu);
            switch (d) {
                case 1 -> {editName(id);}
                case 2 -> {editCompany(id);}
                case 3 -> {editPhone(id);}
                case 4 -> {editEmail(id);}
                case 5 -> {editWebsite(id);}
                case 6 -> {editAddress(id);}
                case 7 -> {showContactMenu();}
                case (-1) -> {System.exit(0);}
                default -> PrintUtil.invalidChoice();
            }
        }
    }

    private void editName(int id){
        PrintUtil.askFirstName();
        String newFirstName = sc.nextLine();
        if ("-1".equals(newFirstName)) {System.exit(0);}
        while (Utility.isNotValidName(newFirstName)) {
            PrintUtil.notValidName();
            newFirstName = sc.nextLine();
            if ("-1".equals(newFirstName)) {System.exit(0);}
        }
        PrintUtil.askLastName();
        String newLastName = sc.nextLine();
        if ("-1".equals(newLastName)) {System.exit(0);}
        while (Utility.isNotValidName(newLastName)) {
            PrintUtil.notValidName();
            newLastName = sc.nextLine();
            if ("-1".equals(newLastName)) {System.exit(0);}
        }
        userService.editName(currentUser,id,newFirstName, newLastName);
    }

    private void editCompany(int id) {
        PrintUtil.askCompanyName();
        String newCompany = sc.nextLine();
        if ("-1".equals(newCompany)) {System.exit(0);}
        while (Utility.isNotValidName(newCompany)) {
            PrintUtil.notValidCompany();
            newCompany = sc.nextLine();
            if ("-1".equals(newCompany)) {System.exit(0);}
        }
        userService.editCompany(currentUser,id,newCompany);
    }

    private void editPhone(int id) {
        PrintUtil.askPhone();
        String newPhone = sc.nextLine();
        if ("-1".equals(newPhone)) {System.exit(0);}
        while (Utility.isNotValidPhoneNumber(newPhone)) {
            PrintUtil.notValidPhone();
            newPhone = sc.nextLine();
            if ("-1".equals(newPhone)) {System.exit(0);}
        }
        userService.editPhone(currentUser,id,newPhone);
    }

    private void editEmail(int id) {
        PrintUtil.askEmail();
        String newEmail = sc.nextLine();
        if ("-1".equals(newEmail)) {System.exit(0);}
        while (Utility.isNotValidEmail(newEmail)) {
            PrintUtil.notValidEmail();
            newEmail = sc.nextLine();
            if ("-1".equals(newEmail)) {System.exit(0);}
        }
        userService.editEmail(currentUser, id, newEmail);
    }


    private void editWebsite(int id) {
        PrintUtil.askWebsite();
        String newWebsite = sc.nextLine();
        if ("-1".equals(newWebsite)) {System.exit(0);}
        while (Utility.isNotValidWebsite(newWebsite)) {
            PrintUtil.notValidWebsite();
            newWebsite = sc.nextLine();
            if ("-1".equals(newWebsite)) {System.exit(0);}
        }
        userService.editWebsite(currentUser,id,newWebsite);
    }

    private void editAddress(int id) {
        PrintUtil.askAddUnit();
        String newAddUnit = sc.nextLine();
        if ("-1".equals(newAddUnit)) {System.exit(0);}
        while (Utility.isNotValidNumber(newAddUnit)) {
            PrintUtil.notValidAddUnit();
            newAddUnit = sc.nextLine();
            if ("-1".equals(newAddUnit)) {System.exit(0);}
        }
        PrintUtil.askAddCivic();
        String newAddCivic = sc.nextLine();
        if ("-1".equals(newAddCivic)) {System.exit(0);}
        while (Utility.isNotValidNumber(newAddCivic)) {
            PrintUtil.notValidAddCivic();
            newAddCivic = sc.nextLine();
            if ("-1".equals(newAddCivic)) {System.exit(0);}
        }
        PrintUtil.askAddStreet();
        String newAddStreet = sc.nextLine();
        if ("-1".equals(newAddStreet)) {System.exit(0);}
        while (Utility.isNotValidName(newAddStreet)) {
            PrintUtil.notValidAddStreet();
            newAddStreet = sc.nextLine();
            if ("-1".equals(newAddStreet)) {System.exit(0);}
        }
        PrintUtil.askAddCity();
        String newAddCity = sc.nextLine();
        if ("-1".equals(newAddCity)) {System.exit(0);}
        while (Utility.isNotValidName(newAddCity)) {
            PrintUtil.notValidAddStreet();
            newAddCity = sc.nextLine();
            if ("-1".equals(newAddCity)) {System.exit(0);}
        }
        PrintUtil.askAddProvince();
        String newAddProvince = sc.nextLine();
        if ("-1".equals(newAddProvince)) {System.exit(0);}
        while (Utility.isNotValidProvince(newAddProvince)) {
            PrintUtil.notValidAddProvince();
            newAddProvince = sc.nextLine();
            if ("-1".equals(newAddProvince)) {System.exit(0);}
        }
        PrintUtil.askAddPostal();
        String newAddPostalCode = sc.nextLine();
        if ("-1".equals(newAddPostalCode)) {System.exit(0);}
        while (Utility.isNotValidPostalCode(newAddPostalCode)) {
            PrintUtil.notValidAddPostal();
            newAddPostalCode = sc.nextLine();
            if ("-1".equals(newAddPostalCode)) {System.exit(0);}
        }
        userService.editAddress(currentUser, id, newAddUnit,newAddCivic, newAddStreet, newAddCity, newAddProvince, newAddPostalCode);
    }


    private void addContact() {
        User a = new User(currentUser);
        PrintUtil.askFirstName();
        String temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setFirstName(temp);
        PrintUtil.askLastName();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setLastName(temp);
        PrintUtil.askCompanyName();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setCompanyName(temp);
        PrintUtil.askPhone();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidPhoneNumber(temp)) {
            PrintUtil.notValidPhone();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setPhoneNumber(temp);
        PrintUtil.askEmail();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidEmail(temp)) {
            PrintUtil.notValidEmail();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setEmail(temp);
        PrintUtil.askWebsite();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidWebsite(temp)) {
            PrintUtil.notValidWebsite();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setWebsite(temp);
        PrintUtil.askAddUnit();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidNumber(temp)) {
            PrintUtil.notValidNumber();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressUnit(Integer.parseInt(temp));
        PrintUtil.askAddCivic();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidNumber(temp)) {
            PrintUtil.notValidNumber();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressCivic(Integer.parseInt(temp));
        PrintUtil.askAddStreet();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidAddStreet();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressStreet(temp);
        PrintUtil.askAddCity();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidAddCity();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressCity(temp);
        PrintUtil.askAddProvince();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidProvince(temp)) {
            PrintUtil.notValidAddProvince();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressProvince(temp);
        PrintUtil.askAddPostal();
        temp = sc.nextLine();
        if ("-1".equals(temp)) {System.exit(0);}
        while (Utility.isNotValidPostalCode(temp)) {
            PrintUtil.notValidAddPostal();
            temp = sc.nextLine();
            if ("-1".equals(temp)) {System.exit(0);}
        }a.setAddressPostal(temp);

        if(userService.createContact(this.currentUser, a)){PrintUtil.createdContact(a.getFirstName());}
    }
    private void deleteContact() {
        PrintUtil.askId();
        int id = Integer.parseInt(sc.nextLine());
        if(userService.check(currentUser, id)){if(userService.deleteContact(currentUser, id)){PrintUtil.deletedContact();}}
        else{PrintUtil.couldNotDeleteContact();}
    }

    public void start() {
        while (true) {
            final int c = Utility.printMenuAndGetValidInput(startMenu);
            switch (c) {
                case 3 -> System.exit(0);
                case 2 -> {
                    currentUser = registerUser();
                    PrintUtil.askLogin();
                    final int d = Utility.readInteger();
                    switch (d) {
                        case 1 -> {
                            currentUser = signInUser(currentUser);
                            if (currentUser != null) {
                                showHomeMenu();
                            }
                        }
                        case 2 -> {
                            currentUser = null;
                            PrintUtil.exitLogin();
                        }
                        default -> {
                            PrintUtil.invalidChoice();
                            PrintUtil.exitLogin();
                        }
                    }
                }
                case 1 -> {
                    currentUser = signInUser();
                    if (currentUser != null) {
                        showHomeMenu();
                    }
                }
                case (-1) -> {System.exit(0);}
                default -> PrintUtil.invalidChoice();
            }
        }
    }
    private String registerUser() {
        PrintUtil.askUsername();
        String username = sc.nextLine();
        while (Utility.isNotValidUsername(username)) {
            PrintUtil.notValidUsername();
            username = sc.nextLine();
        }
        while (userService.check(username)) {
            PrintUtil.existUser();
            username = sc.nextLine();
        }
        PrintUtil.askPass();
        String pass = sc.nextLine();
        while (!isValidPass(pass)) {
            PrintUtil.notValidPass();
            pass = sc.nextLine();
        }
        String user = userService.createUser(username, pass);
        PrintUtil.createdUser(user);
        return username;
    }
    private String signInUser() {
        PrintUtil.askUsername();
        String username = sc.nextLine();
        while (Utility.isNotValidUsername(username)) {
            PrintUtil.notValidUsername();
            username = sc.nextLine();
        }
        if (userService.check(username)) {
            PrintUtil.askPass();
            final String pass = sc.nextLine();
            String name = userService.signIn(username, pass);
            if (name == null) {
                PrintUtil.notValidPass();
                return signInUser(username);
            } else {
                PrintUtil.signedIn(username);
                return name;
            }
        } else {
            PrintUtil.userNotExist();
            return null;
        }
    }

    private String signInUser(String username) {
        if (userService.check(username)) {
            PrintUtil.askPass();
            final String pass = sc.nextLine();
            String name = userService.signIn(username, pass);
            if (name == null) {
                PrintUtil.wrongPass();
                return signInUser(username);
            } else {
                PrintUtil.signedIn(username);
                return name;
            }
        } else {
            PrintUtil.userNotExist();
            return null;
        }
    }
}
