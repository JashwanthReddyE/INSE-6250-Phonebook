package Ui;


import Users.UserService;
import Utils.Callback;
import Utils.PrintUtil;
import Utils.Utility;

public class AccountsUI {
    private static final String[] accountMenu = new String[]{"Account menu", "Sign Out", "Change Password", "Delete Account", "Go to Home Menu"};//TODO change bio, view salary, implement change password
    private final UserService userService;
    private final String currentUser;
    private final Callback callback;

    public AccountsUI(UserService userService, String currentUser, Callback callback) {
        this.userService = userService;
        this.currentUser = currentUser;
        this.callback = callback;
    }

    public void showAccountMenu() {
        boolean doLoop = true;
        while (doLoop) {
            final int c = Utility.printMenuAndGetValidInput(accountMenu);
            switch (c) {
                case 1 -> {
                    PrintUtil.signedOut();
                    callback.removeCurrentUserExit();
                    doLoop = false;
                }
                case 2 -> {

                }
                case 3 -> {
                    if (userService.deleteUser(currentUser)) {
                        PrintUtil.deletedUserSuccess(currentUser);
                        callback.removeCurrentUserExit();
                        doLoop = false;
                    } else {
                        PrintUtil.deletedUserFail(currentUser);
                        doLoop = true;
                    }
                }
                case 4 -> {
                    callback.exit();
                    doLoop = false;
                }
                default -> {
                    PrintUtil.invalidChoice();
                    doLoop = true;
                }
            }
        }
    }
}
