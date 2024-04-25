import Users.UserRepositoryImplementation;
import Users.UserService;
import Users.UserServiceFactory;
import Utils.PrintUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            UserService userService = UserServiceFactory.getUserService(new UserRepositoryImplementation());
            App app = new App(userService);
            PrintUtil.welcomeText();
            app.start();
        } catch (SQLException e){
            System.out.print("\nInitialisation error");
            e.printStackTrace();
        }
    }
}