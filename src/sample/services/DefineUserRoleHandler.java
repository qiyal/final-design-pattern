package sample.services;

import sample.databases.UserDatabase;

public class DefineUserRoleHandler extends Handler {
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private AuthService authService = AuthService.getInstance();

    @Override
    public boolean check(String login, String password) {
        if (userDatabase.isAdmin(login)) {
            authService.setRole("admin");
        }
        authService.setRole("client");

        return checkNext(login, password);
    }
}
