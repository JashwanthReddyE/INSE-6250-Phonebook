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
            final int c = Utility.printMenuAndGetValidInput(contactMenu);//"View Contacts", "Add Contact", "Edit Contact", "Delete Contact", "Go Back"};
            switch (c) {
                case 1 -> {viewContacts();}
                case 2 -> {addContact();}
                case 3 -> {editContact();}
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
    private void editContact() {
        ArrayList<User> c = new ArrayList<>();
        PrintUtil.askId();
        int id = Integer.parseInt(sc.nextLine());
        if(userService.check(currentUser,id)){
            c.add(userService.getContact(currentUser,id));
            Utility.printContacts(c);
            User a = new User(currentUser);
            PrintUtil.askFirstName();
            String temp = sc.nextLine();
            while (Utility.isNotValidName(temp)) {
                PrintUtil.notValidName();
                temp = sc.nextLine();
            }a.setFirstName(temp);
            PrintUtil.askLastName();
            temp = sc.nextLine();
            while (Utility.isNotValidName(temp)) {
                PrintUtil.notValidName();
                temp = sc.nextLine();
            }a.setLastName(temp);
            PrintUtil.askCompanyName();
            temp = sc.nextLine();
            while (Utility.isNotValidName(temp)) {
                PrintUtil.notValidName();
                temp = sc.nextLine();
            }a.setCompanyName(temp);
            PrintUtil.askPhone();
            temp = sc.nextLine();
            while (Utility.isNotValidNumber(temp)) {
                PrintUtil.notValidPhone();
                temp = sc.nextLine();
            }a.setPhoneNumber(temp);
            PrintUtil.askEmail();
            temp = sc.nextLine();
            while (Utility.isNotValidEmail(temp)) {
                PrintUtil.notValidEmail();
                temp = sc.nextLine();
            }a.setEmail(temp);
            PrintUtil.askWebsite();
            temp = sc.nextLine();
            while (Utility.isNotValidWebsite(temp)) {
                PrintUtil.notValidWebsite();
                temp = sc.nextLine();
            }a.setWebsite(temp);
            PrintUtil.askAddUnit();
            temp = sc.nextLine();
            a.setAddressCivic(Integer.parseInt(temp));
            PrintUtil.askAddStreet();
            temp = sc.nextLine();
            while (Utility.isNotValidName(temp)) {
                PrintUtil.notValidAddStreet();
                temp = sc.nextLine();
            }a.setAddressStreet(temp);
            PrintUtil.askAddCity();
            temp = sc.nextLine();
            while (Utility.isNotValidName(temp)) {
                PrintUtil.notValidAddCity();
                temp = sc.nextLine();
            }a.setAddressCity(temp);
            PrintUtil.askAddProvince();
            temp = sc.nextLine();
            while (Utility.isNotValidProvince(temp)) {
                PrintUtil.notValidAddProvince();
                temp = sc.nextLine();
            }a.setAddressProvince(temp);
            PrintUtil.askAddPostal();
            temp = sc.nextLine();
            while (Utility.isNotValidPostalCode(temp)) {
                PrintUtil.notValidAddPostal();
                temp = sc.nextLine();
            }a.setAddressPostal(temp);

            if(userService.editContact(currentUser, id, a)){
                System.out.print("\nContact edited successfully!!");
            }else{
                System.out.print("\nContact could not be edited. Please try again.");
            }
        }else{PrintUtil.contactNotExist();}
    }
    private void addContact() {
        User a = new User(currentUser);
        PrintUtil.askFirstName();
        String temp = sc.nextLine();
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
        }a.setFirstName(temp);
        PrintUtil.askLastName();
        temp = sc.nextLine();
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
        }a.setLastName(temp);
        PrintUtil.askCompanyName();
        temp = sc.nextLine();
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidName();
            temp = sc.nextLine();
        }a.setCompanyName(temp);
        PrintUtil.askPhone();
        temp = sc.nextLine();
        while (Utility.isNotValidNumber(temp)) {
            PrintUtil.notValidPhone();
            temp = sc.nextLine();
        }a.setPhoneNumber(temp);
        PrintUtil.askEmail();
        temp = sc.nextLine();
        while (Utility.isNotValidEmail(temp)) {
            PrintUtil.notValidEmail();
            temp = sc.nextLine();
        }a.setEmail(temp);
        PrintUtil.askWebsite();
        temp = sc.nextLine();
        while (Utility.isNotValidWebsite(temp)) {
            PrintUtil.notValidWebsite();
            temp = sc.nextLine();
        }a.setWebsite(temp);
        PrintUtil.askAddUnit();
        temp = sc.nextLine();

        a.setAddressUnit(Integer.parseInt(temp));
        PrintUtil.askAddCivic();
        temp = sc.nextLine();

        a.setAddressCivic(Integer.parseInt(temp));
        PrintUtil.askAddStreet();
        temp = sc.nextLine();
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidAddStreet();
            temp = sc.nextLine();
        }a.setAddressStreet(temp);
        PrintUtil.askAddCity();
        temp = sc.nextLine();
        while (Utility.isNotValidName(temp)) {
            PrintUtil.notValidAddCity();
            temp = sc.nextLine();
        }a.setAddressCity(temp);
        PrintUtil.askAddProvince();
        temp = sc.nextLine();
        while (Utility.isNotValidProvince(temp)) {
            PrintUtil.notValidAddProvince();
            temp = sc.nextLine();
        }a.setAddressProvince(temp);
        PrintUtil.askAddPostal();
        temp = sc.nextLine();
        while (Utility.isNotValidPostalCode(temp)) {
            PrintUtil.notValidAddPostal();
            temp = sc.nextLine();
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
