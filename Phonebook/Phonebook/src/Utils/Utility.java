package Utils;

import Users.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static final Scanner sc = new Scanner(System.in);
    public static int printMenuAndGetValidInput(String[] menuItems) {
        printMenu(menuItems);
        return readInteger();
    }
    public static int readInteger() {
        System.out.print("\nEnter : ");
        String c = sc.nextLine();
        try {
            Integer.parseInt(c);
            if (Integer.parseInt(c) == -1) {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.print("\nInvalid Integer.Enter a proper Integer");
            return readInteger();
        }
        return Integer.parseInt(c);
    }
    public static boolean isNotValidUsername(String name) {
        String regex = "\\w{6,30}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        if (!m.matches()) {
            System.out.print("\nString length not in range");
            return true;
        }
        regex = "^[a-z][a-z0-9]*$";
        p = Pattern.compile(regex);
        m = p.matcher(name);
        if (!m.matches()) {
            System.out.print("\nDoes not start with alphabet or contains unaccepted characters");
            return true;
        }
        regex = "^[a-z]\\w{5,29}$";
        p = Pattern.compile(regex);
        m = p.matcher(name);
        return !m.matches();
    }
    public static void printMenu(String[] menuItems) {
        System.out.print("\n\n" + menuItems[0]);
        for (int i = 1; i < menuItems.length; i++) {
            System.out.printf("\n%d. %s", i, menuItems[i]);
        }
    }
    public static boolean isNotValidName(String name) {
        String regex = "\\p{L}+[\\p{L}\\p{Pd}\\p{Zs}']*\\p{L}+$|^\\p{L}+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        if (!m.matches()) {
            System.out.print("\nThe text entered is not valid.");
            return true;
        }
        return !m.matches();
    }

    public static boolean isNotValidEmail(String email) {
        String regex = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(!m.matches()) {System.out.print("\nThe text entered is not a valid email address.");return true;}
        return !m.matches();
    }
    public static boolean isNotValidWebsite(String web) {
        try {
            new URL(web).toURI();
            return false;
        }
        catch (Exception e) {
            System.out.print("\nThe website entered is not a valid URL/Website.");
            return true;
        }
    }
    public static boolean isNotValidPhoneNumber(String num) {
        String regex = "^[+][1]\\d{3}\\.\\d{3}\\.\\d{4}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(num);
        if(!m.matches()) {System.out.print("\nThe Phone number entered is not valid. Enter the Phone number in the format +1xxx.xxx.xxxx");return true;}
        return !m.matches();
    }
    public static boolean isNotValidNumber(String num) {
        String regex = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(num);
        if(!m.matches()) {System.out.print("\nThe number entered is not valid. Enter a positive integer");return true;}
        return !m.matches();
    }
    public static boolean isNotValidProvince(String province) {
        String regex = "^[A-Z][A-Z]$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(province);
        if(!m.matches()) {System.out.print("\nThe Province entered is not valid. Enter the province in the format XX");return true;}
        return !m.matches();
    }
    public static boolean isNotValidPostalCode(String postal) {
        String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(postal);
        if(!m.matches()) {System.out.print("\nThe Postal code entered is not valid. Enter the postal code in the format ANA NAN (A represents an alphabetical, N represents a number.\n You can use a space 0r '-' no space in between.)");return true;}
        return !m.matches();
    }
    public static void printContacts(ArrayList<User> contacts) {
        System.out.print("\nContact:\nId | firstName | lastName | company | username | phoneNumber | email | website | addressUnit | addressCivic | addressStreet | addressCity | addressProvince | addressPostal\n");
        for (User i:contacts) {
            //System.out.printf("\n"+);
            i.print();
        }
    }
}
