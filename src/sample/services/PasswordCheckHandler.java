package sample.services;

import sample.databases.UserDatabase;

public class PasswordCheckHandler extends Handler {
    private UserDatabase userDatabase = UserDatabase.getInstance();

    @Override
    public boolean check(String login, String password) {
        if (userDatabase.checkLoginAndPassword(login, password)) {
            return checkNext(login, password);
        }

        return false;
    }
}
