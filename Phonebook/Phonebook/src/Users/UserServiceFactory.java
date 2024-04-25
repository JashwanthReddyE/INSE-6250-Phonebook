package Users;

public class UserServiceFactory {
    public static UserService getUserService(UserRepository user) {
        return new UserServiceImplementation(user);
    }
}
