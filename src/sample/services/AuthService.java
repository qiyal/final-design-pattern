package sample.services;

public class AuthService {
    private static AuthService instance;
    private boolean auth = false;
    private String authUserLogin = null;
    private String role = null;
    private Handler handler;


    private AuthService() { }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public boolean login(String login, String password) {
        initHandler();
        if (handler.check(login, password)) {
            authUserLogin = login;
            auth = true;
            return true;
        }
        return false;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private void initHandler() {
        LoginCheckHandler loginCheckHandler = new LoginCheckHandler();
        PasswordCheckHandler passwordCheckHandler = new PasswordCheckHandler();
        DefineUserRoleHandler defineUserRoleHandler = new DefineUserRoleHandler();

        passwordCheckHandler.setNext(defineUserRoleHandler);
        loginCheckHandler.setNext(passwordCheckHandler);

        handler = loginCheckHandler;
    }

}
