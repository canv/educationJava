package VideoLessons.ch3;

class User {
    private long fullId;
    private String login;
    private String password;

    User(long id, String log, String pass) {
        fullId = id;
        login = log;
        password = pass;
    }

    void setFullId (long fID) {fullId = fID;}
    void setLogin (String log) {login = log;}
    void setPassword (String pass) {password = pass;}

    long getFullId () {return fullId;}
    String getLogin () {return login;}
    String  getPassword () {return password;}

    void showUserInfo() {
        System.out.println("\nUser info: " +
                "\nid <" + fullId + "> " +
                "\nLogin <" + login + "> " +
                "\nPassword <" + password + ">");
    }
}

public class Lesson2 {
    public static void main(String[] args) {
        User person1 = new User(
                275250120,
                "papakarlo81",
                "chikibrikichikchirik");
        User person2 = new User(
                995496820,
                "mashaUzheMamasha2007",
                "verniMneM0i2007");

        person1.showUserInfo();
        person2.showUserInfo();
    }
}

