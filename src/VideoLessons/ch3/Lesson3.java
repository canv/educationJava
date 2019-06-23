package VideoLessons.ch3;

class Users {
    private long fullId;
    private String login;
    private String password;

    Users(long id, String log, String pass) {
        fullId = id;
        login = log;
        password = pass;
    }

    void showUserInfo() {
        System.out.println("\nUser info: " +
                "\nid <" + fullId + "> " +
                "\nLogin <" + login + "> " +
                "\nPassword <" + password + ">");
    }

    long getFullId() {
        return fullId;
    }
    String getPassword() {
        return password;
    }
    String getLogin() {
        return login;
    }

    void setFullId() {
        setFullId(100_000_000);
    }
    void setPassword() {
        setPassword("Example_password");
    }
    void setLogin() {
        setLogin("Example_login");
    }
    private void setFullId(long id) {
        fullId = id;
    }
    private void setPassword(String pass) {
        password = pass;
    }
    private void setLogin(String log) {
        login = log;
    }
}

