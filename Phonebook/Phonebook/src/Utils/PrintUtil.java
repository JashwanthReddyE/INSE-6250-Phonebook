package Utils;

public class PrintUtil {
    public static void welcomeText() {
        System.out.print("\nAhoy! mate. Welcome to the App\n\t\t\t\t-A Personalised PhoneBook Application\n\n Usage Instructions :-\n\t-In any Menu, exit application by pressing -1\n\t-Navigate using number input based on available choices.");
    }
    public static void invalidChoice() {
        System.out.print("\nInvalid Choice");
    }
    public static void askLogin() {
        System.out.print("\nWould you like to login. 1. Yes 2. No");
    }
    public static void exitLogin() {
        System.out.print("\nLogin aborted");
    }
    public static void askFirstName() {
        System.out.print("\nEnter your First Name : ");
    }
    public static void askLastName() {
        System.out.print("\nEnter your Last Name : ");
    }
    public static void askCompanyName() {
        System.out.print("\nEnter your Company Name : ");
    }
    public static void askPhone() {
        System.out.print("\nEnter your Phone Number : ");
    }
    public static void askId() {
        System.out.print("\nEnter the id of Contact : ");
    }
    public static void askAddUnit() {
        System.out.print("\nEnter your Address Unit : ");
    }
    public static void askAddCivic() {
        System.out.print("\nEnter your Address Civic : ");
    }
    public static void askAddStreet() {
        System.out.print("\nEnter your Address Street : ");
    }
    public static void askAddCity() {
        System.out.print("\nEnter your Address City : ");
    }
    public static void askAddProvince() {
        System.out.print("\nEnter your Address Province : ");
    }
    public static void askAddPostal() {
        System.out.print("\nEnter your Address Postal : ");
    }
    public static void notValidPhone() {
        System.out.print("\nThe Phone Number is not valid: ");
    }
    public static void notValidCompany() {
        System.out.print("\nThe Company Name is not valid: ");
    }
    public static void askWebsite() {
        System.out.print("\nEnter your Website : ");
    }
    public static void notValidWebsite() {
        System.out.print("\nThe Website entered is not Valid. Please retry.");
    }
    public static void askEmail() {
        System.out.print("\nEnter your Email id : ");
    }
    public static void notValidEmail() {
        System.out.print("\nThe Email entered is not Valid. Please retry.");
    }
    public static void notValidAddUnit() {
        System.out.print("\nThe Address Unit entered is not Valid. Please retry.");
    }
    public static void notValidAddCivic() {
        System.out.print("\nThe Address Civic entered is not Valid. Please retry.");
    }
    public static void createdContact(String firstname) {
        System.out.print("\nThe Contact "+firstname+" has been created successfully.");
    }
    public static void notValidAddStreet() {
        System.out.print("\nThe Address Street entered is not Valid. Please retry.");
    }
    public static void notValidAddCity() {
        System.out.print("\nThe Address City entered is not Valid. Please retry.");
    }
    public static void notValidAddProvince() {
        System.out.print("\nThe Address Province entered is not Valid. Please retry.");
    }
    public static void notValidNumber() {
        System.out.print("\nThe Number is not Valid. Please retry.");
    }
    public static void notValidAddPostal() {
        System.out.print("\nThe Address Postal entered is not Valid. Please retry.");
    }
    public static void askUsername() {
        System.out.print("\nEnter your username : ");
    }
    public static void notValidUsername() {
        System.out.print("\nUsername must consist of 6-30 characters starting with a lowercase alphabet and made of alphabets and numbers.\nEnter again : ");
    }
    public static void notValidName() {
        System.out.print("\nThe Given name is not Valid. Please Retry using a valid name.");
    }
    public static void existUser() {
        System.out.print("\nUsername taken.Try a different username\nEnter : ");
    }
    public static void askPass() {
        System.out.print("\nEnter your password : ");
    }
    public static void notValidPass() {
        System.out.print("\nInvalid Password.Must contain one digit,one Lowercase character,one Upper case character,one special case character and must be between 8 to 20 characters in length.\nEnter again : ");
    }
    public static void wrongPass() {
        System.out.print("\nWrong Password.Try again");
    }
    public static void createdUser(String user) {
        System.out.print("\nUser " + user + " created successfully");
    }
    public static void signedIn(String username) {
        System.out.print("\nUser " + username + " successfully signed in.");
    }
    public static void userNotExist() {
        System.out.print("\nUsername entered does not exist.");
    }
    public static void contactNotExist() {
        System.out.print("\nContact Id entered does not exist.");
    }
    public static void signedOut() {
        System.out.print("\nSuccessfully Signed out");
    }
    public static void deletedUserSuccess(String currentUser) {
        System.out.print("\nUser " + currentUser + " deleted successfully");
    }
    public static void deletedUserFail(String currentUser) {
        System.out.print("\nUser " + currentUser + " couldn't be deleted");
    }
    public static void deletedContact() {System.out.print("\nThe contact has been deleted Successfully.");}
    public static void couldNotDeleteContact() {System.out.println("\nThe contact does not exist or the contact has already been deleted.");}
}